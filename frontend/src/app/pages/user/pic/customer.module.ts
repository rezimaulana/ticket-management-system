import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { CustomerListComponent } from "./customer-list/customer-list.component";
import { CustomerRouting } from "./customer.routing";

@NgModule({
    declarations : [
        CustomerListComponent
    ],
    imports : [
        CustomerRouting, CommonModule, FormsModule
    ],
    exports : [
        CustomerListComponent
    ]
})
export class CustomerModule{}