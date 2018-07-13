package com.edel.event;

import com.edel.event.dao.JHotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jitheshrajan on 4/19/18.
 */
@Repository
public interface JHotelRepo extends MongoRepository<JHotel, String> {

    @Query(value = "{'location.city':?0}")
    List<JHotel> findByCity(String city);

    List<JHotel> findByPricePerNightLessThan(int maxPrice);
}
