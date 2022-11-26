import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { ROLE_CONST } from "../constant/role.const";
import { ApiService } from "../service/api.service";

@Injectable({providedIn: 'root'})
export class CanActiveAuth implements CanActivate{
    
    constructor(private apiService : ApiService, private router : Router){}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        const result = this.apiService.getRoleCode()
        if(result) {
            switch(result){
                case ROLE_CONST.SUPERADMIN:
                    this.router.navigateByUrl('/dashboard/super-admin')
                    break
                case ROLE_CONST.PIC:
                    this.router.navigateByUrl('/dashboard/pic')
                    break
                case ROLE_CONST.CUST:
                    this.router.navigateByUrl('/dashboard/customer')
                    break
            }
            return false
        } else {
            return true
        }
    }
    
}