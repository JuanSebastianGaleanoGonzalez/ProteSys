import { Casa } from "../Casa/casa";
import { Grupo } from "../Grupo/grupo";

export class Piso {
    public idPiso?: number;
    public codigo?: string;
    public numero?: number;
    public casa?: Casa;
    public grupo?: Grupo;

    public Piso() { }
}
