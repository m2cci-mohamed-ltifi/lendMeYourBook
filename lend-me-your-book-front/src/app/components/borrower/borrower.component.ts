import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Book } from 'src/app/common/book';
import { City } from 'src/app/common/city';
import { BorrowerService } from 'src/app/services/borrower.service';

@Component({
  selector: 'app-borrower',
  templateUrl: './borrower.component.html',
  styleUrls: ['./borrower.component.css'],
})
export class BorrowerComponent implements OnInit {
  cities: City[];
  allCities: City[];
  books: Book[];
  borrowerFormGroup: FormGroup;
  constructor(
    private borrowerService: BorrowerService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.borrowerFormGroup = this.formBuilder.group({
      city: this.formBuilder.control(''),
      state: this.formBuilder.control(''),
    });
    this.borrowerService.getCities().subscribe((cities) => {
      this.cities = cities;
      this.allCities = cities;
    });
    this.borrowerService.getBooks().subscribe((books) => {
      this.books = books;
    });
  }
}
