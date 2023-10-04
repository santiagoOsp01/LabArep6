## LabArep6
En este Lboratorio se utilizo Docker para correr un servicio de logs que se conectan a mongo debe y un servidor web con un balanceador de carga que envia el log a los diferentes instancias de logservices

## Prerrequisitos
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
<<<<<<< HEAD

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/33560003-ee6b-4c03-82ba-76783fc81243)

### pruebas
ya despues con un navegador entras al siguiente link http://localhost:35000/ y ahi estaran corriendo nuestro formulario para
que pruebes la funcionalidad de los servicios como se puede ver a continuacion

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/2feddafe-cbfe-44d2-a828-6bbda2edd203)

como se puede observar los servicios tambien sirven con numeros y con caracteres especiales pero si le metemos espacios se rompe nuestros servicios, porque en este laboratorio se trabajo con cadena continuas que no tenga espacio

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/e6a62c8d-553d-4767-8640-8b5c04d964db)

## Documentacion

la documentación del proyecto solo debes correr el siguiente comando en el directorio del proyecto desde una terminal

```
mvn javadoc:javadoc
```

Y en la siguiente ruta encontrarás el archivo index.html en donde si lo abres desde el navegador podras ver toda la documentación

```
./target/site/apidocs
```

=======

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/33560003-ee6b-4c03-82ba-76783fc81243)

### pruebas 
ya despues con un navegador entras al siguiente link http://localhost:35000/ y ahi estaran corriendo nuestro formulario para 
que pruebes la funcionalidad de los servicios como se puede ver a continuacion

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/2feddafe-cbfe-44d2-a828-6bbda2edd203)

como se puede observar los servicios tambien sirven con numeros y con caracteres especiales pero si le metemos espacios se rompe nuestros servicios, porque en este laboratorio se trabajo con cadena continuas que no tenga espacio

![image](https://github.com/santiagoOsp01/LabArep6/assets/111186366/e6a62c8d-553d-4767-8640-8b5c04d964db)

## Documentacion

la documentación del proyecto solo debes correr el siguiente comando en el directorio del proyecto desde una terminal 

```
mvn javadoc:javadoc
```

Y en la siguiente ruta encontrarás el archivo index.html en donde si lo abres desde el navegador podras ver toda la documentación

```
./target/site/apidocs
```

>>>>>>> a5e5ed721ba14b49e858477b96aad1e5d672f1c9
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


