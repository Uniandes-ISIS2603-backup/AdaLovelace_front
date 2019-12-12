import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';
import {ToastrService} from 'ngx-toastr';

import {SaleService} from '../sale.service';
//import {ClientService} from '../../client/client-service';
import {Client} from "../../client/client";
import {Sale} from '../sale';
import {Book} from '../../book/book';

@Component({
    selector: 'app-sale-create',
    templateUrl: './sale-create.component.html',
    styleUrls: ['./sale-create.component.css']
})
export class SaleCreateComponent{
    /**
    * The new book
    */
   sale: Sale;

   /**
   * The list of all the editorials in the BookStore
   */
  // clients: Client[];

   /**
   * The authors of the new book
   * This list is passed as a parameter to the child two-list component
   * It is also updated by that child component
   */
   saleBooks: Book[];

    constructor(
        private dp: DatePipe,
        private saleService: SaleService,
        //private clientService: ClientService,
        private toastrService: ToastrService,
        private router: Router
    ) {}

     /**
    * Creates a new book
    */
   createSale(): Sale {
    
    this.saleService.createSale(this.sale)
        .subscribe(sale => {
            this.sale.id = sale.id;
            this.router.navigate(['/sales/' + sale.id]);
        }, err => {
            this.toastrService.error(err, 'Error');
        });
    return this.sale;
}

getClients():void{

}
        /**
    * This function will initialize the component
    */
   ngOnInit() {
    this.sale = new Sale();
    this.sale.client = new Client();
    this.getClients();
}
}