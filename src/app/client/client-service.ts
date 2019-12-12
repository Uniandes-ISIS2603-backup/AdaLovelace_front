import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';


import {Book} from '../book/book';


import {environment} from '../../environments/environment';
const API_URL = environment.apiURL;
const sales = '/sales';
const books = '/books';
@Injectable()
export class SaleService {

}