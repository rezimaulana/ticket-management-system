export class TicketDataDto{
    private _id! : number
	private _code! : string
	private _title! : string
	private _content! : string
	private _statusCode! : string
	private _status! : string
	private _priority! : string
	private _productName! : string
	private _customerName! : string
	private _ver! : number
	private _isActive! : boolean
    private _createdAt! : string

    public get createdAt(): string {
        return this._createdAt;
    }

    public set createdAt(createdAt: string) {
        this._createdAt = createdAt;
    }


    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get code(): string {
        return this._code;
    }

    public set code(code: string) {
        this._code = code;
    }

    public get title(): string {
        return this._title;
    }

    public set title(title: string) {
        this._title = title;
    }

    public get content(): string {
        return this._content;
    }

    public set content(content: string) {
        this._content = content;
    }

    public get statusCode(): string {
        return this._statusCode;
    }

    public set statusCode(statusCode: string) {
        this._statusCode = statusCode;
    }

    public get status(): string {
        return this._status;
    }

    public set status(status: string) {
        this._status = status;
    }

    public get priority(): string {
        return this._priority;
    }

    public set priority(priority: string) {
        this._priority = priority;
    }

    public get productName(): string {
        return this._productName;
    }

    public set productName(productName: string) {
        this._productName = productName;
    }

    public get customerName(): string {
        return this._customerName;
    }

    public set customerName(customerName: string) {
        this._customerName = customerName;
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
    
}