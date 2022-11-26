import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subscription } from "rxjs";
import { CompanyResDto } from "../../../dto/company/company.res.dto";
import { CompanyUpdateReqDto } from "../../..//dto/company/company.update.req.dto";
import { CompanyService } from "../../../service/company.service";
import { FileService } from "../../../service/file.service";

@Component({
    selector : 'company-update',
    templateUrl : './company-update.component.html'
})
export class CompanyUpdateComponent {
    
    companyResDto = new CompanyResDto()
    companyUpdateReqDto = new CompanyUpdateReqDto()

    private companyGetByIdSubscription? : Subscription
    private companyUpdateSubscription? : Subscription

    constructor(private companyService: CompanyService, private activated : ActivatedRoute,
        private fileService : FileService){}

    init(){
        this.companyGetByIdSubscription = this.activated.params.subscribe(id => {
            const idnum = Number(Object.values(id))
            this.companyService.getById(idnum).subscribe(result => {
                this.companyResDto = result
                this.companyUpdateReqDto._id = this.companyResDto.data.id
                this.companyUpdateReqDto._companyName = this.companyResDto.data.companyName
                this.companyUpdateReqDto._companyAddress = this.companyResDto.data.companyAddress
                this.companyUpdateReqDto._isActive = this.companyResDto.data.isActive
                this.companyUpdateReqDto._ver = this.companyResDto.data.ver
            })
        })
    }
    
    ngOnInit(): void {
        this.init()
    }

    submit(): void {
        this.companyUpdateSubscription = this.companyService.update(this.companyUpdateReqDto).subscribe(() => {
            this.init()
        })
    }

    fileUpload(event: any) {
        this.fileService.fileUpload(event).then(result=>{
            this.companyUpdateReqDto._fileExt=result[0]
            this.companyUpdateReqDto._fileCode=result[1]
        })
    }

    ngOnDestroy(): void {
        this.companyGetByIdSubscription?.unsubscribe()
        this.companyUpdateSubscription?.unsubscribe()
    }
}