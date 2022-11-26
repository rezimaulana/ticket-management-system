import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { CompanyInsertComponent } from "./company-insert/company-insert.component";
import { CompanyListComponent } from "./company-list/company-list.component";
import { CompanyUpdateComponent } from "./company-update/company-update.component";
import { CompanyRouting } from "./company.routing";

@NgModule({
    declarations : [
        CompanyListComponent, CompanyInsertComponent, CompanyUpdateComponent
    ],
    imports : [
        CompanyRouting, CommonModule, FormsModule
    ],
    exports : [
        CompanyListComponent, CompanyInsertComponent, CompanyUpdateComponent
    ]
})
export class CompanyModule{}