import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { TicketDetailComponentCustomer } from "./ticket-detail/ticket-detail.component";
import { TicketInsertComponentCustomer } from "./ticket-insert/ticket-insert.component";
import { TicketListComponentCustomer } from "./ticket-list/ticket-list.component";
import { TicketRoutingCustomer } from "./ticket.routing";

@NgModule({
    declarations : [
        TicketListComponentCustomer, TicketDetailComponentCustomer, TicketInsertComponentCustomer
    ],
    imports : [
        TicketRoutingCustomer, CommonModule, FormsModule
    ],
    exports : [
        TicketListComponentCustomer, TicketDetailComponentCustomer, TicketInsertComponentCustomer
    ]
})
export class TicketModuleCustomer{}