import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TicketListComponentCustomer } from "./ticket-list/ticket-list.component";
import { ContentComponentCustomer } from "../../../components/content/customer/content.customer.component";
import { TicketDetailComponentCustomer } from "./ticket-detail/ticket-detail.component";
import { TicketInsertComponentCustomer } from "./ticket-insert/ticket-insert.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentCustomer,
        children : [
            {
                path: "",
                component : TicketListComponentCustomer
            },
            {
                path: "new",
                component : TicketInsertComponentCustomer
            },
            {
                path: "detail/:id",
                component : TicketDetailComponentCustomer
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
export class TicketRoutingCustomer {}