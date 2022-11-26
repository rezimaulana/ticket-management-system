export class UserInsertReqDto {
    private email! : string
	private password! : string
	private fullname! : string
	private picId! : number
	private companyId! : number
	private roleId! : number
	private fileCode! : string
	private fileExt! : string

    public get _email(): string {
        return this.email;
    }

    public set _email(_email: string) {
        this.email = _email;
    }

    public get _password(): string {
        return this.password;
    }

    public set _password(_password: string) {
        this.password = _password;
    }

    public get _fullname(): string {
        return this.fullname;
    }

    public set _fullname(_fullname: string) {
        this.fullname = _fullname;
    }

    public get _picId(): number {
        return this.picId;
    }

    public set _picId(_picId: number) {
        this.picId = _picId;
    }

    public get _companyId(): number {
        return this.companyId;
    }

    public set _companyId(_companyId: number) {
        this.companyId = _companyId;
    }

    public get _roleId(): number {
        return this.roleId;
    }

    public set _roleId(_roleId: number) {
        this.roleId = _roleId;
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