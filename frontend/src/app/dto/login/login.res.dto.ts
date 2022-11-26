export class LoginResDto{
    private _id! : number
    private _roleCode! : string
	private _token! : string
	private _fullname! : string

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

    public get token(): string {
        return this._token;
    }

    public set token(token: string) {
        this._token = token;
    }

    public get fullname(): string {
        return this._fullname;
    }

    public set fullname(fullname: string) {
        this._fullname = fullname;
    }

    
}