import { UserDataDto } from "./user.data.dto";

export class UserResDto{
    private _data : UserDataDto = new UserDataDto()

    public get data(): UserDataDto {
        return this._data;
    }

    public set data(data: UserDataDto) {
        this._data = data;
    }
    
}