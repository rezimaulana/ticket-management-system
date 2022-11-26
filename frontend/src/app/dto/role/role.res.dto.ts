import { RoleDataDto } from "./role.data.dto";

export class RoleResDto{
    private _data : RoleDataDto = new RoleDataDto()

    public get data(): RoleDataDto {
        return this._data;
    }

    public set data(data: RoleDataDto) {
        this._data = data;
    }

}