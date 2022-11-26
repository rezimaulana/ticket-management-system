import { RoleDataDto } from "./role.data.dto";

export class RoleListResDto{
    private _data : RoleDataDto[] = []

    public get data(): RoleDataDto[] {
        return this._data;
    }

    public set data(data: RoleDataDto[]) {
        this._data = data;
    }

}