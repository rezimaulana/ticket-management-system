import { Component, OnDestroy } from "@angular/core";
import { ROLE_CONST } from "../../constant/role.const";
import { LoginReqDto } from "../../dto/login/login.req.dto";
import { ApiService } from "../../service/api.service";
import { UserService } from "../../service/user.service";
import { Router } from '@angular/router';
import { Subscription } from "rxjs";

@Component({
    selector : 'login',
    templateUrl : './login.component.html'
})
export class LoginComponent implements OnDestroy {
    
    loginReqDto = new LoginReqDto()
    private loginSubscription? : Subscription

    constructor(private userService : UserService,
        private apiService : ApiService, private router : Router){}
    
    submit() : void {
        this.loginSubscription = this.userService.login(this.loginReqDto).subscribe(result => {
            this.apiService.saveData(result)
            switch(result.roleCode){
                case ROLE_CONST.SUPERADMIN:
                    this.router.navigateByUrl('/dashboard/super-admin')
                    break;
                case ROLE_CONST.PIC:
                    this.router.navigateByUrl('/dashboard/pic')
                    break;
                case ROLE_CONST.CUST:
                    this.router.navigateByUrl('/dashboard/customer')
                    break;
                default:
                    this.router.navigateByUrl('/login')
                    break;
            }
        })
    }

    ngOnDestroy(): void {
        this.loginSubscription?.unsubscribe
    }
    
}