import { ProductUpdateDataResDto } from "./product.update.data.res.dto";

export class ProductUpdateResDto{
    private _data! : ProductUpdateDataResDto
	private _message! : string

    public get data(): ProductUpdateDataResDto {
        return this._data;
    }

    public set data(data: ProductUpdateDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }
    
}