package edu.eci.co.logservices;

import org.bson.Document;
import java.time.LocalDate;
import java.util.List;
import static spark.Spark.*;

/***
 * Clase encargada de guardar los logs en la base de datos
 */
public class LogService {
    /***
     * atributo donde se maneja el mongo repositori
     */
    private static final MongoRepositori repositori = new MongoRepositori();
    /***
     * funcion main que maneja los request que le llegan por el endpoint log
     * @param args son los argumentos que recibe
     */
    public static void main(String[] args) {
        port(getPort());
        get("/log", (req, res) -> saveLog(req.queryParams("v")));
    }
    /***
     * funcion main que maneja los request que le llegan por el endpoint log
     * @param simplelog es la cadena continua
     * @return List<String> las ultimas 10 cadenas
     */
    private static List<String> saveLog(String simplelog){
        Document log = createLogDocument(simplelog);
        repositori.save(log);
        List<Document> lastLogs = repositori.getLastDocs();
        return lastLogs.stream().map((Document d) -> {
            Document newDocument = new Document();
            newDocument.put("log", d.get("log"));
            newDocument.put("created", d.get("created").toString());
            return newDocument.toJson();
        }).toList();
    }
    /***
     * funcion main que maneja los request que le llegan por el endpoint log
     * @param simplelog es la cadena continua que se coloca
     * @return Document que se guardara con la fecha de creacion
     */
    private static Document createLogDocument(String simplelog){
        Document log = new Document();
        log.put("log", simplelog);
        log.put("created", LocalDate.now());
        return log;
    }
    /***
     * funcion main que maneja los request que le llegan por el endpoint log
     * @return int del port que se comunicara spark para funcionar
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 45004;
    }
}
