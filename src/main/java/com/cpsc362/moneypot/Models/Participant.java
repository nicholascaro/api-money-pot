package com.cpsc362.moneypot.Models;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import lombok.NonNull;

import java.util.Date;

@AllArgsConstructor
public class Participant {

    @BsonProperty(value = "name")
    private String name;

    @BsonProperty(value = "position")
    private Integer position;

    @BsonProperty(value = "date")
    private Date date;


    public Participant(){

    }

    public String getName(){
        return name;
    }

    public Participant setName(String name){
        this.name = name;
        return this;
    }

    public Integer getPosition(){
        return position;
    }

    public Participant setPosition(Integer position){
        this.position = position;
        return this;
    }

    public Date getDate(){
        return date;
    }

    public Participant setDate(Date date){
        this.date = date;
        return this;
    }
}
