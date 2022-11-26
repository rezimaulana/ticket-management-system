export class ProductCustomerDataDto{
    private _id! : number
    private _productId! : number
	private _productCode! : string
	private _productName! : string
    private _customerId! : number
    private _customerEmail! : string
    private _customerName! : string
	private _ver! : number
    private _isActive! : boolean

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get productId(): number {
        return this._productId;
    }

    public set productId(productId: number) {
        this._productId = productId;
    }

    public get productCode(): string {
        return this._productCode;
    }

    public set productCode(productCode: string) {
        this._productCode = productCode;
    }

    public get productName(): string {
        return this._productName;
    }

    public set productName(productName: string) {
        this._productName = productName;
    }

    public get customerId(): number {
        return this._customerId;
    }

    public set customerId(customerId: number) {
        this._customerId = customerId;
    }

    public get customerEmail(): string {
        return this._customerEmail;
    }

    public set customerEmail(customerEmail: string) {
        this._customerEmail = customerEmail;
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