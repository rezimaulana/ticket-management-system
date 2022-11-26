import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { LoginReqDto } from "../dto/login/login.req.dto";
import { LoginResDto } from "../dto/login/login.res.dto";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { UserListResDto } from "../dto/user/user.list.res.dto";
import { UserResDto } from "../dto/user/user.res.dto";
import { UserInsertReqDto } from "../dto/user/user.insert.req.dto";
import { UserUpdateReqDto } from "../dto/user/user.update.req.dto";
import { UserDeleteResDto } from "../dto/user/user.delete.res.dto";

@Injectable({
    providedIn : 'root'
})

export class UserService {

    constructor(private http : HttpClient) {}

    login(data : LoginReqDto) : Observable<LoginResDto> {
        return this.http.post<LoginResDto>(`${BASE_URL.LOCALHOST}/login`, data)
    }

    getAll() : Observable<UserListResDto> {
        return this.http.get<UserListResDto>(`${BASE_URL.LOCALHOST}/users`)
    }

    getById(id:number) : Observable<UserResDto>{
        return this.http.get<UserResDto>(`${BASE_URL.LOCALHOST}/users/`+id)
    }

    getAllIdPic() : Observable<UserListResDto> {
        return this.http.get<UserListResDto>(`${BASE_URL.LOCALHOST}/users/pic`)
    }

    insert(data :UserInsertReqDto) : Observable<UserInsertReqDto>{
        return this.http.post<UserInsertReqDto>(`${BASE_URL.LOCALHOST}/users`, data);
    }

    update(data :UserUpdateReqDto) : Observable<UserUpdateReqDto>{
        return this.http.put<UserUpdateReqDto>(`${BASE_URL.LOCALHOST}/users`, data);
    }

    deleteById(id:number) : Observable<UserDeleteResDto>{
        return this.http.delete<UserDeleteResDto>(`${BASE_URL.LOCALHOST}/users/`+id)
    }

    getAllIdCust() : Observable<UserListResDto> {
        return this.http.get<UserListResDto>(`${BASE_URL.LOCALHOST}/users/customer`)
    }

    getAllIdPicIdCust(id:number) : Observable<UserListResDto> {
        return this.http.get<UserListResDto>(`${BASE_URL.LOCALHOST}/users/pic/${id}/customer`)
    }
}