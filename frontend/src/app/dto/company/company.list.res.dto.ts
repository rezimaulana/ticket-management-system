import { CompanyDataDto } from "./company.data.dto";

export class CompanyListResDto{
    private _data : CompanyDataDto[] = []

    public get data(): CompanyDataDto[] {
        return this._data;
    }

    public set data(data: CompanyDataDto[]) {
        this._data = data;
    }

}