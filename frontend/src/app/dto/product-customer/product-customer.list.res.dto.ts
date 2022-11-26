import { ProductCustomerDataDto } from "./product-customer.data.dto";

export class ProductCustomerListResDto{
    private _data : ProductCustomerDataDto[] = []

    public get data(): ProductCustomerDataDto[] {
        return this._data;
    }

    public set data(data: ProductCustomerDataDto[]) {
        this._data = data;
    }

}