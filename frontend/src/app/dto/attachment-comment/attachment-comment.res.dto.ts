import { AttachmentCommentDataDto } from "./attachment-comment.data.dto";

export class AttachmentCommentResDto{
    private _data : AttachmentCommentDataDto = new AttachmentCommentDataDto()

    public get data(): AttachmentCommentDataDto {
        return this._data;
    }

    public set data(data: AttachmentCommentDataDto) {
        this._data = data;
    }

}