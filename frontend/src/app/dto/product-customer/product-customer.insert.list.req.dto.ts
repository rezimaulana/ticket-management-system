import { ProductCustomerInsertReqDto } from "./product-customer.insert.req.dto";

export class ProductCustomerInsertListReqDto{

    private data! :ProductCustomerInsertReqDto[];

    public get _data(): ProductCustomerInsertReqDto[] {
        return this.data;
    }

    public set _data(_data: ProductCustomerInsertReqDto[]) {
        this.data = _data;
    }


    

}