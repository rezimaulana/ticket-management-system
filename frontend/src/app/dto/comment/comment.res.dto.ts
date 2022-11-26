import { CommentDataDto } from "./comment.data.dto";

export class CommentResDto{
    private _data : CommentDataDto = new CommentDataDto()

    public get data(): CommentDataDto {
        return this._data;
    }

    public set data(data: CommentDataDto) {
        this._data = data;
    }
    
}