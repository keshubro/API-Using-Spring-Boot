package com.edel.event;

import com.edel.event.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jitheshrajan on 4/23/18.
 */
public interface UserRepo extends MongoRepository<User, String> {
}
