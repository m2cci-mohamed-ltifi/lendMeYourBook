import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BorrowerService {
  constructor(private http: HttpClient) {}

  private apiUrl = 'http://localhost:8080/lendmeyourbook/';
  getCities(): Observable<any> {
    return this.http.get(this.apiUrl + 'cities');
  }

  getStates(): Observable<any> {
    return this.http.get(this.apiUrl + 'states');
  }
}
