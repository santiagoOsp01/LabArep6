package edu.eci.co.roundrobin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static spark.Spark.*;

public class RoundRobin {
    private static final String[] servers = new String[]{"http://10.0.0.5:6000/log?v=", "http://10.0.0.6:6000/log?v=", "http://10.0.0.7:6000/log?v="};
    private static int currentServer = 0;
    private static final String USER_AGENT = "Mozilla/5.0";
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> getIndex());
        get("/log", (req, res) -> makeRequest(req.queryParams("v")));
    }
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

    private static synchronized String getServer() {
        if (currentServer >= servers.length) {
            currentServer = 0;
        }
        String nextServer = servers[currentServer];
        currentServer++;
        return nextServer;
    }

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

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
