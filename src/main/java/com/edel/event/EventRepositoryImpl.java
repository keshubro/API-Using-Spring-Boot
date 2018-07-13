package com.edel.event;

import com.edel.event.dao.Event;
import com.edel.event.dao.EventAggResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


/**
 * Created by jitheshrajan on 4/26/18.
 */

public class EventRepositoryImpl implements EventRepositoryCustom {


    private final MongoTemplate mongoTemplate;

    @Autowired
    public EventRepositoryImpl(MongoTemplate mongoTemplate)
    {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<EventAggResponse> aggregateOnEventTypeMatch(String eventType) {
        System.out.println("Matching based on event Type!");
        MatchOperation matchOperation = match(Criteria.where("type").regex(java.util.regex.Pattern.compile(eventType).pattern(),"i"));

        UnwindOperation unwindOperation = unwind("custom_elements");

        System.out.println("Aggregating based on event Type!");
        GroupOperation groupOperation = group("assignedTo.name").count().as("count");


//        mongoTemplate.getCollection(
//        GroupOperation groupOperation1 = group("id").push("$$ROOT");

        ProjectionOperation projectionOperation = project("_id").and("count").previousOperation();

        System.out.println(newAggregation(
                matchOperation,
                unwindOperation,
                groupOperation,
                projectionOperation).toString());

        return mongoTemplate.aggregate(newAggregation(
                matchOperation,
                groupOperation
        ), Event.class, EventAggResponse.class).getMappedResults();

    }

    @Override
    public List<EventAggResponse> aggregateOnEventType() {
        System.out.println("Aggregating based on event Type! without param!");

        //        db.MWEvents.aggregate([{'$group' : {_id:'$type', count:{$sum:1}}} ])

        Aggregation agg = newAggregation(group("type").count().as("count"));

        AggregationResults<EventAggResponse> groupResults
                = mongoTemplate.aggregate(agg, Event.class, EventAggResponse.class);

        System.out.println(groupResults);
        List<EventAggResponse> result = groupResults.getMappedResults();


        return result;
    }

    @Override
    public List<EventAggResponse> aggregateOnEventSeverity(Integer severity) {

        System.out.println("Matching based on severity!");
        MatchOperation matchOperation = match(Criteria.where("severity").gte(severity));

        System.out.println("Aggregating based on severity "+severity);
        GroupOperation groupOperation = group("severity").count().as("count");

//        ProjectionOperation projectionOperation = project("_id").and("count").previousOperation();

        return mongoTemplate.aggregate(newAggregation(
                matchOperation,
                groupOperation), Event.class, EventAggResponse.class).getMappedResults();

    }

    @Override
    public List<EventAggResponse> aggregateOnEventSeverity() {
        System.out.println("Aggregating based on severity");
        GroupOperation groupOperation = group("severity").count().as("count");
        AggregationResults<EventAggResponse> groupResults
                = mongoTemplate.aggregate(newAggregation(groupOperation), Event.class, EventAggResponse.class);

        System.out.println(groupResults);
        List<EventAggResponse> result = groupResults.getMappedResults();

        return result;
    }

    @Override
    public List<EventAggResponse> aggregateOnAssignedTo() {


        System.out.println("Aggregating based on severity ");
        GroupOperation groupOperation = group("assignedTo.name").count().as("count");

//        ProjectionOperation projectionOperation = project("_id").and("count").previousOperation();

        return mongoTemplate.aggregate(newAggregation(
                groupOperation), Event.class, EventAggResponse.class).getMappedResults();

    }

    @Override
    public List<EventAggResponse> aggregateOnAssignedTo(String userName) {
        System.out.println("Matching based on severity!");
        MatchOperation matchOperation = match(Criteria.where("assignedTo.name").is(userName));

        System.out.println("Aggregating based on severity "+userName);
        GroupOperation groupOperation = group("assignedTo.name").count().as("count");

//        ProjectionOperation projectionOperation = project("_id").and("count").previousOperation();

        return mongoTemplate.aggregate(newAggregation(
                matchOperation,
                groupOperation), Event.class, EventAggResponse.class).getMappedResults();


    }
}
