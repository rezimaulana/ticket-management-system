import { TicketPriorityDataDto } from "./ticket-priority.data.dto";

export class TicketPriorityResDto{
    private _data : TicketPriorityDataDto = new TicketPriorityDataDto()

    public get data(): TicketPriorityDataDto {
        return this._data;
    }

    public set data(data: TicketPriorityDataDto) {
        this._data = data;
    }

}