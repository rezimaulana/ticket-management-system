import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CompanyListComponent } from "./company-list/company-list.component";
import { CompanyInsertComponent } from "./company-insert/company-insert.component";
import { CompanyUpdateComponent } from "./company-update/company-update.component";
import { ContentComponentSuperAdmin } from "../../components/content/super-admin/content.super-admin.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentSuperAdmin,
        children : [
            {
                path: "",
                component : CompanyListComponent
            },
            {
                path: "new",
                component : CompanyInsertComponent
            },
            {
                path: "edit/:id",
                component : CompanyUpdateComponent
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
export class CompanyRouting {}