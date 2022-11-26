import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { TicketDetailComponentPic } from "./ticket-detail/ticket-detail.component";
import { TicketListComponentPic } from "./ticket-list/ticket-list.component";
import { TicketRoutingPic } from "./ticket.routing";

@NgModule({
    declarations : [
        TicketListComponentPic, TicketDetailComponentPic
    ],
    imports : [
        TicketRoutingPic, CommonModule, FormsModule
    ],
    exports : [
        TicketListComponentPic, TicketDetailComponentPic
    ]
})
export class TicketModulePic{}