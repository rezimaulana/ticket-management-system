export class CommentDataDto{
    private _id! : number
    private _comments! : string
    private _ticketId! : number
    private _userId! : number
    private _fullname! : string
    private _createdAt! : string
	private _ver! : number
    private _fileId! : number[]
    private _photoId! : number

    public get photoId(): number {
        return this.photoId;
    }

    public set photoId(photoId: number) {
        this._photoId = photoId;
    }

    public get fileId(): number[] {
        return this._fileId;
    }

    public set fileId(fileId: number[]) {
        this._fileId = fileId;
    }

    public get comments(): string {
        return this._comments;
    }

    public set comments(comments: string) {
        this._comments = comments;
    }

    public get ticketId(): number {
        return this._ticketId;
    }

    public set ticketId(ticketId: number) {
        this._ticketId = ticketId;
    }

    public get userId(): number {
        return this._userId;
    }

    public set userId(userId: number) {
        this._userId = userId;
    }

    public get fullname(): string {
        return this._fullname;
    }

    public set fullname(fullname: string) {
        this._fullname = fullname;
    }

    public get createdAt(): string {
        return this._createdAt;
    }

    public set createdAt(createdAt: string) {
        this._createdAt = createdAt;
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