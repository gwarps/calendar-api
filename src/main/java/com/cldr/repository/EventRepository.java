package com.cldr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.cldr.event.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

    @Query("SELECT e FROM Event e WHERE e.userId = :user_id")
    List<Event> findEventsByUser(@Param("user_id") Integer userId);
}