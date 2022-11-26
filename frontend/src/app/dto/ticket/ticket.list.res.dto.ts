import { TicketDataDto } from "./ticket.data.dto";

export class TicketListResDto{
    private _data : TicketDataDto[] = []

    public get data(): TicketDataDto[] {
        return this._data;
    }

    public set data(data: TicketDataDto[]) {
        this._data = data;
    }
    
}