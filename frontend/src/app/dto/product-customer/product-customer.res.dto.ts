import { ProductCustomerDataDto } from "./product-customer.data.dto";

export class ProductCustomerResDto{
    private _data : ProductCustomerDataDto = new ProductCustomerDataDto

    public get data(): ProductCustomerDataDto {
        return this._data;
    }

    public set data(data: ProductCustomerDataDto) {
        this._data = data;
    }

}