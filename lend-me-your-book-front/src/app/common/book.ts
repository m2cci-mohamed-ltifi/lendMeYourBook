import { BookCategory } from './book-category';

export class Book {
  name: string;
  category: BookCategory;

  constructor() {
    this.name = '';
    this.category = new BookCategory();
  }
}
