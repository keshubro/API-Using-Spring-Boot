package com.edel.event;

import com.edel.event.dao.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jitheshrajan on 4/23/18.
 */

public interface EventRepository extends MongoRepository<Event, String>, EventRepositoryCustom {
}
