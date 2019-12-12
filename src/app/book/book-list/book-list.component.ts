import { Component, OnInit } from '@angular/core';
import {BookService} from '../book.service'
import {Book} from '../book'

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  constructor(private bookService: BookService) { }

  books: Book[];

  ngOnInit() {
    this.getBooks();
  }

  getBooks()
  {
    this.bookService.getBooks().subscribe(book => this.books =book )
  }

}
