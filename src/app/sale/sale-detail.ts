import { Book } from "../book/book";
import { Sale } from "./sale";

export class SaleDetail extends Sale{
    books: Book[];
}