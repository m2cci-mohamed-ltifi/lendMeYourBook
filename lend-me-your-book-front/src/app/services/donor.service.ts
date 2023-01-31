import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from '../common/city';

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
}
