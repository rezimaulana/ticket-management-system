import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { ProductListResDto } from "../../../../dto/product/product.list.res.dto";
import { ProductService } from "../../../../service/product.service";

@Component({
    selector : 'product-list',
    templateUrl : './product-list.component.html'
})
export class ProductListComponent implements OnInit, OnDestroy{
    productListResDto = new ProductListResDto ()

    private productGetAllSubscription? : Subscription
    private productDeleteByIdSubscription? : Subscription
    private id! : number

    constructor(private productService: ProductService) { }

    init(){
        this.productGetAllSubscription = this.productService.getAll().subscribe(result => {
            this.productListResDto = result
        })
    }

    ngOnInit(): void {
        this.init()
    }

    deleteById(id:number) : void{
        this.id = id
    }

    remove() : void{
        this.productDeleteByIdSubscription = this.productService.deleteById(this.id).subscribe(() => {
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.productGetAllSubscription?.unsubscribe
        this.productDeleteByIdSubscription?.unsubscribe
    }
}