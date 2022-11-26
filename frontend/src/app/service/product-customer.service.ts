import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { ProductCustomerInsertListReqDto } from "../dto/product-customer/product-customer.insert.list.req.dto";
import { ProductCustomerListResDto } from "../dto/product-customer/product-customer.list.res.dto";
import { ProductDeleteResDto } from "../dto/product/product.delete.res.dto";
@Injectable({
    providedIn: 'root'
})
export class ProductCustomerService {
    constructor(private http: HttpClient) { }

    getAll() : Observable<ProductCustomerListResDto>{
        return this.http.get<ProductCustomerListResDto>(`${BASE_URL.LOCALHOST}/products_cust/`);
    }
    
    deleteById(id:number) : Observable<ProductDeleteResDto>{
        return this.http.delete<ProductDeleteResDto>(`${BASE_URL.LOCALHOST}/products_cust/`+id)
    }
    
    insert(data :ProductCustomerInsertListReqDto) : Observable<ProductCustomerInsertListReqDto>{
        return this.http.post<ProductCustomerInsertListReqDto>(`${BASE_URL.LOCALHOST}/products_cust/`, data);
    }

    getAllIdCust(id : number) : Observable<ProductCustomerListResDto>{
        return this.http.get<ProductCustomerListResDto>(`${BASE_URL.LOCALHOST}/products_cust/customer/${id}`);
    }

}