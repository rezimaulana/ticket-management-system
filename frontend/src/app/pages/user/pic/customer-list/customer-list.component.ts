import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { BASE_URL } from "../../../../constant/base.url";
import { UserListResDto } from "../../../../dto/user/user.list.res.dto";
import { ApiService } from "../../../../service/api.service";
import { UserService } from "../../../../service/user.service";

@Component({
    selector : 'customer-list',
    templateUrl : './customer-list.component.html'
})
export class CustomerListComponent implements OnInit, OnDestroy{

    userListResDto = new UserListResDto()
    fileDownload = BASE_URL.LOCALHOST

    private userGetAllIdPicIdCustSubscription? : Subscription

    constructor(private userService: UserService, private apiService : ApiService) { }

    ngOnInit(): void {
        const id  = this.apiService.getUserId()
        this.userGetAllIdPicIdCustSubscription = this.userService.getAllIdPicIdCust(Number(id)).subscribe(result => {
            this.userListResDto = result
        })
    }

    ngOnDestroy(): void {
        this.userGetAllIdPicIdCustSubscription?.unsubscribe
    }

}