import { Component, OnInit, OnDestroy } from "@angular/core";
import { Subscription } from "rxjs";
import { BASE_URL } from "../../../../constant/base.url";
import { UserListResDto } from "../../../../dto/user/user.list.res.dto";
import { UserService } from "../../../../service/user.service";

@Component({
    selector: 'user-list',
    templateUrl: './user-list.component.html'
})
export class UserListComponent implements OnInit, OnDestroy{

    userListResDto = new UserListResDto ()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`

    private userGetAllSubscription? : Subscription
    private userDeleteByIdSubscription? : Subscription
    private id! : number

    constructor(private userService: UserService) { }

    init(){
        this.userGetAllSubscription = this.userService.getAll().subscribe(result => {
            this.userListResDto = result
        })
    }

    ngOnInit(): void {
        this.init()
    }

    deleteById(id:number) : void{
        this.id = id
    }

    remove() : void{
        this.userDeleteByIdSubscription = this.userService.deleteById(this.id).subscribe(() => {
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.userGetAllSubscription?.unsubscribe
        this.userDeleteByIdSubscription?.unsubscribe
    }
}