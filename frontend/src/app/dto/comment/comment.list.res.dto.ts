import { CommentDataDto } from "./comment.data.dto";

export class CommentListResDto{
    private _data : CommentDataDto[] = []

    public get data(): CommentDataDto[] {
        return this._data;
    }

    public set data(data: CommentDataDto[]) {
        this._data = data;
    }
    
}