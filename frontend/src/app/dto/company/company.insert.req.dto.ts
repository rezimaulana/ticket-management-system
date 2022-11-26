export class CompanyInsertReqDto {
    private companyCode! : string
	private companyName! : string
	private companyAddress! : string
    private fileCode! : string
	private fileExt! : string

    public get _companyCode(): string {
        return this.companyCode;
    }

    public set _companyCode(_companyCode: string) {
        this.companyCode = _companyCode;
    }

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
    
}