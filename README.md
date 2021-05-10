# EmployeeBDB Project
para poder inicializar el servicio de base de datos se tiene que descargar el repositorio, 
- ejecutar docker compose up para iniciar el servicio de base de datos
- luego con spring boot se debe ejecutar el proyecto que esta en la carpeta CrudBDB
- para iniciar el frontend debe ubicarse en la carpeta frontend y ejecutar el  comando npm install y luego npx ng serve

esto inicializara en los siguientes puertos los siguientes servicios

http://localhots:8080/ backend
http://localhots:4200/ frontend
http://localhost:5432/ bd



## servicios del backend
Los servicios de backend tendrá los siguientes servicios
Servicio    |ruta    |tipo
------------|------------|------------
getAllEmployees| /employee |get
saveEmployee-update  | /employee|post
deleteEmployee | /employee/delete/{id} |delete

## funcionalidad
El proyecto tiene la funcionalidad de guardar listar actualizar y eliminar empleados.
