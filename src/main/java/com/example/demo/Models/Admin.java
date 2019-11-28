package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "admins")
public class Admin extends User {

    @Field("badgeId")

     private String badgeId ;
    public String getBadge() {
        return badgeId;
    }

    public void setBadge(String badge) {
        this.badgeId = badge;
    }


}
