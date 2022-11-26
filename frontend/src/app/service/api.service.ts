import { Injectable } from "@angular/core";
import { LoginResDto } from "../dto/login/login.res.dto";

@Injectable({
    providedIn : 'root'
})
export class ApiService{

    saveData(data : LoginResDto) : void {
        localStorage.setItem('data', JSON.stringify(data))
    }

    getData() : string | null {
        const data = localStorage.getItem('data')
        let result : null | string = ''
        if(data) {
            result = JSON.parse(data).token
        }
        return result
    }

    getRoleCode() : string | null {
        const data = localStorage.getItem('data')
        let result : null | string = ''
        if(data) {
            result = JSON.parse(data).roleCode
        }
        return result
    }

    getUserId() : number | null {
        const data = localStorage.getItem('data')
        let result : null | number = 0
        if(data) {
            result = JSON.parse(data).id
        }
        return result
    }

    logout() : void {
        localStorage.clear()
    }

}