import { NotificationGrave } from "../NotificationGrave/notification-grave";
import { NotificationLeve } from "../NotificationLeve/notification-leve";
import { NotificationNormal } from "../NotificationNormal/notification-normal";

export class Notification {
    public notificaciones_graves: NotificationGrave[] = [];
    public notificaciones_normales: NotificationNormal[] = [];
    public notificaciones_leves: NotificationLeve[] = [];
}
