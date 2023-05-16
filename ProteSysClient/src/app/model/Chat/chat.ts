import { Grupo } from "../Grupo/grupo";
import { Mensaje } from "../Mensaje/mensaje";
import { Usuario } from "../Usuario/usuario";

export class Chat {
    public idChat?: number;
    public mensajes?: Mensaje[];
    public grupo?: Grupo;
    public usuarios?: Usuario[];

    public Chat() { }
}
