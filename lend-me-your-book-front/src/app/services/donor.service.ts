import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Donation } from '../common/donation';

@Injectable({
  providedIn: 'root',
})
export class DonorService {
  private apiUrl = 'http://localhost:8080/lendmeyourbook/';

  constructor(private http: HttpClient) {}

  getCities(): Observable<any> {
    return this.http.get(this.apiUrl + 'cities');
  }
  getStates(): Observable<any> {
    return this.http.get(this.apiUrl + 'states');
  }
  getCategories(): Observable<any> {
    return this.http.get(this.apiUrl + 'bookCategories/categoryNames');
  }

  register(donation: Donation) {
    var headers = new Headers({ 'Content-Type': 'application/json' });
    this.http
      .post(this.apiUrl + 'donation', JSON.stringify(donation), {
        headers: new HttpHeaders().set('Content-Type', 'application/json'),
      })
      .subscribe((res) => {
        console.log(res);
      });
  }
}
