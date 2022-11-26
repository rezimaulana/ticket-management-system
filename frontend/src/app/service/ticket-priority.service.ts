import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { TicketPriorityListResDto } from "../dto/ticket-priority/ticket-priority.list.res.dto";

@Injectable({
    providedIn : 'root'
})
export class TicketPriorityService {

    constructor(private http : HttpClient) {}

    getAll() : Observable<TicketPriorityListResDto> {
        return this.http.get<TicketPriorityListResDto>(`${BASE_URL.LOCALHOST}/ticket_priority`)
    }

}