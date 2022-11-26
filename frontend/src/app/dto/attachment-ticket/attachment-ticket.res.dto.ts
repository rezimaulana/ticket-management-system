import { AttachmentTicketDataDto } from "./attachment-ticket.data.dto";

export class AttachmentTicketResDto{
    private _data : AttachmentTicketDataDto = new AttachmentTicketDataDto()

    public get data(): AttachmentTicketDataDto {
        return this._data;
    }

    public set data(data: AttachmentTicketDataDto) {
        this._data = data;
    }

}