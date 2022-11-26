import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { UserListComponent } from "./user-list/user-list.component";
import { UserInsertComponent } from "./user-insert/user-insert.component";
import { UserUpdateComponent } from "./user-update/user-update.component";
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
                component : UserListComponent,
            },
            {
                path: "new",
                component : UserInsertComponent
            },
            {
                path: "edit/:id",
                component : UserUpdateComponent
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
export class UserRouting {}