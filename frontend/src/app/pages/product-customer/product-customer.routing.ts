import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ProductCustomerListComponent } from "./product-customer-list/product-customer-list.component";
import { ProductCustomerInsertComponent } from "./product-customer-insert/product-customer-insert.component";
import { ContentComponentSuperAdmin } from "../../components/content/super-admin/content.super-admin.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentSuperAdmin,
        children : [
            {
                path: "",
                component : ProductCustomerListComponent
            },
            {
                path: "new",
                component : ProductCustomerInsertComponent
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
export class ProductCustomerRouting {}