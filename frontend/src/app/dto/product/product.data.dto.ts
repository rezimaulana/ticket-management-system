export class ProductDataDto{
    private _id! : number
    private _productCode! : string
	private _productName! : string
	private _ver! : number
    private _isActive! : boolean

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
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