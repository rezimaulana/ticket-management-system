import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { ApiService } from "../../../service/api.service";

@Component({
    selector : 'app-header-sa',
    templateUrl : './header.super-admin.component.html'
})

export class HeaderComponentSuperAdmin {
    
    constructor(private apiService: ApiService, private router : Router){}

    logout(){
        this.apiService.logout()
        this.router.navigateByUrl('/login')
    }

}