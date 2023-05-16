import { Piso } from "../Piso/piso";

export class Casa {

    public idCasa?: number;
    public nombre?: string;
    public barrio?: string;
    public direccion?: string;
    public pisos?: Piso[];

    public Casa() { }
}

