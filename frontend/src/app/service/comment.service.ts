import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { CommentInsertReqDto } from "../dto/comment/comment.insert.req.dto";
import { CommentListResDto } from "../dto/comment/comment.list.res.dto";

@Injectable({
    providedIn : 'root'
})
export class CommentService {

    constructor(private http : HttpClient) {}

    getAllIdTicket(id : number) : Observable<CommentListResDto> {
        return this.http.get<CommentListResDto>(`${BASE_URL.LOCALHOST}/comments/with_file_by_ticket/${id}`)
    }

    insert(data :CommentInsertReqDto) : Observable<CommentInsertReqDto>{
        return this.http.post<CommentInsertReqDto>(`${BASE_URL.LOCALHOST}/comments`, data);
    }

}