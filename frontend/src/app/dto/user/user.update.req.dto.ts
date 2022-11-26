export class UserUpdateReqDto {
    private id! : number
	private email! : string
	private password! : string
    private oldPassword! : string 	
	private fullname! : string
	private roleId! : number
	private fileCode! : string
	private fileExt! : string
	private ver! : number
    private isActive! : boolean

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

    public get _oldPassword(): string {
        return this.oldPassword;
    }

    public set _oldPassword(_oldPassword: string) {
        this.oldPassword = _oldPassword;
    }

    public get _fullname(): string {
        return this.fullname;
    }

    public set _fullname(_fullname: string) {
        this.fullname = _fullname;
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

    public get _ver(): number {
        return this.ver;
    }

    public set _ver(_ver: number) {
        this.ver = _ver;
    }


    
}