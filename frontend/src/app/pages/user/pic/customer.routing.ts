import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CustomerListComponent } from "./customer-list/customer-list.component";
import { ContentComponentPic } from "../../../components/content/pic/content.pic.component";
import { PicGuard } from "../../../guard/pic.guard";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentPic,
        canActivate : [PicGuard],
        children : [
            {
                path: "",
                component : CustomerListComponent
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
export class CustomerRouting {}