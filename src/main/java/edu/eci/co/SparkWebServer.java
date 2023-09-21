package edu.eci.co;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("Sin", (req,res) -> Math.sin(Double.parseDouble(req.queryParams("v"))));
        get("Cos", (req,res) -> Math.cos(Double.parseDouble(req.queryParams("v"))));
        get("Pali", (req,res) -> getPalindromo(req.queryParams("v")));
        get("Mag", (req,res) -> getMagnitud(Double.parseDouble(req.queryParams("v")),Double.parseDouble(req.queryParams("a"))));
        get("index.html", (req,res) -> getIndex());

    }

    private static Object getMagnitud(double v, double a) {
        return Math.sqrt(v*v+a*a);
    }

    private static String getPalindromo(String v) {
        String val = new StringBuilder(v).reverse().toString();
        if (v.equals(val)){
            return "su cadena es un palindromo";
        }
        return "su cadena no es un palindromo";
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String getIndex(){
        return  "\r\n <!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Bono Arep</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Funcion Seno</h1>\n" +
                "        <form action=\"/hello\">\n" +
                "            <label for=\"name\">Valor:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetMsg()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/Sin?v=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "       <h1>Funcion Coseno</h1>\n" +
                "        <form action=\"/hello1\">\n" +
                "            <label for=\"name1\">Valor:</label><br>\n" +
                "            <input type=\"text\" id=\"name1\" name=\"name1\" value=\"\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetMsg1()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg1\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg1() {\n" +
                "                let nameVar = document.getElementById(\"name1\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg1\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/Cos?v=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "       <h1>Funcion Palindromo</h1>\n" +
                "        <form action=\"/hello2\">\n" +
                "            <label for=\"name2\">Cadena:</label><br>\n" +
                "            <input type=\"text\" id=\"name2\" name=\"name2\" value=\"\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetMsg2()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg2\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg2() {\n" +
                "                let nameVar = document.getElementById(\"name2\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg2\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/Pali?v=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "       <h1>Funcion Magnitud</h1>\n" +
                "        <form action=\"/hello3\">\n" +
                "            <label for=\"name3\">X:</label><br>\n" +
                "            <input type=\"text\" id=\"name3\" name=\"name3\" value=\"\"><br><br>\n" +
                "            <label for=\"name4\">Y:</label><br>\n" +
                "            <input type=\"text\" id=\"name4\" name=\"name4\" value=\"\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetMsg4()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg5\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg4() {\n" +
                "                let nameVar = document.getElementById(\"name3\").value;\n" +
                "                let nameVar1 = document.getElementById(\"name4\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg5\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/Mag?v=\"+nameVar+\"&a=\"+nameVar1);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "    </body>\n" +
                "</html>";
    }

}
