export class ProductInsertReqDto {
    private productCode! : string
	private productName! : string

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

}