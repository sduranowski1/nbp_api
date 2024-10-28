export interface CurrencyRequest {
  id: number;
  currency: string;
  rate: number;
  requesterName: string; // Use camelCase as in the response
  requestDate: string; // Use camelCase as in the response
}
