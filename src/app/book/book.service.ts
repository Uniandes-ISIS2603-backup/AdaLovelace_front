import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';


const API_URL2 = environment.apiURL+"/";
const books = 'books/';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor() { }
}
