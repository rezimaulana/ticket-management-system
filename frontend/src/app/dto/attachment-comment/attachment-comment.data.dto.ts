export class AttachmentCommentDataDto{
    private _id! : number
	private _fileId! : string
	private _commentId! : string
    private _ver! : number

    public get fileId(): string {
        return this._fileId;
    }

    public set fileId(fileId: string) {
        this._fileId = fileId;
    }

    public get commentId(): string {
        return this._commentId;
    }

    public set commentId(commentId: string) {
        this._commentId = commentId;
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