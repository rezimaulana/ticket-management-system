import { FileInsertReqDto } from "./file.insert.req.dto"

export class CommentInsertReqDto {

    private comments! : string 
	private ticketId! : number
	private userId! : number
    private file! : FileInsertReqDto[]
    
    public get _comments(): string {
        return this.comments;
    }

    public set _comments(_comments: string) {
        this.comments = _comments;
    }

    public get _ticketId(): number {
        return this.ticketId;
    }

    public set _ticketId(_ticketId: number) {
        this.ticketId = _ticketId;
    }

    public get _userId(): number {
        return this.userId;
    }

    public set _userId(_userId: number) {
        this.userId = _userId;
    }

    public get _file(): FileInsertReqDto[] {
        return this.file;
    }

    public set _file(_file: FileInsertReqDto[]) {
        this.file = _file;
    }

}