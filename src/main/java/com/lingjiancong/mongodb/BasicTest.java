package com.lingjiancong.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author lingjiancong
 */
public class BasicTest {

    MongoClient mongoClient = null;

    @Before
    public void init() throws UnknownHostException {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    }

    @Test
    public void collectionInsert() {
        DB db = mongoClient.getDB("db");
        DBCollection collection = db.getCollection("example");

        List<Integer> books = Arrays.asList(27464, 747854);
        DBObject person = new BasicDBObject("_id", "jo")
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", books);

        collection.insert(person);

    }

    @Test
    public void collectionGet() {
        DB db = mongoClient.getDB("db");
        DBCollection collection = db.getCollection("example");


        DBObject query = new BasicDBObject("_id", "jo");
        DBCursor cursor = collection.find(query);

        DBObject object = cursor.one();
        String name = (String) object.get("name");

        assertThat(name, is("Jo Bloggs"));
    }

}
