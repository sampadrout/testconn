package org.example;

import static org.junit.Assert.assertTrue;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.bson.Document;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://admin:Zz123456@cluster0.t2rdm.mongodb.net/ui_test?retryWrites=true&w=majority");

        try(MongoClient mongoClient = new MongoClient(uri))
        {
            MongoDatabase database = mongoClient.getDatabase("ui_test");
            MongoCollection<Document> collection = database.getCollection("qa_ui");
            Document query = new Document("_id", new ObjectId("60329cf7e34eba2ded6c1cad"));
            Document result = collection.find(query).iterator().next();

            System.out.println("Test Name: "+result.getString("tcName"));
        }
    }
}