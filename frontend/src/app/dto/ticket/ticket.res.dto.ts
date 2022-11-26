import { TicketDataDto } from "./ticket.data.dto";

export class TicketResDto{
    private _data : TicketDataDto = new TicketDataDto()

    public get data(): TicketDataDto {
        return this._data;
    }

    public set data(data: TicketDataDto) {
        this._data = data;
    }
    
}