import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ProductListComponentCustomer } from "./product-list/product-list.component";
import { ContentComponentCustomer } from "../../../components/content/customer/content.customer.component";
import { CustomerGuard } from "../../../guard/customer.guard";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentCustomer,
        canActivate : [CustomerGuard],
        children : [
            {
                path: "",
                component : ProductListComponentCustomer
            }
        ]
    }
]

@NgModule({
    imports : [
        RouterModule.forChild(routes)
    ],
    exports : [
        RouterModule
    ]
})
export class ProductRoutingCustomer {}