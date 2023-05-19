# ProteSys
Plataforma de Seguridad, proyecto del curso "PATRONES DE DISEÑO DE SOFTWARE". El objetivo es usar patrones de diseño para crear una plataforma conformada por una aplicación móvil y una página web que se comunican a través de servicios REST.

Comandos para levantar los distintos servidores:

Keycloack: Servidor de Autenticacion.
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev

Aplicacion Web Angular:
ng serve -o

API Springboot:
mvn spring-boot:run 
