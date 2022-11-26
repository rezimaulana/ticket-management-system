import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { HeaderModule } from "../header/header.module";
import { FooterComponent } from "../footer/footer.component";
import { ContentComponentSuperAdmin } from "./super-admin/content.super-admin.component";
import { ContentComponentPic } from "./pic/content.pic.component";
import { ContentComponentCustomer } from "./customer/content.customer.component";

@NgModule({
    declarations : [
        ContentComponentSuperAdmin, ContentComponentPic, ContentComponentCustomer, FooterComponent
    ],
    imports : [
        RouterModule, HeaderModule
    ],
    exports : [
        ContentComponentSuperAdmin, ContentComponentPic, ContentComponentCustomer, FooterComponent
    ]
})
export class ContentModule{}