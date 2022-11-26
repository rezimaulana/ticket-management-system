export class UserDataDto{
    private _id! : number
	private _email! : string
	private _fullname! : string
    private _picId! : number
	private _picEmail! : string
	private _picName! : string
    private _companyId! : number
	private _companyCode! : string
	private _companyName! : string
    private _roleId! : number
	private _roleCode! : string
	private _roleName! : string
    private _fileId! : number
	private _fileCode! : string
	private _fileExt! : string
    private _isActive! : boolean
	private _ver! : number

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get email(): string {
        return this._email;
    }

    public set email(email: string) {
        this._email = email;
    }

    public get fullname(): string {
        return this._fullname;
    }

    public set fullname(fullname: string) {
        this._fullname = fullname;
    }

    public get picId(): number {
        return this._picId;
    }

    public set picId(picId: number) {
        this._picId = picId;
    }

    public get picEmail(): string {
        return this._picEmail;
    }

    public set picEmail(picEmail: string) {
        this._picEmail = picEmail;
    }

    public get picName(): string {
        return this._picName;
    }

    public set picName(picName: string) {
        this._picName = picName;
    }

    public get companyId(): number {
        return this._companyId;
    }

    public set companyId(companyId: number) {
        this._companyId = companyId;
    }

    public get companyCode(): string {
        return this._companyCode;
    }

    public set companyCode(companyCode: string) {
        this._companyCode = companyCode;
    }

    public get companyName(): string {
        return this._companyName;
    }

    public set companyName(companyName: string) {
        this._companyName = companyName;
    }

    public get roleId(): number {
        return this._roleId;
    }

    public set roleId(roleId: number) {
        this._roleId = roleId;
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

    public get fileId(): number {
        return this._fileId;
    }

    public set fileId(fileId: number) {
        this._fileId = fileId;
    }

    public get fileCode(): string {
        return this._fileCode;
    }

    public set fileCode(fileCode: string) {
        this._fileCode = fileCode;
    }

    public get fileExt(): string {
        return this._fileExt;
    }

    public set fileExt(fileExt: string) {
        this._fileExt = fileExt;
    }

    public get isActive(): boolean {
        return this._isActive;
    }

    public set isActive(isActive: boolean) {
        this._isActive = isActive;
    }

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

}