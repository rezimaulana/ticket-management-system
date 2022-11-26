import { NgModule } from "@angular/core";
import { ProfileRouting } from "./profile.routing";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { ProfilePasswordComponent } from "./profile-password/profile-password.component";
import { ProfileUpdateComponent } from "./profile-update/profile-update.component";
import { ProfileViewComponent } from "./profile-view/profile-view.component";

@NgModule({
    declarations : [
        ProfileViewComponent, ProfileUpdateComponent, ProfilePasswordComponent
    ],
    imports : [
        ProfileRouting, CommonModule, FormsModule
    ],
    exports : [
        ProfileViewComponent, ProfileUpdateComponent, ProfilePasswordComponent
    ]
})

export class ProfiledModule{}