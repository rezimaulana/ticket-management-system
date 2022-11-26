import { TicketInsertDataResDto } from "./ticket.insert.data.res.dto";

export class TicketInsertResDto{
    private _data! : TicketInsertDataResDto
	private _message! : string

    public get data(): TicketInsertDataResDto {
        return this._data;
    }

    public set data(data: TicketInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}