import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, CanLoad, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from "@angular/router";
import { ROLE_CONST } from "../constant/role.const";
import { ApiService } from "../service/api.service";

@Injectable({providedIn: 'root'})
export class CustomerGuard implements CanLoad, CanActivate{
    
    constructor(private apiService : ApiService, private router : Router){}
    
    activeAndLoad(){
        const resultToken = this.apiService.getData()
        if (resultToken){
            const resultCode = this.apiService.getRoleCode()
            if(resultCode == ROLE_CONST.CUST) {
                return true
            } else {
                switch(resultCode){
                    case ROLE_CONST.SUPERADMIN:
                        this.router.navigateByUrl('/dashboard/super-admin')
                        break
                    case ROLE_CONST.PIC:
                        this.router.navigateByUrl('/dashboard/pic')
                        break
                }
                return false
            }
        } else {
            this.router.navigateByUrl('/login')
            return false
        }
        
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        return this.activeAndLoad()
    }

    canLoad(route: Route, segments: UrlSegment[]): boolean {
        return this.activeAndLoad()
    }
    
}