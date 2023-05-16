import { Chat } from "../Chat/chat";
import { Credencial } from "../Credencial/credencial";
import { Grupo } from "../Grupo/grupo";

export class Usuario {
    public idUsuario?: number;
    public cedula?: number;
    public nombre?: string;
    public correo?: string;
    public telefono?: number;
    public rol?: string;
    public credencial?: Credencial;
    public grupo?: Grupo;
    public chats?: Chat[];

    public Usuario() { }
}
