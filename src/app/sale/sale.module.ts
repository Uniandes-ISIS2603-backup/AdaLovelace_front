import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SaleService} from "./sale.service";
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../app-routing/app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgxPermissionsModule} from 'ngx-permissions';

import {SaleListComponent} from './sale-list/sale-list.component';
import {SaleCreateComponent} from './sale-create/sale-create.component';
import {SaleDetailComponent} from './sale-detail/sale-detail.component';


@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    NgbModule,
    ReactiveFormsModule,
    NgxPermissionsModule
  ],
  declarations: [SaleListComponent, SaleCreateComponent],
  providers:[SaleService]
})
export class SaleModule { }
