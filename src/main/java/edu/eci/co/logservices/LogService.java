package edu.eci.co.logservices;

import org.bson.Document;
import java.time.LocalDate;
import java.util.List;
import static spark.Spark.*;

public class LogService {
    private static final MongoRepositori repositori = new MongoRepositori();

    public static void main(String[] args) {
        port(getPort());
        get("/log", (req, res) -> saveLog(req.queryParams("v")));
    }

    private static List<String> saveLog(String rawLog){
        Document log = createLogDocument(rawLog);
        repositori.save(log);
        List<Document> lastLogs = repositori.getLastDocs();
        return lastLogs.stream().map((Document d) -> {
            Document newDocument = new Document();
            newDocument.put("log", d.get("log"));
            newDocument.put("created", d.get("created").toString());
            return newDocument.toJson();
        }).toList();
    }

    private static Document createLogDocument(String rawLog){
        Document log = new Document();
        log.put("log", rawLog);
        log.put("created", LocalDate.now());
        return log;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 45004;
    }
}
