import { CompanyUpdateDataResDto } from "./company.update.data.res.dto";

export class CompanyUpdateResDto{
    private _data! : CompanyUpdateDataResDto
	private _message! : string

    public get data(): CompanyUpdateDataResDto {
        return this._data;
    }

    public set data(data: CompanyUpdateDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }
    
}