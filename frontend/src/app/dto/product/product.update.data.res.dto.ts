export class ProductUpdateDataResDto{
    private _ver! : number

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

}