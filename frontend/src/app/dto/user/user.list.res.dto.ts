import { UserDataDto } from "./user.data.dto";

export class UserListResDto{
    private _data : UserDataDto[] = []

    public get data(): UserDataDto[] {
        return this._data;
    }

    public set data(data: UserDataDto[]) {
        this._data = data;
    }
    
}