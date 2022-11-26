import { UserInsertDataResDto } from "./user.insert.data.res.dto"

export class UserInsertResDto{
    private _data! : UserInsertDataResDto
	private _message! : string

    public get data(): UserInsertDataResDto {
        return this._data;
    }

    public set data(data: UserInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}