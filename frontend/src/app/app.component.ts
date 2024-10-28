import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms'; // Import ReactiveFormsModule
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { CurrencyRequest } from './models/currency-request.model';
import { ExchangeRateResponse } from './models/exchange-rate-response.model';
import { CommonModule } from '@angular/common'; // Import CommonModule

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, ReactiveFormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  currencyForm: FormGroup;
  exchangeRateResponse: ExchangeRateResponse | null = null;
  error: string | null = null;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.currencyForm = this.fb.group({
      currency: ['', Validators.required],
      name: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.currencyForm.valid) {
      const formData = this.currencyForm.value;

      this.http.post<ExchangeRateResponse>('http://localhost:8080/currencies/get-current-currency-value-command', formData)
        .subscribe({
          next: (response) => {
            console.log('Success:', response);
            this.exchangeRateResponse = response; // Store the response for display
            this.error = null; // Clear any previous errors
          },
          error: (error) => {
            console.error('Error:', error);
            this.error = 'Failed to fetch exchange rate'; // Set an error message
            this.exchangeRateResponse = null; // Clear any previous response
          }
        });
    }
  }
}
