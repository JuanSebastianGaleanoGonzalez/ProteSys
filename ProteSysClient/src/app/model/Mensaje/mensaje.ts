import { Chat } from "../Chat/chat";
import { Usuario } from "../Usuario/usuario";

export class Mensaje {
    public idMensaje?: number;
    public mensaje?: string;
    public chat?: Chat;
    public usuarioEmisor?: Usuario;

    public Mensaje() { }
}
