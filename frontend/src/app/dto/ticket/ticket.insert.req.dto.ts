import { FileInsertReqDto } from "./file.insert.req.dto"

export class TicketInsertReqDto {

    private title! : string
	private content! : string
	private ticketPriorityCode! : string
	private productCustomerId! : number
	private file! : FileInsertReqDto[]

    public get _title(): string {
        return this.title;
    }

    public set _title(_title: string) {
        this.title = _title;
    }

    public get _content(): string {
        return this.content;
    }

    public set _content(_content: string) {
        this.content = _content;
    }

    public get _ticketPriorityCode(): string {
        return this.ticketPriorityCode;
    }

    public set _ticketPriorityCode(_ticketPriorityCode: string) {
        this.ticketPriorityCode = _ticketPriorityCode;
    }

    public get _productCustomerId(): number {
        return this.productCustomerId;
    }

    public set _productCustomerId(_productCustomerId: number) {
        this.productCustomerId = _productCustomerId;
    }

    public get _file(): FileInsertReqDto[] {
        return this.file;
    }

    public set _file(_file: FileInsertReqDto[]) {
        this.file = _file;
    }

}