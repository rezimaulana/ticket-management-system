import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { Subscription } from "rxjs";
import { ROLE_CONST } from "../../../constant/role.const";
import { UserResDto } from "../../../dto/user/user.res.dto";
import { UserUpdateReqDto } from "../../../dto/user/user.update.req.dto";
import { ApiService } from "../../../service/api.service";
import { FileService } from "../../../service/file.service";
import { UserService } from "../../../service/user.service";

@Component({
    selector : 'app-profile-password-sa',
    templateUrl : './profile-password.component.html' 
})

export class ProfilePasswordComponent{
    userResDto = new UserResDto()
    userUpdateReqDto = new UserUpdateReqDto()
    roleCode! : string | null
    roleNavigation! : string | null
    confirmPassword! : string | null

    private userGetByIdSubscription? : Subscription
    private userUpdateSubscription? : Subscription

    constructor(private userService: UserService,
        private fileService : FileService, private router : Router, private apiService : ApiService,
        private toast : ToastrService){}
    
    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.userGetByIdSubscription = this.userService.getById(Number(id)).subscribe(result => {
            this.userResDto = result
            this.userUpdateReqDto._id = this.userResDto.data.id
            this.userUpdateReqDto._email = this.userResDto.data.email
            this.userUpdateReqDto._roleId = this.userResDto.data.roleId
            this.userUpdateReqDto._fullname = this.userResDto.data.fullname
            this.userUpdateReqDto._isActive = this.userResDto.data.isActive
            this.userUpdateReqDto._ver = this.userResDto.data.ver
        })
    }

    submit(): void {
        if (this.userUpdateReqDto._password == this.confirmPassword){
            this.userUpdateSubscription = this.userService.update(this.userUpdateReqDto).subscribe(() => {
                this.roleCode  = this.apiService.getRoleCode()
                if (this.roleCode === ROLE_CONST.SUPERADMIN){
                    this.roleNavigation = 'super-admin'
                } else if (this.roleCode === ROLE_CONST.PIC){
                    this.roleNavigation = 'pic'
                } else {
                    this.roleNavigation = 'customer'
                }
                this.router.navigateByUrl(`/profile/${this.roleNavigation}`)
            })
        } else {
            this.toast.warning('Silahkan input password yang sesuai!', 'Password Tidak Sesuai!')
        }
    }

    ngOnDestroy(): void {
        this.userGetByIdSubscription?.unsubscribe()
        this.userUpdateSubscription?.unsubscribe()
    }
}