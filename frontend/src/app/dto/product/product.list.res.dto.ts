import { ProductDataDto } from "./product.data.dto";

export class ProductListResDto{
    private _data : ProductDataDto[] = []

    public get data(): ProductDataDto[] {
        return this._data;
    }

    public set data(data: ProductDataDto[]) {
        this._data = data;
    }

}