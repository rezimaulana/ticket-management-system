import { ProductDataDto } from "./product.data.dto";

export class ProductResDto{
    private _data : ProductDataDto = new ProductDataDto

    public get data(): ProductDataDto {
        return this._data;
    }

    public set data(data: ProductDataDto) {
        this._data = data;
    }

}