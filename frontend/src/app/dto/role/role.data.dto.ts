export class RoleDataDto{
    private _id! : number
	private _roleCode! : string
	private _roleName! : string
	private _ver! : number

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get roleCode(): string {
        return this._roleCode;
    }

    public set roleCode(roleCode: string) {
        this._roleCode = roleCode;
    }

    public get roleName(): string {
        return this._roleName;
    }

    public set roleName(roleName: string) {
        this._roleName = roleName;
    }

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

}