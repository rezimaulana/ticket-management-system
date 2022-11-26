import { CompanyInsertDataResDto } from "./company.insert.data.res.dto"

export class UserInsertResDto{
    private _data! : CompanyInsertDataResDto
	private _message! : string

    public get data(): CompanyInsertDataResDto {
        return this._data;
    }

    public set data(data: CompanyInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}