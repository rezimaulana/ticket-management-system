import { CommentInsertDataResDto } from "./comment.insert.data.res.dto";

export class TicketInsertResDto{
    private _data! : CommentInsertDataResDto
	private _message! : string

    public get data(): CommentInsertDataResDto {
        return this._data;
    }

    public set data(data: CommentInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}