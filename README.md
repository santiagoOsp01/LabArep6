## LabArep5
En este Lboratorio se utilizo Docker para crear imagenes y usarla en contenedores, además se implemento un pequeño servicio REST de bono para el parcial.

## Prerrequisitos
* Git 
* Java
* Maven
* Docker

### Instalando el proyecto

Lo primero será traer del repositorio remoto el proyecto a la máquina local, para esto ejecutamos el siguiente comando por medio de consola.

```
git clone https://github.com/santiagoOsp01/LabArep5
```
Esto creará un directorio nuevo donde accederemos y ejecutaremos el siguiente comando.

```
mvn package
```
para construir nuestro proyecto 

y ya si lo queremos ejecutar desde intelij sin terminal corremos el main de la siguiente clase edu.eci.co.SparkWebServer el metodo main

![image](https://github.com/santiagoOsp01/LabArep5/assets/111186366/dee091b1-4680-459a-a1c8-de66829b21bd)

y desde la terminal podemos ejecutarlo con el siguiente comando, si eres windows 

```
java -cp "target/classes;target/dependency/*" edu.eci.co.SparkWebServer
```
si eres unix

```
java -cp "target/classes:target/dependency/*" edu.eci.co.SparkWebServer
```
### Corriendo con Docker

En el siguiente repositorio https://hub.docker.com/repository/docker/santiagoosp01/labarep5/general, se econtrará la imagen para poder ejecutar el proyecto en Docker.

Para poder ejecutar dicha imagen, ingrese el siguiente comando:

```
docker run -d -p 40001:6000 --name sparkweb santiagoosp01/labarep5:latest
```
### pruebas 

![image](https://github.com/santiagoOsp01/LabArep5/assets/111186366/a44b15af-df61-4fb1-888c-89065cf5ad70)
aqui ejecutamos el comando

![image](https://github.com/santiagoOsp01/LabArep5/assets/111186366/cd2d486d-19e6-4410-b135-98efda6f2923)

vamos como se creo en docker

vamos al siguiente link para probar las diferentes funciones del bono 

http://localhost:40001/index.html

![image](https://github.com/santiagoOsp01/LabArep5/assets/111186366/8ed5a0ae-92bb-47e7-aaa3-c6d6d9690fad)

aqui se pueden ver que se ejecutan todas las funciones que nos piden del bono
![image](https://github.com/santiagoOsp01/LabArep5/assets/111186366/ee0f0dab-f3f2-465c-bf36-3d83d57ef2b4)

## Construido con

* [Maven](https://maven.apache.org/) - Administrador de dependencias

## Version

1.0-SNAPSHOT

## Autores
Santiago Ospina Mejia

## Licencia

GNU General Public License family

## Agradecimientos

* Luis Daniel Benavides Navarro


