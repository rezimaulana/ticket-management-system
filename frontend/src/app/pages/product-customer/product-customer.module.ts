import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { ProductCustomerInsertComponent } from "./product-customer-insert/product-customer-insert.component";
import { ProductCustomerListComponent } from "./product-customer-list/product-customer-list.component";
import { ProductCustomerRouting } from "./product-customer.routing";

@NgModule({
    declarations : [
        ProductCustomerListComponent, ProductCustomerInsertComponent
    ],
    imports : [
        ProductCustomerRouting, CommonModule, FormsModule
    ],
    exports : [
        ProductCustomerListComponent, ProductCustomerInsertComponent
    ]
})
export class ProductCustomerModule{}