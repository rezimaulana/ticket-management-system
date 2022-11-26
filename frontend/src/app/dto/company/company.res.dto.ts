import { CompanyDataDto } from "./company.data.dto";

export class CompanyResDto{
    private _data : CompanyDataDto = new CompanyDataDto

    public get data(): CompanyDataDto {
        return this._data;
    }

    public set data(data: CompanyDataDto) {
        this._data = data;
    }

}