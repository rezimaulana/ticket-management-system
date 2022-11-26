import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { ProductCustomerListResDto } from "../../../dto/product-customer/product-customer.list.res.dto";
import { ProductCustomerService } from "../../../service/product-customer.service";

@Component({
    selector : 'product-customer-list',
    templateUrl : './product-customer-list.component.html'
})
export class ProductCustomerListComponent implements OnInit, OnDestroy{
    productCustomerListResDto = new ProductCustomerListResDto

    private productCustomerGetAllSubscription? : Subscription
    private productCustomerDeleteByIdSubscription? : Subscription
    private id! : number

    constructor(private productCustomerService: ProductCustomerService) { }

    init(){
        this.productCustomerGetAllSubscription = this.productCustomerService.getAll().subscribe(result => {
            this.productCustomerListResDto = result
        })
    }

    ngOnInit(): void {
        this.init()
    }

    deleteById(id:number) : void{
        this.id = id
    }

    remove() : void{
        this.productCustomerDeleteByIdSubscription = this.productCustomerService.deleteById(this.id).subscribe(() => {
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.productCustomerGetAllSubscription?.unsubscribe
        this.productCustomerDeleteByIdSubscription?.unsubscribe
    }
}