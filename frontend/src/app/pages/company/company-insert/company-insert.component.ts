import { Component, OnDestroy, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Subscription } from "rxjs";
import { FileService } from "../../../service/file.service";
import { CompanyInsertReqDto } from "../../../dto/company/company.insert.req.dto";
import { CompanyService } from "../../../service/company.service";

@Component({
    selector : 'company-insert',
    templateUrl : './company-insert.component.html'
})
export class CompanyInsertComponent implements OnDestroy{
    companyInsertReqDto = new CompanyInsertReqDto()

    private companyInsertSubscription? : Subscription

    constructor(private companyService : CompanyService, private router : Router, private fileService : FileService){}

    submit(): void {
        this.companyInsertSubscription = this.companyService.insert(this.companyInsertReqDto).subscribe(() =>{
            this.router.navigateByUrl('/companies')
        })
    }

    fileUpload(event: any) {
        this.fileService.fileUpload(event).then(result=>{
            this.companyInsertReqDto._fileExt=result[0]
            this.companyInsertReqDto._fileCode=result[1]
        })
    }

    ngOnDestroy(): void {
        this.companyInsertSubscription?.unsubscribe()
    }
}