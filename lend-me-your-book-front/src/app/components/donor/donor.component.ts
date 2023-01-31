import { Component, OnChanges, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/common/book';
import { City } from 'src/app/common/city';
import { State } from 'src/app/common/state';
import { DonorService } from 'src/app/services/donor.service';

@Component({
  selector: 'app-donor',
  templateUrl: './donor.component.html',
  styleUrls: ['./donor.component.css'],
})
export class DonorComponent implements OnInit, OnChanges {
  books: Array<Book> = new Array();
  levels = [1, 2, 3, 4, 5, 6];
  donorFormGroup!: FormGroup;
  booksFormGroup = new FormGroup({});
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
        state: new FormControl('', [Validators.required]),
        city: new FormControl('', [Validators.required]),
        name: new FormControl(''),
      }),
      user: this.formBuilder.group({
        firstName: new FormControl('', [Validators.required]),
        lastName: new FormControl('', [Validators.required]),
        level: new FormControl(this.levels[0] + ' year'),
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

  ngOnChanges() {
    console.log(this.donorFormGroup.controls);
  }

  onKeyUp() {
    console.log(this.donorFormGroup.controls);
  }
  addBookToFormGroup() {
    const group: any = {};

    group['book_' + this.books.length] = this.newBookGroup(new Book());

    this.books.push(new Book());
    const groupBooks = new FormGroup(group);
    const bookListControls = this.donorFormGroup.controls['books'];
    if (bookListControls instanceof FormGroup) {
      this.donorFormGroup = this.formBuilder.group({
        school: this.donorFormGroup.controls['school'],
        user: this.donorFormGroup.controls['user'],
        books: this.formBuilder.group({
          ...bookListControls.controls,
          ...groupBooks.controls,
        }),
      });
    }

    console.log(this.donorFormGroup.controls);
  }
  newBookGroup(book: Book): FormGroup {
    const newBookGroup = new FormGroup({
      bookName: new FormControl(''),
      bookCategory: new FormControl('Book'),
    });
    return newBookGroup;
  }
  onSubmit() {
    console.log('ayoubTest');
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
    console.log('ayoub' + id);
    this.cities = this.allCities.filter((city) => {
      return city.state.id === id;
    });
  }
}
