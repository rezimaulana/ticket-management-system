import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TicketListComponentPic } from "./ticket-list/ticket-list.component";
import { ContentComponentPic } from "../../../components/content/pic/content.pic.component";
import { TicketDetailComponentPic } from "./ticket-detail/ticket-detail.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentPic,
        children : [
            {
                path: "",
                component : TicketListComponentPic
            },
            {
                path: "detail/:id",
                component : TicketDetailComponentPic
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
export class TicketRoutingPic {}