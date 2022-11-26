export class ProductCustomerInsertReqDto {
    private productId! : number
    private customerId! : number

    public get _productId(): number {
        return this.productId;
    }

    public set _productId(_productId: number) {
        this.productId = _productId;
    }

    public get _customerId(): number {
        return this.customerId;
    }

    public set _customerId(_customerId: number) {
        this.customerId = _customerId;
    }

}