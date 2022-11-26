import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentSuperAdmin } from "../../components/content/super-admin/content.super-admin.component";
import { ContentComponentPic } from "../../components/content/pic/content.pic.component";
import { ContentComponentCustomer } from "../../components/content/customer/content.customer.component";
import { ProfileViewComponent } from "./profile-view/profile-view.component";
import { ProfileUpdateComponent } from "./profile-update/profile-update.component";
import { ProfilePasswordComponent } from "./profile-password/profile-password.component";
import { AdminGuard } from "../../guard/admin.guard";
import { PicGuard } from "../../guard/pic.guard";
import { CustomerGuard } from "../../guard/customer.guard";

const routes : Routes = [
    {
        path : "super-admin",
        component : ContentComponentSuperAdmin,
        canActivate : [AdminGuard],
        children : [
            {
                path: "",
                component : ProfileViewComponent
            },
            {
                path: "update",
                component : ProfileUpdateComponent
            },
            {
                path: "password",
                component : ProfilePasswordComponent
            }
        ]
    },
    {
        path : "pic",
        component : ContentComponentPic,
        canActivate : [PicGuard],
        children : [
            {
                path: "",
                component : ProfileViewComponent
            },
            {
                path: "update",
                component : ProfileUpdateComponent
            },
            {
                path: "password",
                component : ProfilePasswordComponent
            }
        ]
    },
    {
        path : "customer",
        component : ContentComponentCustomer,
        canActivate : [CustomerGuard],
        children : [
            {
                path: "",
                component : ProfileViewComponent
            },
            {
                path: "update",
                component : ProfileUpdateComponent
            },
            {
                path: "password",
                component : ProfilePasswordComponent
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

export class ProfileRouting{}