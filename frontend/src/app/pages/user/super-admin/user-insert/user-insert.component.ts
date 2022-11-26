import { Component, NgModule, OnDestroy, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Subscription } from "rxjs";
import { UserListResDto } from "../../../../dto/user/user.list.res.dto";
import { CompanyListResDto } from "../../../../dto/company/company.list.res.dto";
import { RoleListResDto } from "../../../../dto/role/role.list.res.dto";
import { UserInsertReqDto } from "../../../../dto/user/user.insert.req.dto";
import { CompanyService } from "../../../../service/company.service";
import { RoleService } from "../../../../service/role.service";
import { UserService } from "../../../../service/user.service";
import { FileService } from "../../../../service/file.service";

@Component({
    selector: 'user-insert',
    templateUrl: './user-insert.component.html'
})
export class UserInsertComponent implements OnInit, OnDestroy{
    
    userInsertReqDto = new UserInsertReqDto()
    roleListResDto = new RoleListResDto()
    companyListResDto = new CompanyListResDto()
    userListResDto = new UserListResDto()

    private userInsertSubscription? : Subscription
    private roleGetAllSubscription? :  Subscription
    private companyGetAllSubscription? : Subscription
    private userGetAllIdPicSubscription? : Subscription

    constructor(private userService : UserService, private roleService : RoleService,
        private companyService : CompanyService, private router : Router, private fileService : FileService){}
    
    ngOnInit(): void {
        this.roleGetAllSubscription = this.roleService.getAll().subscribe(result => {
            this.roleListResDto = result
        })
        this.companyGetAllSubscription = this.companyService.getAll().subscribe(result => {
            this.companyListResDto = result
        })
        this.userGetAllIdPicSubscription = this.userService.getAllIdPic().subscribe(result => {
            this.userListResDto = result
        })
    }

    submit(): void {
        this.userInsertSubscription = this.userService.insert(this.userInsertReqDto).subscribe(() =>{
            this.router.navigateByUrl('/users')
        })
    }

    fileUpload(event: any) {
        this.fileService.fileUpload(event).then(result=>{
            this.userInsertReqDto._fileExt=result[0]
            this.userInsertReqDto._fileCode=result[1]
        })
    }

    ngOnDestroy(): void {
        this.userInsertSubscription?.unsubscribe()
        this.roleGetAllSubscription?.unsubscribe()
        this.companyGetAllSubscription?.unsubscribe()
        this.userGetAllIdPicSubscription?.unsubscribe()
    }

}