package edu.eci.co.roundrobin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static spark.Spark.*;
/***
 * Clase que contiene el formulario y el balanceador de cargas
 */
public class RoundRobin {
    /***
     * atriuto que contiene los diferentes servers de los logServices
     */
    private static final String[] servers = new String[]{"http://10.0.0.5:6000/log?v=", "http://10.0.0.6:6000/log?v=", "http://10.0.0.7:6000/log?v="};
    /***
     * atributo que contiene el index del servidor actual
     */
    private static int currentServer = 0;
    /***
     * atributo requerido para la conexion
     */
    private static final String USER_AGENT = "Mozilla/5.0";
    /***
     * funcion main que maneja los request que le llegan por el endpoint log, y vacio
     * @param args son los argumentos que recibe
     */
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> getIndex());
        get("/log", (req, res) -> makeRequest(req.queryParams("v")));
    }
    /***
     * Función que hace las peticiones al logServices
     * @param log es la cadena simple que se va a guardar
     * @return String
     */
    private static String makeRequest(String log) throws IOException {
        URL obj = new URL(getServer()+log);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return "GET request not worked";
        }
    }
    /***
     * funcion que nos traer el server actual y cambia de servidor
     * @return String el servidor actual
     */
    private static synchronized String getServer() {
        if (currentServer >= servers.length) {
            currentServer = 0;
        }
        String nextServer = servers[currentServer];
        currentServer++;
        return nextServer;
    }
    /***
     * funcion que nos trae la pagina web
     * @return String el codigo html y javascript para el formulario
     */
    private static String getIndex(){
        return  """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Lab 6 Arep</title>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                </head>
                <body>
                <h1>Log de Cadenas</h1>
                <form action="/log">
                    <label for="name">cadena:</label><br>
                    <input type="text" id="name" name="name" value=""><br><br>
                    <input type="button" value="submit" onclick="loadGetMsg()">
                </form>
                <div id="getrespmsg"></div>

                <script>
                    function loadGetMsg() {
                        let nameVar = document.getElementById("name").value;
                        const xhttp = new XMLHttpRequest();
                        xhttp.onload = function() {
                            document.getElementById("getrespmsg").innerHTML =
                            this.responseText;
                        }
                        xhttp.open("GET", "/log?v="+nameVar);
                        xhttp.send();
                    }
                </script>
                </body>
                </html>
                """;
    }
    /***
     * funcion main que maneja los request que le llegan por el endpoint log
     * @return int del port que se comunicara spark para funcionar
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
