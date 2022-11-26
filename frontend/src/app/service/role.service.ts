import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { RoleListResDto } from "../dto/role/role.list.res.dto";

@Injectable({
    providedIn: 'root'
})
export class RoleService {
    constructor(private http: HttpClient) { }

    getAll() : Observable<RoleListResDto>{
        return this.http.get<RoleListResDto>(`${BASE_URL.LOCALHOST}/roles`);
    }
}