import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { AttachmentTicketListResDto } from "../dto/attachment-ticket/attachment-ticket.list.res.dto";

@Injectable({
    providedIn : 'root'
})
export class AttachmentTicketService {

    constructor(private http : HttpClient) {}

    getAllIdTicket(id : number) : Observable<AttachmentTicketListResDto> {
        return this.http.get<AttachmentTicketListResDto>(`${BASE_URL.LOCALHOST}/attachments_ticket/ticket/${id}`)
    }

}