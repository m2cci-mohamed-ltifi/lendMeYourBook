import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from '../common/city';
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

  register(donation: Donation) {
    this.http
      .post(this.apiUrl + 'donation', JSON.stringify(donation))
      .subscribe((res) => {
        console.log(res);
      });
  }
}
