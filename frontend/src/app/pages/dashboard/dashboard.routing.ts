import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentCustomer } from "../../components/content/customer/content.customer.component";
import { ContentComponentPic } from "../../components/content/pic/content.pic.component";
import { ContentComponentSuperAdmin } from "../../components/content/super-admin/content.super-admin.component";
import { DashboardComponentCustomer } from "./customer/dashboard.customer.component";
import { DashboardComponentPic } from "./pic/dashboard.pic.component";
import { DashboardComponentSuperAdmin } from "./super-admin/dashboard.super-admin.component";

const routes : Routes = [
    {
        path : "super-admin",
        component : ContentComponentSuperAdmin,
        children : [
            {
                path: "",
                component : DashboardComponentSuperAdmin
            }
        ]
    },
    {
        path : "pic",
        component : ContentComponentPic,
        children : [
            {
                path: "",
                component : DashboardComponentPic
            }
        ]
    },
    {
        path : "customer",
        component : ContentComponentCustomer,
        children : [
            {
                path: "",
                component : DashboardComponentCustomer
            }
        ]
    }
];

@NgModule({
    imports : [
        RouterModule.forChild(routes)
    ],
    exports : [
        RouterModule
    ]
})

export class DashboardRouting{}