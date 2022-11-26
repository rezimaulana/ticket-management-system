export class AttachmentTicketDataDto{
    private _id! : number
	private _fileId! : string
	private _ticketId! : string
    private _ver! : number

    public get fileId(): string {
        return this._fileId;
    }

    public set fileId(fileId: string) {
        this._fileId = fileId;
    }

    public get ticketId(): string {
        return this._ticketId;
    }

    public set ticketId(ticketId: string) {
        this._ticketId = ticketId;
    }
    
    public get id(): number {
        return this._id;
    }

    public set id(id: number) {
        this._id = id;
    }


    public get ver(): number {
        return this._ver;
    }

    public set ver(ver: number) {
        this._ver = ver;
    }

}