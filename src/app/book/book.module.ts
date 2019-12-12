import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookListComponent} from './book-list/book-list.component';
import { BookDetail } from './book-detail';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [BookListComponent, BookDetail],
  exports: [BookListComponent]

})
export class BookModule { }
  