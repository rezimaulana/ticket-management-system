export class CompanyUpdateReqDto {
    private id! : number
	private companyName! : string
	private companyAddress! : string
	private fileCode! : string
	private fileExt! : string
    private ver! : number
    private isActive! : boolean

    public get _companyName(): string {
        return this.companyName;
    }

    public set _companyName(_companyName: string) {
        this.companyName = _companyName;
    }

    public get _companyAddress(): string {
        return this.companyAddress;
    }

    public set _companyAddress(_companyAddress: string) {
        this.companyAddress = _companyAddress;
    }

    public get _isActive(): boolean {
        return this.isActive;
    }

    public set _isActive(_isActive: boolean) {
        this.isActive = _isActive;
    }

    public get _id(): number {
        return this.id;
    }

    public set _id(_id: number) {
        this.id = _id;
    }

    public get _fileCode(): string {
        return this.fileCode;
    }

    public set _fileCode(_fileCode: string) {
        this.fileCode = _fileCode;
    }

    public get _fileExt(): string {
        return this.fileExt;
    }

    public set _fileExt(_fileExt: string) {
        this.fileExt = _fileExt;
    }

    public get _ver(): number {
        return this.ver;
    }

    public set _ver(_ver: number) {
        this.ver = _ver;
    }
    
}