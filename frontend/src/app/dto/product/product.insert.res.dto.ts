import { ProductInsertDataResDto } from "./product.insert.data.res.dto";

export class ProductInsertResDto{
    private _data! : ProductInsertDataResDto
	private _message! : string

    public get data(): ProductInsertDataResDto {
        return this._data;
    }

    public set data(data: ProductInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}