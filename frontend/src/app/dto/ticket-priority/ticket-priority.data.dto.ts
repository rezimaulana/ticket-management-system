export class TicketPriorityDataDto{
    private _id! : number
	private _priorityCode! : string
	private _priority! : string
	private _ver! : number

    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }

    public get priorityCode(): string {
        return this._priorityCode;
    }

    public set priorityCode(priorityCode: string) {
        this._priorityCode = priorityCode;
    }

    public get priority(): string {
        return this._priority;
    }

    public set priority(priority: string) {
        this._priority = priority;
    }

    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

}