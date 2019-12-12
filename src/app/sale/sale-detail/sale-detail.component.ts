import {Component, OnInit, OnDestroy, ViewChild, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router, NavigationEnd} from '@angular/router';
import {ModalDialogService, SimpleModalComponent} from 'ngx-modal-dialog';
import {ToastrService} from 'ngx-toastr';
import {SaleService} from '../sale.service';
import {Sale} from '../sale';
import {SaleDetail} from '../sale-detail';



@Component({
    selector: 'app-sale-detail',
    templateUrl: './sale-detail.component.html',
    styleUrls: ['./sale-detail.component.css']
})
export class SaleDetailComponent implements OnInit, OnDestroy {
    constructor(
        private saleService: SaleService,
        private route: ActivatedRoute,
        private modalDialogService: ModalDialogService,
        private router: Router,
        private viewRef: ViewContainerRef,
        private toastrService: ToastrService
    ) {

    }

    ngOnDestroy(){

    }
    ngOnInit(){

    }
}