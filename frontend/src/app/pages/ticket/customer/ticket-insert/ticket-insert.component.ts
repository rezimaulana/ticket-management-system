import { Component, OnDestroy, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Subscription } from "rxjs";
import { ProductCustomerListResDto } from "../../../../dto/product-customer/product-customer.list.res.dto";
import { TicketPriorityListResDto } from "../../../../dto/ticket-priority/ticket-priority.list.res.dto";
import { FileInsertReqDto } from "../../../../dto/ticket/file.insert.req.dto";
import { TicketInsertReqDto } from "../../../../dto/ticket/ticket.insert.req.dto";
import { ApiService } from "../../../../service/api.service";
import { FileService } from "../../../../service/file.service";
import { ProductCustomerService } from "../../../../service/product-customer.service";
import { TicketPriorityService } from "../../../../service/ticket-priority.service";
import { TicketService } from "../../../../service/ticket.service";

@Component({
    selector : 'ticket-insert',
    templateUrl : './ticket-insert.component.html'
})
export class TicketInsertComponentCustomer implements OnInit, OnDestroy{

    ticketInsertReqDto= new TicketInsertReqDto()
    productCustomerListResDto = new ProductCustomerListResDto()
    ticketPriorityListResDto = new TicketPriorityListResDto()
    fileInsertReqDto = new FileInsertReqDto()
    fileInsertReqDtoList : FileInsertReqDto [] = []
    private ticketInsertSubscription? : Subscription
    private productCustomerGetAllIdCustSubscription? : Subscription
    private ticketPriorityGetAllSubscription? : Subscription

    constructor(private ticketService : TicketService, private productCustomerService : ProductCustomerService,
        private ticketPriorityService : TicketPriorityService, private fileService : FileService,
        private apiService : ApiService, private router : Router){}
    
    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.productCustomerGetAllIdCustSubscription = this.productCustomerService.getAllIdCust(Number(id)).subscribe(result => {
            this.productCustomerListResDto = result
        })
        this.ticketPriorityGetAllSubscription = this.ticketPriorityService.getAll().subscribe(result => {
            this.ticketPriorityListResDto = result
        })
    }

    submit(): void {
        this.ticketInsertSubscription = this.ticketService.insert(this.ticketInsertReqDto).subscribe(() =>{
            this.router.navigateByUrl('/tickets/customer')
        })
    }

    fileUpload(event: any) {
        for(let i = 0; i < event.target.files.length; i++){
            this.fileService.fileUploadMultiple(event,i).then(result=>{
                this.fileInsertReqDto = new FileInsertReqDto()
                this.fileInsertReqDto._fileExt=result[0]
                this.fileInsertReqDto._fileCode=result[1]
                this.fileInsertReqDtoList.push(this.fileInsertReqDto)
            })
        }
        this.ticketInsertReqDto._file = this.fileInsertReqDtoList
    }

    ngOnDestroy(): void {
        this.ticketInsertSubscription?.unsubscribe()
        this.productCustomerGetAllIdCustSubscription?.unsubscribe()
        this.ticketPriorityGetAllSubscription?.unsubscribe()
    }
}