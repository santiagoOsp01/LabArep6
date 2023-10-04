package edu.eci.co.logservices;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
public class MongoRepositori {
    private final String connUri = "10.0.0.8:27017";
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public void save(Document d){
        this.client = new MongoClient(connUri);
        this.db = client.getDatabase("areplab");
        this.collection = db.getCollection("logs");
        collection.insertOne(d);
        this.client.close();
    }

    public List<Document> getLastDocs(){
        this.client = new MongoClient(connUri);
        this.db = client.getDatabase("areplab");
        this.collection = db.getCollection("logs");
        List<Document> last = collection.find().sort(Sorts.descending("_id")).limit(10).into(new ArrayList<>());
        this.client.close();
        return last;
    }
}
