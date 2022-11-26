export class TicketUpdateReqDto {
    private id! : number
	private ver! : number

    public get _id(): number {
        return this.id;
    }

    public set _id(_id: number) {
        this.id = _id;
    }

    public get _ver(): number {
        return this.ver;
    }

    public set _ver(_ver: number) {
        this.ver = _ver;
    }

}