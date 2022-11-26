import { TicketPriorityDataDto } from "./ticket-priority.data.dto";

export class TicketPriorityListResDto{
    private _data : TicketPriorityDataDto[] = []

    public get data(): TicketPriorityDataDto[] {
        return this._data;
    }

    public set data(data: TicketPriorityDataDto[]) {
        this._data = data;
    }

}