import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { BASE_URL } from "../../../constant/base.url";
import { CompanyListResDto } from "../../../dto/company/company.list.res.dto";
import { CompanyService } from "../../../../app/service/company.service";

@Component({
    selector : 'company-list',
    templateUrl : './company-list.component.html'
})
export class CompanyListComponent implements OnInit, OnDestroy{
    companyListResDto = new CompanyListResDto ()
    fileDownload = `${BASE_URL.LOCALHOST}/files/download/`

    private companyGetAllSubscription? : Subscription
    private companyDeleteByIdSubscription? : Subscription
    private id! : number

    constructor(private companyService: CompanyService) { }

    init(){
        this.companyGetAllSubscription = this.companyService.getAll().subscribe(result => {
            this.companyListResDto = result
        })
    }

    ngOnInit(): void {
        this.init()
    }

    deleteById(id:number) : void{
        this.id = id
    }

    remove() : void{
        this.companyDeleteByIdSubscription = this.companyService.deleteById(this.id).subscribe(() => {
            this.init()
        })
    }

    ngOnDestroy(): void {
        this.companyGetAllSubscription?.unsubscribe
        this.companyDeleteByIdSubscription?.unsubscribe
    }
}