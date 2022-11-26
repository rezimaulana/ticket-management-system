import { TicketUpdateDataResDto } from "./ticket.update.data.res.dto";

export class TicketUpdateResDto{
    private _data! : TicketUpdateDataResDto
	private _message! : string

    public get data(): TicketUpdateDataResDto {
        return this._data;
    }

    public set data(data: TicketUpdateDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }
    
}