import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

import {Sale} from './sale';
import {SaleDetail} from './sale-detail';
import {Book} from '../book/book';


import {environment} from '../../environments/environment';
const API_URL = environment.apiURL;
const sales = '/sales';
const books = '/books';


/**
* The service provider for everything related to books
*/
@Injectable()
export class SaleService {

    /**
    * Constructor of the service
    * @param http The HttpClient - This is necessary in order to perform requests
    */
    constructor(private http: HttpClient) {}

    /**
    * Returns the Observable object containing the list of sales retrieved from the API
    * @returns The list of sales in real time
    */
    getSales(): Observable<Sale[]> {
        return this.http.get<Sale[]>(API_URL + sales);
    }

    /**
    * Creates a new sale
    * @param sale The new sale
    * @returns The sale with its new id if it was created, false if it wasn't
    */
    createSale(sale): Observable<SaleDetail> {
        return this.http.post<SaleDetail>(API_URL + sales, sale);
    }

    /**
    * Returns the Observable object with the details of a sale retrieved from the API
    * @returns The sale details
    */
    getSaleDetail(saleId): Observable<SaleDetail> {
        return this.http.get<SaleDetail>(API_URL + sales + '/' + saleId);
    }

    /**
        * Updates a sale
        * @param sale The updated sale
        * @returns The updated sale
        */
    updateSale(sale): Observable<SaleDetail> {
        return this.http.put<SaleDetail>(API_URL + sales + '/' + sale.id, sale);
    }
    
}