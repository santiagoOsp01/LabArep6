package edu.eci.co.logservices;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
/***
 * Clase encargada de manejar toda la parte de mongo
 */
public class MongoRepositori {
    /***
     * atributo que contiene la direccion para conectar a la base de datos
     */
    private final String connUri = "10.0.0.8:27017";
    /***
     * atributo que contiene el mongo client
     */
    private MongoClient client;
    /***
     * atributo que contiene lla base de datos de mongo
     */
    private MongoDatabase db;
    /***
     * atributo de la coleccion de documento de mongo
     */
    private MongoCollection<Document> collection;
    /***
     * funcion que se encarga de guardar el documento en la base de datos
     * @param d son los argumentos que recibe
     */
    public void save(Document d){
        this.client = new MongoClient(connUri);
        this.db = client.getDatabase("areplab");
        this.collection = db.getCollection("logs");
        collection.insertOne(d);
        this.client.close();
    }
    /***
     * funcion que se encarga de traer los ultimos 10 registros
     * @return List<Document>
     */
    public List<Document> getLastDocs(){
        this.client = new MongoClient(connUri);
        this.db = client.getDatabase("areplab");
        this.collection = db.getCollection("logs");
        List<Document> last = collection.find().sort(Sorts.descending("_id")).limit(10).into(new ArrayList<>());
        this.client.close();
        return last;
    }
}
