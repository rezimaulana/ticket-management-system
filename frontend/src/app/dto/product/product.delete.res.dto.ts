export class ProductDeleteResDto{
    private _message! : string

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}