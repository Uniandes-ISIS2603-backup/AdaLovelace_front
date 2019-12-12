import { Component, OnInit, Input } from '@angular/core';
import {BookService} from '../book.service'
import {BookDetail} from '../book-detail'
import {ActivatedRoute, Router, NavigationEnd} from '@angular/router';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  constructor(private bookService: BookService,
               private router: Router,
               private route: ActivatedRoute,) { }

  bookDetail:BookDetail;
  @Input() book_id;
  loader: any;

  getBookDetail() :void
  {
    this.bookService.getServicioOfrecidoDetail(this.book_id).subscribe(o =>{this.bookDetail = o })
  }

  onLoad(params) {
    this.book_id = parseInt(params['id']);
    console.log(" en detail " + this.book_id);
    this.bookDetail = new BookDetail();
    this.getBookDetail();
  }

  ngOnInit() {
    this.loader = this.route.params.subscribe((p=> this.onLoad(p)));
  }

}
