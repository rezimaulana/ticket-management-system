import { NgModule } from "@angular/core";
import { DashboardComponentCustomer } from "./customer/dashboard.customer.component";
import { DashboardRouting } from "./dashboard.routing";
import { DashboardComponentPic } from "./pic/dashboard.pic.component";
import { DashboardComponentSuperAdmin } from "./super-admin/dashboard.super-admin.component";

@NgModule({
    declarations : [
        DashboardComponentSuperAdmin, DashboardComponentPic, DashboardComponentCustomer
    ],
    imports : [
        DashboardRouting
    ],
    exports : [
        DashboardComponentSuperAdmin, DashboardComponentPic, DashboardComponentCustomer
    ]
})

export class DashboardModule{}