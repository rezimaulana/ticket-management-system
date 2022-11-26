import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { BASE_URL } from "../../../constant/base.url";
import { ROLE_CONST } from "../../../constant/role.const";
import { UserResDto } from "../../../dto/user/user.res.dto";
import { ApiService } from "../../../service/api.service";
import { UserService } from "../../../service/user.service";

@Component({
    selector : 'app-profile-view-sa',
    templateUrl : './profile-view.component.html'
})
export class ProfileViewComponent implements OnInit, OnDestroy{

    userResDto = new UserResDto()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`
    roleCode! : string | null
    roleNavigation! : string | null

    private userGetByIdSubscription? : Subscription

    constructor(private userService : UserService, private apiService : ApiService){}

    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.userGetByIdSubscription = this.userService.getById(Number(id)).subscribe(result => {
            this.userResDto = result
        })
        this.roleCode  = this.apiService.getRoleCode()
        if (this.roleCode === ROLE_CONST.SUPERADMIN){
            this.roleNavigation = 'super-admin'
        } else if (this.roleCode === ROLE_CONST.PIC){
            this.roleNavigation = 'pic'
        } else {
            this.roleNavigation = 'customer'
        }
    }

    ngOnDestroy(): void {
        this.userGetByIdSubscription?.unsubscribe()
    }

}