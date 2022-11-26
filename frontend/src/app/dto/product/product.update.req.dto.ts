export class ProductUpdateReqDto {
    private id! : number
    private productCode! : string
    private productName! : string
    private ver! : number
    private isActive! : boolean

    public get _productCode(): string {
        return this.productCode;
    }

    public set _productCode(_productCode: string) {
        this.productCode = _productCode;
    }
    
    public get _productName(): string {
        return this.productName;
    }

    public set _productName(_productName: string) {
        this.productName = _productName;
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

    public get _ver(): number {
        return this.ver;
    }

    public set _ver(_ver: number) {
        this.ver = _ver;
    }
    
}