export class LoginReqDto{
    private email! : string
    private password! : string

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

    
}