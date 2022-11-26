import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { ProductResDto } from "../../../../dto/product/product.res.dto";
import { ProductUpdateReqDto } from "../../../../dto/product/product.update.req.dto";
import { ProductService } from "../../../../service/product.service";

@Component({
    selector : 'product-update',
    templateUrl : './product-update.component.html'
})
export class ProductUpdateComponent implements OnInit, OnDestroy{
    productResDto = new ProductResDto()
    productUpdateReqDto = new ProductUpdateReqDto()

    private productGetByIdSubscription? : Subscription
    private productUpdateSubscription? : Subscription

    constructor(private productService: ProductService, private activated:ActivatedRoute){}

    init(){
        this.productGetByIdSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.productService.getById(idnum).subscribe(result => {
                this.productResDto = result
                this.productUpdateReqDto._id = this.productResDto.data.id
                this.productUpdateReqDto._productCode = this.productResDto.data.productCode
                this.productUpdateReqDto._productName = this.productResDto.data.productName
                this.productUpdateReqDto._isActive = this.productResDto.data.isActive
                this.productUpdateReqDto._ver = this.productResDto.data.ver
            })
        })
    }
    
    ngOnInit(): void {
        this.init()
    }

    submit(): void {
        this.productUpdateSubscription = this.productService.update(this.productUpdateReqDto).subscribe(() => {
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.productGetByIdSubscription?.unsubscribe()
        this.productUpdateSubscription?.unsubscribe()
    }
}