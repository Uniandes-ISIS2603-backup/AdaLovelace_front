import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SaleService} from "./sale.service";
@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers:[SaleService]
})
export class SaleModule { }
