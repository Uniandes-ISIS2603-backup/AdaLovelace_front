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

    sale_id:number;

    saleDetail:SaleDetail;

    navigationSubscription;

    constructor(
        private saleService: SaleService,
        private route: ActivatedRoute,
        private modalDialogService: ModalDialogService,
        private router: Router,
        private viewRef: ViewContainerRef,
    ) {
        this.navigationSubscription = this.router.events.subscribe((e: any) => {
            if (e instanceof NavigationEnd) {
                this.ngOnInit();
            }
        });
    }

    getSaleDetail():void{
        this.saleService.getSaleDetail(this.sale_id).subscribe(p => this.saleDetail = p);
    }
    
    ngOnDestroy(){
        if (this.navigationSubscription) {
            this.navigationSubscription.unsubscribe();
        }
    }
    ngOnInit(){
        this.sale_id = +this.route.snapshot.paramMap.get('id');
        this.saleDetail = new SaleDetail();
        this.getSaleDetail();
    }
}