## LabArep6
En este Lboratorio se utilizo Docker para correr un servicio de logs que se conectan a mongo debe y un servidor web con un balanceador de carga que envia el log a los diferentes instancias de logservices

### Prerrequisitos
* Git
* Java
* Maven
* Docker

### Instalando el proyecto

Lo primero será traer del repositorio remoto el proyecto a la máquina local, para esto ejecutamos el siguiente comando por medio de consola.

```
git clone https://github.com/santiagoOsp01/LabArep6.git
```
Esto creará un directorio nuevo donde accederemos y ejecutaremos el siguiente comando desde la terminal.

```
docker-compose up -d
```
esto ya nos pondra a contener todos nuestro servicios pero para verificarlo corremos el siguiente comando

```
docker ps
```
y nos deberia de aparecer lo siguiente

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/33560003-ee6b-4c03-82ba-76783fc81243)

### pruebas
ya despues con un navegador entras al siguiente link http://localhost:35000/ y ahi estaran corriendo nuestro formulario para
que pruebes la funcionalidad de los servicios como se puede ver a continuacion

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/2feddafe-cbfe-44d2-a828-6bbda2edd203)

como se puede observar los servicios tambien sirven con numeros y con caracteres especiales pero si le metemos espacios se rompe nuestros servicios, porque en este laboratorio se trabajo con cadena continuas que no tenga espacio

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/e6a62c8d-553d-4767-8640-8b5c04d964db)

### Diseño

Para este laboratorio se realizo todo desde un proyecto y se crearon 2 archivos de dockerfile que son con los que vamos a construir los servicios, para esto tenemos el archivo de docker-compose
que es el que crea la instancia de roundRobin las 3 de LogServices y la instancia de mongo db, y para que corra nuestro proyecto como ya mencionamos solo toca despues de tener una
copia del repositorio local y solo correr el dockercompose

### Arquitectura

La arquitectura se puede evidenciar en la siguiente imagen

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/b8971a37-09e4-4576-83ca-03a600e55dee)

como se puede ver tenemos un roundrobin ,3 instancia de logServices y una instancia de base de datos mongodb
el roundrobin: es donde esta la pagina web quemada en el comido y el balanceador de cargas que apunta a los diferentes contenedores de logservices
logServices: esto los que se concetan a la base de datos los logs con la fecha de creacion
mongodb: es nuestra base de datos que se conectan los logServices

### Despliegue

ahorra que ya tenemos nuestro repositorio ahorra solo toca iniciar y desplegar na maquina EC2 y abrir los puertos necesarios para que funcionen,
el unico puerto que debemos abrir es el de roundrobin para poder haceder a nuestra pagina web, y tambien descargar git y docker para despues correrlo desde esta maquina
y ver el funcionamiento de nuestros servicios

### Video

https://github.com/santiagoOsp01/LabArep6/assets/111186366/b829396e-7500-4161-8aa5-3e9f983ce919

### Construido con

* [Maven](https://maven.apache.org/) - Administrador de dependencias

### Version

1.0-SNAPSHOT

### Autores
Santiago Ospina Mejia

### Licencia

GNU General Public License family

### Agradecimientos

* Luis Daniel Benavides Navarro
* jorge nuestro monitor


