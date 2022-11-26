import { AttachmentCommentDataDto } from "./attachment-comment.data.dto";

export class AttachmentCommentListResDto{
    private _data : AttachmentCommentDataDto[] = []

    public get data(): AttachmentCommentDataDto[] {
        return this._data;
    }

    public set data(data: AttachmentCommentDataDto[]) {
        this._data = data;
    }

}