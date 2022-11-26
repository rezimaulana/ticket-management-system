import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { ApiService } from "../../../service/api.service";

@Component({
    selector : 'app-header-customer',
    templateUrl : './header.customer.component.html'
})
export class HeaderComponentCustomer {

    constructor(private apiService: ApiService, private router : Router){}

    logout(){
        this.apiService.logout()
        this.router.navigateByUrl('/login')
    }

}