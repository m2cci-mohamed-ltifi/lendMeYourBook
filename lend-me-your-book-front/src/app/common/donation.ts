import { Book } from './book';
import { School } from './school';
import { User } from './user';

export class Donation {
  user: User;
  school: School;
  books: Book[];
}
