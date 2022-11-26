import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Subscription } from "rxjs";
import { TICKET_STATUS_CONST } from "../../../../constant/ticket.status.const";
import { BASE_URL } from "../../../../constant/base.url";
import { AttachmentTicketListResDto } from "../../../../dto/attachment-ticket/attachment-ticket.list.res.dto";
import { CommentInsertReqDto } from "../../../../dto/comment/comment.insert.req.dto";
import { CommentListResDto } from "../../../../dto/comment/comment.list.res.dto";
import { FileInsertReqDto } from "../../../../dto/comment/file.insert.req.dto";
import { TicketResDto } from "../../../../dto/ticket/ticket.res.dto";
import { TicketUpdateReqDto } from "../../../../dto/ticket/ticket.update.req.dto";
import { ApiService } from "../../../../service/api.service";
import { AttachmentTicketService } from "../../../../service/attachment-ticket.service";
import { CommentService } from "../../../../service/comment.service";
import { FileService } from "../../../../service/file.service";
import { TicketService } from "../../../../service/ticket.service";

@Component({
    selector : 'ticket-detail',
    templateUrl : './ticket-detail.component.html'
})
export class TicketDetailComponentCustomer implements OnInit, OnDestroy{
    
    ticketResDto = new TicketResDto()
    attachmentTicketListResDto = new AttachmentTicketListResDto()
    commentListResDto = new CommentListResDto()
    commentInsertReqDto = new CommentInsertReqDto()
    fileInsertReqDto = new FileInsertReqDto()
    fileInsertReqDtoList : FileInsertReqDto [] = []
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    userId  = this.apiService.getUserId()
    ticketUpdateReqDto = new TicketUpdateReqDto()

    statusTicket! : boolean

    private ticketGetByIdSubcription? : Subscription
    private attachmentTicketGetAllIdTicketSubscription? : Subscription
    private commentGetAllIdTicketSubscription? : Subscription
    private commentInsertSubscription? : Subscription
    private ticketUpdateSubscription? : Subscription

    constructor(private ticketService : TicketService, private activated : ActivatedRoute,
        private attachmentTicketService : AttachmentTicketService, private commentService : CommentService,
        private fileService : FileService, private apiService : ApiService){}

    init(){
        this.ticketGetByIdSubcription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.ticketService.getById(idnum).subscribe(result => {
                this.ticketResDto = result
                this.commentInsertReqDto._ticketId = this.ticketResDto.data.id
                this.ticketUpdateReqDto._id = this.ticketResDto.data.id
                this.ticketUpdateReqDto._ver = this.ticketResDto.data.ver
                if(TICKET_STATUS_CONST.STATCL == this.ticketResDto.data.statusCode){
                    this.statusTicket = true
                } else {
                    this.statusTicket = false
                }
            })
        })
        this.attachmentTicketGetAllIdTicketSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.attachmentTicketService.getAllIdTicket(idnum).subscribe(result => {
                this.attachmentTicketListResDto = result
            })
        })
        this.commentGetAllIdTicketSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.commentService.getAllIdTicket(idnum).subscribe(result => {
                this.commentListResDto = result
            })
        })
    }
    
    ngOnInit(): void {
        this.init()
    }

    submit(){
        this.commentInsertSubscription = this.commentService.insert(this.commentInsertReqDto).subscribe(() =>{
            this.commentInsertReqDto = new CommentInsertReqDto()
            this.fileInsertReqDto = new FileInsertReqDto()
            this.fileInsertReqDtoList = []
            this.init()
        })
    }

    update(){
        this.ticketUpdateSubscription = this.ticketService.update(this.ticketUpdateReqDto).subscribe(() => {
            this.init()
        })
    }

    fileUpload(event: any){
        for(let i = 0; i < event.target.files.length; i++){
            this.fileService.fileUploadMultiple(event,i).then(result=>{
                this.fileInsertReqDto = new FileInsertReqDto()
                this.fileInsertReqDto._fileExt=result[0]
                this.fileInsertReqDto._fileCode=result[1]
                this.fileInsertReqDtoList.push(this.fileInsertReqDto)
            })
        }
        this.commentInsertReqDto._file = this.fileInsertReqDtoList
    }

    ngOnDestroy(): void {
        this.ticketGetByIdSubcription?.unsubscribe()
        this.attachmentTicketGetAllIdTicketSubscription?.unsubscribe()
        this.commentGetAllIdTicketSubscription?.unsubscribe()
        this.commentInsertSubscription?.unsubscribe()
        this.ticketUpdateSubscription?.unsubscribe()
    }

}