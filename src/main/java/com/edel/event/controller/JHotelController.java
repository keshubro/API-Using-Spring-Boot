package com.edel.event.controller;

import com.edel.event.JHotelRepo;
import com.edel.event.dao.JHotel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by jitheshrajan on 4/19/18.
 */
@RestController
@RequestMapping("/hotels")
public class JHotelController {

    private JHotelRepo jHotelRepo;

    public JHotelController(JHotelRepo jHotelRepo) {
        this.jHotelRepo = jHotelRepo;
    }

    @GetMapping("/all")
    public List<JHotel> getAll(){
        List<JHotel> hotels = this.jHotelRepo.findAll();
        return hotels;
    }

    @PutMapping
    public JHotel insert(@RequestBody JHotel hotel){

        JHotel newHotel = this.jHotelRepo.insert(hotel);

        System.out.println(newHotel.getId()+" "+newHotel.getName());

        return this.jHotelRepo.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody JHotel hotel){
        this.jHotelRepo.save(hotel);
    }


    @GetMapping("/{id}")
    public Optional<JHotel> getById(@PathVariable("id") String id){
        return this.jHotelRepo.findById(id);

    }

    @GetMapping("/price/{maxPrice}")
    public List<JHotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        List<JHotel> hotels = this.jHotelRepo.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<JHotel> getByCity(@PathVariable("city") String city)
    {
        List<JHotel> hotels = this.jHotelRepo.findByCity(city);
        return hotels;
    }


}
