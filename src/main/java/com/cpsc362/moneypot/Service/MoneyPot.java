package com.cpsc362.moneypot.Service;

import com.cpsc362.moneypot.Dao.DatabaseConnection;
import com.cpsc362.moneypot.Dao.models.Pot;

import java.util.Map;


public class MoneyPot {
    DatabaseConnection databaseConnection = new DatabaseConnection();

    public String deleteMoneyPot(Map<String, Object> requestParam){
        String id = requestParam.get("_id").toString();
        if (databaseConnection.deletePot(id)){
            return "Money Pot " + id + " has been deleted.";
        } else { return "Money Pot " + id + " could not be found."; }
    }

    public String addMoneyPot(Pot pot){
        if (databaseConnection.insertOne(pot)){
            Pot retrievedPot = databaseConnection.findOneWithName(pot.getPotName());
            String id = retrievedPot.getId().toString();
            return "Money Pot has been created with ID " + id;
        } else {
            return "Error adding Pot to database.Try Again.";
        }
    }

    public Pot findMoneyPot(Map<String, Object> requestParam){
        String id = requestParam.get("_id").toString();
        Pot retrievedPot = databaseConnection.findOneWithId(id);
        return retrievedPot;
    }

}
