package com.edel.event.dao;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jitheshrajan on 4/23/18.
 */
@Document(collection = "MWEvents")
public class Event<T>{

    @Id
    private String id;
//    @Indexed(name = "ForeignKeyIndexForType", direction = IndexDirection.ASCENDING)
    private String type;
    private Integer severity = 0;
    @Indexed(direction = IndexDirection.DESCENDING)
    private Long eventTime = System.currentTimeMillis();
    private T data;
    private UserMinimal assignedTo;

    /*creating this for jackson*/
    public Event() {
    }

    @Builder
    public Event(String id, String type, Integer severity, Long eventTime, T data, UserMinimal assignedTo) {
        this.id = id;
        this.type = type;
        this.severity = severity;
        this.eventTime = eventTime;
        this.data = data;
        this.assignedTo = assignedTo;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getSeverity() {
        return severity;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public T getData() {
        return data;
    }

    public UserMinimal getAssignedTo() {
        return assignedTo;
    }

    public Event setAssignedTo(UserMinimal assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }
}

