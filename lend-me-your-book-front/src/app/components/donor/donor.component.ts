import { Component, OnChanges, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/common/book';
import { City } from 'src/app/common/city';
import { Donation } from 'src/app/common/donation';
import { School } from 'src/app/common/school';
import { State } from 'src/app/common/state';
import { User } from 'src/app/common/user';
import { DonorService } from 'src/app/services/donor.service';

@Component({
  selector: 'app-donor',
  templateUrl: './donor.component.html',
  styleUrls: ['./donor.component.css'],
})
export class DonorComponent implements OnInit, OnChanges {
  levels = [1, 2, 3, 4, 5, 6];
  litteralLevel = [
    'السنة الأولى ',
    'السنة الثانية ',
    'السنة الثالثة ',
    'السنة الرابعة ',
    'السنة الخامسة ',
    'السنة السادسة ',
  ];
  subjects = [
    'SCIENCE',
    'MATH',
    'TECHNOLOGY',
    'ARABIC',
    'FRENCH',
    'ENGLISH',
    'CIVIC_EDUCATION',
    'ISLAMIC_EDUCATION',
    'ART',
    'SPORT',
    'HISTORY_GEOGRAPHY',
  ];
  subjectsTraduction = [
    'علوم',
    'رياضيات',
    'تقنية',
    'عربى',
    'الفرنسية',
    'الإنجليزية',
    'التعليم المدني',
    'تربية اسلامية',
    'فن',
    'رياضة',
    'تاريخ و جغرافيا',
  ];
  donorFormGroup!: FormGroup;
  booksFormGroup = new FormArray([]);
  cities: City[];

  allCities: City[];
  states: State[];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private donorService: DonorService
  ) {}

  ngOnInit(): void {
    this.donorFormGroup = this.formBuilder.group({
      school: this.formBuilder.group({
        state: this.formBuilder.control('', [Validators.required]),
        city: this.formBuilder.control('', [Validators.required]),
        name: this.formBuilder.control(''),
      }),
      user: this.formBuilder.group({
        firstName: this.formBuilder.control('', [Validators.required]),
        lastName: this.formBuilder.control('', [Validators.required]),
        level: this.formBuilder.control(''),
      }),

      books: this.booksFormGroup,
    });
    this.donorService.getCities().subscribe((cities) => {
      this.cities = cities;
      this.allCities = cities;
    });
    this.donorService.getStates().subscribe((states) => {
      this.states = states;
    });
    this.addBookToFormGroup();
  }

  get books() {
    return this.donorFormGroup.controls['books'] as FormArray;
  }

  ngOnChanges() {}

  addBookToFormGroup() {
    const bookGroup = this.newBookGroup(new Book());

    this.books.push(bookGroup);
    // const bookListControls = this.donorFormGroup.controls['books'];
    // if (bookListControls instanceof FormGroup) {
    //   this.donorFormGroup = this.formBuilder.group({
    //     school: this.donorFormGroup.controls['school'],
    //     user: this.donorFormGroup.controls['user'],
    //     books: this.formBuilder.group({
    //       ...bookListControls.controls,
    //       ...groupBooks.controls,
    //     }),
    //   });
    // }
  }
  newBookGroup(book: Book): FormGroup {
    const newBookGroup = new FormGroup({
      name: this.formBuilder.control(''),
      category: this.formBuilder.group({
        name: this.formBuilder.control(''),
        type: this.formBuilder.control(''),
        level: this.formBuilder.control(''),
      }),
    });
    return newBookGroup;
  }
  deleteBootAt(index: number) {
    if (this.books.length > 1) {
      this.books.removeAt(index);
    }
  }
  onSubmit() {
    const donation = new Donation();
    const school = new School();
    school.name = this.donorFormGroup.controls['school'].value.name;
    school.city = this.donorFormGroup.controls['school'].value.city;
    donation.school = school;
    const user = new User();
    user.firstName = this.donorFormGroup.controls['user'].value.firstName;
    user.lastName = this.donorFormGroup.controls['user'].value.lastName;
    user.level = this.donorFormGroup.controls['user'].value.level;
    donation.user = user;
    const books = this.donorFormGroup.controls['books'].value;
    donation.books = books;
    this.donorService.register(donation);
  }
  updateState() {
    const id = this.donorFormGroup.get('school')?.value.city.state.id;
    const state = this.states.find((state) => {
      return state.id === id;
    });
    this.donorFormGroup.controls['school'].patchValue({ state: state });
    this.updateCities();
  }
  updateCities() {
    const id = this.donorFormGroup.get('school')?.value.state.id;
    this.cities = this.allCities.filter((city) => {
      return city.state.id === id;
    });
  }
}
