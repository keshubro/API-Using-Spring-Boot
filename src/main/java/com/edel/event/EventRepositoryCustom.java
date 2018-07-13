package com.edel.event;

import com.edel.event.dao.EventAggResponse;
import com.edel.event.dao.User;

import java.util.List;

/**
 * Created by jitheshrajan on 4/26/18.
 */
public interface EventRepositoryCustom {

    List<EventAggResponse> aggregateOnEventTypeMatch(String eventType);

    List<EventAggResponse> aggregateOnEventType();

    List<EventAggResponse> aggregateOnEventSeverity(Integer severity);

    List<EventAggResponse> aggregateOnEventSeverity();

    List<EventAggResponse> aggregateOnAssignedTo();

    List<EventAggResponse> aggregateOnAssignedTo(String userName);
}
