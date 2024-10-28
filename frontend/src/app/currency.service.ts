import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CurrencyRequest } from './models/currency-request.model';
import { ExchangeRateResponse } from './models/exchange-rate-response.model';

@Injectable({
  providedIn: 'root',
})
export class CurrencyService {
  private apiUrl = 'http://localhost:8080/currencies'; // Adjust the URL based on your API

  constructor(private http: HttpClient) {}

  getExchangeRate(currencyRequest: CurrencyRequest): Observable<ExchangeRateResponse> {
    return this.http.post<ExchangeRateResponse>(this.apiUrl + '/exchange-rate', currencyRequest);
  }
}