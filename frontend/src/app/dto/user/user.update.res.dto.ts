import { UserUpdateDataResDto } from "./user.update.data.res.dto"

export class UserUpdateResDto{
    private _data! : UserUpdateDataResDto
	private _message! : string

    public get data(): UserUpdateDataResDto {
        return this._data;
    }

    public set data(data: UserUpdateDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }
    
}