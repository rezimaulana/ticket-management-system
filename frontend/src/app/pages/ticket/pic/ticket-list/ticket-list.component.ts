import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { ApiService } from "../../../../service/api.service";
import { TicketService } from "../../../../service/ticket.service";
import { TicketListResDto } from "../../../../dto/ticket/ticket.list.res.dto";

@Component({
    selector : 'ticket-list',
    templateUrl : './ticket-list.component.html'
})
export class TicketListComponentPic implements OnInit, OnDestroy{
    ticketListResDto = new TicketListResDto()

    private ticketGetAllIdPicSubscription? : Subscription

    constructor(private ticketService : TicketService, private apiService : ApiService){}

    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.ticketGetAllIdPicSubscription = this.ticketService.getAllIdPic(Number(id)).subscribe(result => {
            this.ticketListResDto = result
        })
    }

    ngOnDestroy(): void {
        this.ticketGetAllIdPicSubscription?.unsubscribe
    }
}