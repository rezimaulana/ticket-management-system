import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ProductListComponent } from "./product-list/product-list.component";
import { ProductInsertComponent } from "./product-insert/product-insert.component";
import { ProductUpdateComponent } from "./product-update/product-update.component";
import { ContentComponentSuperAdmin } from "../../../components/content/super-admin/content.super-admin.component";
import { AdminGuard } from "../../../guard/admin.guard";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentSuperAdmin,
        canActivate : [AdminGuard],
        children : [
            {
                path: "",
                component : ProductListComponent
            },
            {
                path: "new",
                component : ProductInsertComponent
            },
            {
                path: "edit/:id",
                component : ProductUpdateComponent
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
export class ProductRouting {}