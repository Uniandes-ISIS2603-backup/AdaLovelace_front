import {Component, OnInit, Input} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import 'rxjs/add/operator/filter';


import {Sale} from '../../sale/sale';
import {SaleService} from "../sale.service";
@Component({
    selector: 'app-sale-list',
    templateUrl: './sale-list.component.html',
    styleUrls: ['./sale-list.component.css']
})
export class SaleListComponent implements OnInit {

 
    sales: Sale[];

    /**
    * The component's constructor
    */
    constructor(private saleService: SaleService, private route: ActivatedRoute) {}

    /**
    * This method retrieves all the books in the Bookstore to show them in the list
    */
    getBooks(): void {
        this.saleService.getSales()
            .subscribe(sales => {
                this.sales = sales;
            });
    }

    /**
    * The method which initializes the component
    */
    ngOnInit() {
      this.getBooks;
    }

}