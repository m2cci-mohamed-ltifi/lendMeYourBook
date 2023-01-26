import { Component, OnChanges, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/common/book';

@Component({
  selector: 'app-donor',
  templateUrl: './donor.component.html',
  styleUrls: ['./donor.component.css'],
})
export class DonorComponent implements OnInit, OnChanges {
  books: Array<Book> = new Array();
  donorFormGroup!: FormGroup;
  booksFormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.donorFormGroup = this.formBuilder.group({
      school: this.formBuilder.group({
        state: new FormControl('', [Validators.required]),
        city: new FormControl('', [Validators.required]),
        name: new FormControl(''),
      }),
      books: this.booksFormGroup,
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
      bookName: new FormControl(book.name),
      bookCategory: new FormControl(book.category),
    });
    return newBookGroup;
  }
  onSubmit() {}
}
