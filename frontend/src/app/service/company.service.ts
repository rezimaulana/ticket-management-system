import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { CompanyDeleteResDto } from "../dto/company/company.delete.res.dto";
import { CompanyInsertReqDto } from "../dto/company/company.insert.req.dto";
import { CompanyListResDto } from "../dto/company/company.list.res.dto";
import { CompanyResDto } from "../dto/company/company.res.dto";
import { CompanyUpdateReqDto } from "../dto/company/company.update.req.dto";

@Injectable({
    providedIn: 'root'
})
export class CompanyService {
    constructor(private http: HttpClient) { }

    getAll() : Observable<CompanyListResDto>{
        return this.http.get<CompanyListResDto>(`${BASE_URL.LOCALHOST}/companies`);
    }

    insert(data :CompanyInsertReqDto) : Observable<CompanyInsertReqDto>{
        return this.http.post<CompanyInsertReqDto>(`${BASE_URL.LOCALHOST}/companies`, data);
    }

    update(data :CompanyUpdateReqDto) : Observable<CompanyUpdateReqDto>{
        return this.http.put<CompanyUpdateReqDto>(`${BASE_URL.LOCALHOST}/companies`, data);
    }

    getById(id:number) : Observable<CompanyResDto>{
        return this.http.get<CompanyResDto>(`${BASE_URL.LOCALHOST}/companies/`+id)
    }

    deleteById(id:number) : Observable<CompanyDeleteResDto>{
        return this.http.delete<CompanyDeleteResDto>(`${BASE_URL.LOCALHOST}/companies/`+id)
    }

}