import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ProductListComponentCustomer } from "./product-list/product-list.component";
import { ProductRoutingCustomer } from "./product.routing";

@NgModule({
    declarations : [
        ProductListComponentCustomer
    ],
    imports : [
        ProductRoutingCustomer, CommonModule, FormsModule
    ],
    exports : [
        ProductListComponentCustomer
    ]
})
export class ProductModuleCustomer{}