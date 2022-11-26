import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BASE_URL } from "../constant/base.url";
import { ProductDeleteResDto } from "../dto/product/product.delete.res.dto";
import { ProductInsertReqDto } from "../dto/product/product.insert.req.dto";
import { ProductListResDto } from "../dto/product/product.list.res.dto";
import { ProductResDto } from "../dto/product/product.res.dto";
import { ProductUpdateReqDto } from "../dto/product/product.update.req.dto";

@Injectable({
    providedIn: 'root'
})
export class ProductService {
    constructor(private http: HttpClient) { }

    getAll() : Observable<ProductListResDto>{
        return this.http.get<ProductListResDto>(`${BASE_URL.LOCALHOST}/products`);
    }

    insert(data :ProductInsertReqDto) : Observable<ProductInsertReqDto>{
        return this.http.post<ProductInsertReqDto>(`${BASE_URL.LOCALHOST}/products`, data);
    }

    update(data :ProductUpdateReqDto) : Observable<ProductUpdateReqDto>{
        return this.http.put<ProductUpdateReqDto>(`${BASE_URL.LOCALHOST}/products`, data);
    }
    
    getById(id:number) : Observable<ProductResDto>{
        return this.http.get<ProductResDto>(`${BASE_URL.LOCALHOST}/products/`+id)
    }

    deleteById(id:number) : Observable<ProductDeleteResDto>{
        return this.http.delete<ProductDeleteResDto>(`${BASE_URL.LOCALHOST}/products/`+id)
    }

    getAllIdCust(id:number) : Observable<ProductListResDto>{
        return this.http.get<ProductListResDto>(`${BASE_URL.LOCALHOST}/products_cust/customer/${id}`);
    }
}