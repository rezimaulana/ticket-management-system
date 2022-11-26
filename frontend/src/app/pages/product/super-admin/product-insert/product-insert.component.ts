import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { Subscription } from "rxjs";
import { ProductInsertReqDto } from "../../../../dto/product/product.insert.req.dto";
import { ProductService } from "../../../../service/product.service";

@Component({
    selector : 'product-insert',
    templateUrl : './product-insert.component.html'
})
export class ProductInsertComponent {
    productInsertReqDto = new ProductInsertReqDto()

    private productInsertSubscription? : Subscription

    constructor(private productService : ProductService, private router : Router){}

    submit(): void {
        this.productInsertSubscription = this.productService.insert(this.productInsertReqDto).subscribe(() =>{
            this.router.navigateByUrl('/products')
        })
    }

    ngOnDestroy(): void {
        this.productInsertSubscription?.unsubscribe()
    }
}