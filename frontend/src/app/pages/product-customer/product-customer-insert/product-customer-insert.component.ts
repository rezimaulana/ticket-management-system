import { Component, OnDestroy, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Subscription } from "rxjs";
import { ProductCustomerInsertListReqDto } from "../../../dto/product-customer/product-customer.insert.list.req.dto";
import { ProductCustomerInsertReqDto } from "../../../dto/product-customer/product-customer.insert.req.dto";
import { ProductListResDto } from "../../../dto/product/product.list.res.dto";
import { ProductCustomerService } from "../../../service/product-customer.service";
import { ProductService } from "../../../service/product.service";
import { UserService } from "../../../service/user.service";
import { UserListResDto } from "../../../dto/user/user.list.res.dto"

@Component({
    selector : 'product-customer-insert',
    templateUrl : './product-customer-insert.component.html'
})
export class ProductCustomerInsertComponent implements OnInit, OnDestroy{
    inputList: ProductCustomerInsertReqDto[] = []
    userListResDto = new UserListResDto()
    productListResDto = new ProductListResDto()
    productCustomerInsertListReqDto : ProductCustomerInsertListReqDto = new ProductCustomerInsertListReqDto()

    private userGetAllIdCustSubscription? : Subscription
    private productGetAllSubscription? : Subscription
    private productCustomerInsertSubscription? : Subscription

    constructor(private userService: UserService, private productService: ProductService,
        private productCustomerService: ProductCustomerService, private router : Router) {}

    ngOnInit(): void {
        this.userGetAllIdCustSubscription = this.userService.getAllIdCust().subscribe(result => {
            this.userListResDto = result;
        });
        this.productGetAllSubscription = this.productService.getAll().subscribe(result => {
            this.productListResDto = result;
        })
    }

    addInsert() {
        this.inputList.push(new ProductCustomerInsertReqDto());
    }

    changeCustomer(i: number, event: any) {
        this.inputList[i]._customerId = event.target.value;
    }

    changeProduct(i: number, event: any) {
        this.inputList[i]._productId = event.target.value;
    }

    remove(i: number) {
        this.inputList.splice(i, 1);
    }

    submit() {
        this.productCustomerInsertListReqDto._data = this.inputList;
        this.productCustomerInsertSubscription = this.productCustomerService.insert(this.productCustomerInsertListReqDto).subscribe(() => {
            this.router.navigateByUrl('/product-customer')
        });
    }

    ngOnDestroy(): void {
        this.userGetAllIdCustSubscription?.unsubscribe();
        this.productGetAllSubscription?.unsubscribe();
        this.productCustomerInsertSubscription?.unsubscribe();
    }

}