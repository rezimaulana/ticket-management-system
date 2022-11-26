import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { ProductListResDto } from "../../../../dto/product/product.list.res.dto";
import { ApiService } from "../../../../service/api.service";
import { ProductService } from "../../../../service/product.service";

@Component({
    selector : 'product-list',
    templateUrl : './product-list.component.html'
})
export class ProductListComponentCustomer implements OnInit, OnDestroy{

    productListResDto = new ProductListResDto()

    private productGetAllIdCustSubscription? : Subscription

    constructor(private productService: ProductService, private apiService : ApiService) { }

    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.productGetAllIdCustSubscription = this.productService.getAllIdCust(Number(id)).subscribe(result => {
            this.productListResDto = result
        })
    }

    ngOnDestroy(): void {
        this.productGetAllIdCustSubscription?.unsubscribe
    }

}