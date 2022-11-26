import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { TicketInsertReqDto } from "../dto/ticket/ticket.insert.req.dto";
import { TicketListResDto } from "../dto/ticket/ticket.list.res.dto";
import { TicketResDto } from "../dto/ticket/ticket.res.dto";
import { TicketUpdateReqDto } from "../dto/ticket/ticket.update.req.dto";

@Injectable({
    providedIn : 'root'
})
export class TicketService {

    constructor(private http : HttpClient) {}

    getAllIdCust(id : number) : Observable<TicketListResDto> {
        return this.http.get<TicketListResDto>(`${BASE_URL.LOCALHOST}/tickets/customer/${id}`)
    }

    insert(data :TicketInsertReqDto) : Observable<TicketInsertReqDto>{
        return this.http.post<TicketInsertReqDto>(`${BASE_URL.LOCALHOST}/tickets`, data);
    }

    getAllIdPic(id : number) : Observable<TicketListResDto> {
        return this.http.get<TicketListResDto>(`${BASE_URL.LOCALHOST}/tickets/pic/${id}`)
    }

    getById(id:number) : Observable<TicketResDto>{
        return this.http.get<TicketResDto>(`${BASE_URL.LOCALHOST}/tickets/${id}`)
    }
    
    update(data :TicketUpdateReqDto) : Observable<TicketUpdateReqDto>{
        return this.http.put<TicketUpdateReqDto>(`${BASE_URL.LOCALHOST}/tickets`, data);
    }

}