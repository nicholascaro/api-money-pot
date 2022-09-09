package com.cpsc362.moneypot.Dao;

import com.cpsc362.moneypot.Dao.models.Pot;
import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class DatabaseConnection {
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            pojoCodecRegistry);
    ConnectionString connectionString = new
    ConnectionString("mongodb+srv://money-pot-user:lsW90ZLz8NWLKpjt@cluster0.dm3qvxd.mongodb.net/?retryWrites=true&w=majority");

    MongoClientSettings clientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .codecRegistry(codecRegistry)
            .build();

    MongoClient MongoClient = MongoClients.create(clientSettings);

    MongoDatabase Db = MongoClient.getDatabase("CPSC362");

    MongoCollection<Pot> moneyPotsCollection = Db.getCollection("MONEYPOTS", Pot.class);
    MongoCollection<Document> deleteCollection = Db.getCollection("MONEYPOTS");


    //TODO write database operations below

    //TODO change input to pot_name for deletePot
    public Boolean deletePot (String name){
        System.out.println(name);
//        Bson query = eq("pot_name", name);
        Bson queryId = eq("_id", new ObjectId(name));
        DeleteResult result = moneyPotsCollection.deleteOne(queryId);
        System.out.println("Deleted document count: " + result.getDeletedCount());
        return result.getDeletedCount() == 1;
    }

    public Boolean insertOne(Pot newPotModel){
        try {
            moneyPotsCollection.insertOne(newPotModel);
            return true;
        } catch (MongoException mongoException){
            System.out.println(mongoException.getMessage());
            return false;
        }
    }

    public Pot findOneWithId(String id){
        Pot pot;
        pot = moneyPotsCollection.find(eq("_id", id))
                .first();
        return pot;
    }

    public Pot findOneWithName(String potName){
        Pot pot;
        pot = moneyPotsCollection.find(eq("pot_name", potName))
                .first();
        return pot;
    }


}
