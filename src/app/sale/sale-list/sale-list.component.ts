import {Component, OnInit, Input} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import 'rxjs/add/operator/filter';


import {Sale} from '../../sale/sale';
import {SaleService} from '../../sale/sale.service';
@Component({
    selector: 'app-sale-list',
    templateUrl: './sale-list.component.html',
    styleUrls: ['./sale-list.component.css']
})
export class BookListComponent implements OnInit {

    /**
    * The list of books to display
    */
    @Input() books: Book[];

    /**
    * The component's constructor
    */
    constructor(private bookService: BookService, private route: ActivatedRoute) {}

    allbooks: string = 'no';
    /**
    * This method retrieves all the books in the Bookstore to show them in the list
    */
    getBooks(): void {
        this.bookService.getBooks()
            .subscribe(books => {
                this.books = books;
            });
    }

    /**
    * The method which initializes the component
    */
    ngOnInit() {
        this.route.queryParams
            .filter(params => params.allbooks)
            .subscribe(params => {
                console.log(params);

                this.allbooks = params.allbooks;
                console.log(this.allbooks);
            });
        if (this.allbooks == 'yes') {
            console.log("allbooks");

            this.getBooks();
        }
    }

}