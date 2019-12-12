import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import {Book} from './book';
import {BookDetail} from './book-detail';
import { Observable } from 'rxjs';


const API_URL = environment.apiURL+"/";
const books = 'books';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }



  getBooks():Observable<Book[]> 
  {
    return this.http.get<Book[]>(API_URL + books);
  }

  getServicioOfrecidoDetail(bookId) : Observable<BookDetail> {
    return this.http.get<BookDetail>(API_URL +  books +'/' + bookId);
}


}