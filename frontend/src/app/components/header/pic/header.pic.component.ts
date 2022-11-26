import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { ApiService } from "../../../service/api.service";

@Component({
    selector : 'app-header-pic',
    templateUrl : './header.pic.component.html'
})
export class HeaderComponentPic {
    
    constructor(private apiService: ApiService, private router : Router){}

    logout(){
        this.apiService.logout()
        this.router.navigateByUrl('/login')
    }

}