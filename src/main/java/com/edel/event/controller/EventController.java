package com.edel.event.controller;

import com.edel.event.EventRepository;
import com.edel.event.dao.Event;
import com.edel.event.dao.EventAggResponse;
import com.edel.event.dao.UserMinimal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by jitheshrajan on 4/23/18.
 */
@RestController
@RequestMapping("/events")
public class EventController {


    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository)
    {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/all")
    public List<Event> getAll() {
        List<Event> events = this.eventRepository.findAll();
        return events;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") String id) {
        Optional optionalEvent = this.eventRepository.findById(id);

        if (optionalEvent != null && optionalEvent.get() != null) {
            this.eventRepository.deleteById(id);
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    @PutMapping
    public Event insert(@RequestBody Event event){
        Event newEvent = this.eventRepository.insert(event);
        return newEvent;
    }

    @PostMapping
    public Event update(@RequestBody Event event){



        if(event.getId() != null){
            Optional<Event> opEvent =  this.eventRepository.findById(event.getId());
            if(opEvent != null && opEvent.isPresent()){
                Event existingEvent = opEvent.get();

                // copy values from old to new event!

            }
            Event newEvent = this.eventRepository.findById(event.getId()).get();
        }

        return this.eventRepository.save(event);
    }


    @GetMapping("/{id}")
    public Optional<Event> getById(@PathVariable("id") String id){
        return this.eventRepository.findById(id);

    }

    @PostMapping("/{id}/assign")
    public Event addAssignedTo(@RequestBody UserMinimal userMinimal, @PathVariable(value = "id") String id){

        Optional<Event> opEvent =  this.eventRepository.findById(id);

        if(opEvent != null && opEvent.isPresent()){
            Event event = opEvent.get();
            event  = event.setAssignedTo(userMinimal);
            return this.eventRepository.save(event);
        } else{
            return null;
        }
    }

    @GetMapping("/typeAgg")
    public List<EventAggResponse> getAggregatedReport(@RequestParam(value = "eventType",required = false) String eventType){
        List<EventAggResponse> events;

        if(eventType == null){
            events = this.eventRepository.aggregateOnEventType();
        }else{
            events = this.eventRepository.aggregateOnEventTypeMatch(eventType);
        }

        return events;
    }

    @GetMapping("/sevAgg")
    public List<EventAggResponse> getAggregatedReportBasedOnSeverity(@RequestParam(value = "sev" ,required = false) Integer sev){
        List<EventAggResponse> events;

        if(sev == null){
            events = this.eventRepository.aggregateOnEventSeverity();
        }else{
            events = this.eventRepository.aggregateOnEventSeverity(sev);
        }

        return events;
    }

    @GetMapping("/userAgg")
    public List<EventAggResponse> getAggregatedReportBasedOnUserName(@RequestParam(value = "usr" ,required = false) String  userName){
        List<EventAggResponse> events;

        if(userName == null){
            events = this.eventRepository.aggregateOnAssignedTo();
        }else{
            events = this.eventRepository.aggregateOnAssignedTo(userName);
        }

        return events;
    }


}

