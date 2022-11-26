import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HeaderComponentSuperAdmin } from "./super-admin/header.super-admin.component";
import { HeaderComponentPic } from "./pic/header.pic.component";
import { HeaderComponentCustomer } from "./customer/header.customer.component";

@NgModule({
    declarations : [
        HeaderComponentSuperAdmin, HeaderComponentPic, HeaderComponentCustomer
    ],
    imports : [
        RouterModule
    ],
    exports : [
        HeaderComponentSuperAdmin, HeaderComponentPic, HeaderComponentCustomer
    ]
})
export class HeaderModule{}