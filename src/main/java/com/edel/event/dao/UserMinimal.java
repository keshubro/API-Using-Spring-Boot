package com.edel.event.dao;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by jitheshrajan on 4/24/18.
 */
@AllArgsConstructor
public class UserMinimal {
    @Id
    private String id;

    private String name;

    protected String email;

    public UserMinimal() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


}
