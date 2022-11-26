import { Component, OnDestroy, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { FileService } from "../../../../service/file.service";
import { UserResDto } from "../../../../dto/user/user.res.dto";
import { UserUpdateReqDto } from "../../../../dto/user/user.update.req.dto";
import { UserService } from "../../../../service/user.service";

@Component({
    selector : 'user-update',
    templateUrl : './user-update.component.html'
})
export class UserUpdateComponent implements OnInit, OnDestroy{

    userResDto = new UserResDto()
    userUpdateReqDto = new UserUpdateReqDto()

    private userGetByIdSubscription? : Subscription
    private userUpdateSubscription? : Subscription

    constructor(private userService: UserService, private activated:ActivatedRoute, private fileService : FileService){}

    init(){
        this.userGetByIdSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.userService.getById(idnum).subscribe(result => {
                this.userResDto = result
                this.userUpdateReqDto._id = this.userResDto.data.id
                this.userUpdateReqDto._email = this.userResDto.data.email
                this.userUpdateReqDto._fullname = this.userResDto.data.fullname
                this.userUpdateReqDto._roleId = this.userResDto.data.roleId
                this.userUpdateReqDto._isActive = this.userResDto.data.isActive
                this.userUpdateReqDto._ver = this.userResDto.data.ver
            })
        })
    }
    
    ngOnInit(): void {
        this.init()
    }

    submit(): void {
        this.userUpdateSubscription = this.userService.update(this.userUpdateReqDto).subscribe(() => {
            this.init()
        })
    }

    fileUpload(event: any) {
        this.fileService.fileUpload(event).then(result=>{
            this.userUpdateReqDto._fileExt=result[0]
            this.userUpdateReqDto._fileCode=result[1]
        })
    }

    ngOnDestroy(): void {
        this.userGetByIdSubscription?.unsubscribe()
        this.userUpdateSubscription?.unsubscribe()
    }
}