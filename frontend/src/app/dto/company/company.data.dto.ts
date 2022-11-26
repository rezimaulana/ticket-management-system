export class CompanyDataDto{
    private _id! : number
	private _companyCode! : string
	private _companyName! : string
	private _companyAddress! : string
    private _fileId! : number
	private _fileCode! : string
	private _fileExt! : string
	private _ver! : number
    private _isActive! : boolean

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
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

    public get companyAddress(): string {
        return this._companyAddress;
    }

    public set companyAddress(companyAddress: string) {
        this._companyAddress = companyAddress;
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

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

    public get isActive(): boolean {
        return this._isActive;
    }

    public set isActive(isActive: boolean) {
        this._isActive = isActive;
    }

    public get fileId(): number {
        return this._fileId;
    }

    public set fileId(fileId: number) {
        this._fileId = fileId;
    }
}