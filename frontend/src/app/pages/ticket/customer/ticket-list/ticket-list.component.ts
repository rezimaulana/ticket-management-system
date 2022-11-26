import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { TicketListResDto } from "../../../../dto/ticket/ticket.list.res.dto";
import { ApiService } from "../../../../service/api.service";
import { TicketService } from "../../../../service/ticket.service";

@Component({
    selector : 'ticket-list',
    templateUrl : './ticket-list.component.html'
})
export class TicketListComponentCustomer implements OnInit, OnDestroy{
    ticketListResDto = new TicketListResDto()

    private ticketGetAllIdCustSubscription? : Subscription

    constructor(private ticketService : TicketService, private apiService : ApiService){}

    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.ticketGetAllIdCustSubscription = this.ticketService.getAllIdCust(Number(id)).subscribe(result => {
            this.ticketListResDto = result
        })
    }

    ngOnDestroy(): void {
        this.ticketGetAllIdCustSubscription?.unsubscribe
    }
}