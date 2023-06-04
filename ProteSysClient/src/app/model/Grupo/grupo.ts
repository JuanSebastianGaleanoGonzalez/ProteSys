import { Chat } from "../Chat/chat";
import { Piso } from "../Piso/piso";
import { Usuario } from "../Usuario/usuario";

export class Grupo {
    public idGrupo?: number;
    public nombre?: string;
    public fecha_creacion?: Date;
    public cantidad_usuarios?: number;
    public usuarios?: Usuario[];
    public chats?: Chat[];
    public estado?: string;
    public piso?: Piso;

    public Grupo() { }
}
