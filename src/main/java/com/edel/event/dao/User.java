package com.edel.event.dao;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jitheshrajan on 4/23/18.
 */
@Document(collection = "MWUsers")
//@Builder
public class User extends UserMinimal{

    /*Important
    *
    *  Changing the class after the first time you run the application doesn't
     * necessarily change the schema in mongodb. New fields are added. And once an index
     * is created then removing the annotation from the class doesnt delete the index from
     * the schema! so if there is a change in the class, it is better to drop all indices and
     * re create!
    * */

    // TODO add default constructor if you want json to object deserialization! i.e if you want to add
    // post support here!

    @Builder
    public User(String id, String name, String email, Long createdAt, Integer severityAccessLevel) {
        super(id, name, email);
        this.createdAt = createdAt;
        this.severityAccessLevel = severityAccessLevel;
    }

    /*creating this for jackson*/
    public User(String id, String name, String email) {
        super(id, name, email);
    }

    public User(){

    }

    @CreatedDate
    private Long createdAt;

    private Integer severityAccessLevel;


    public Long getCreatedAt() {
        return createdAt;
    }

    public Integer getSeverityAccessLevel() {
        return severityAccessLevel;
    }

    public String getEmail() {
        return email;
    }
}
