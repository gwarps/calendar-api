package com.cldr.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import com.cldr.repository.EventRepository;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    // Get user events
    @GetMapping("/users/{user_id}/events")
    List<Event> getUserEvents(@PathVariable("user_id") Integer userId) {
        return eventRepository.findEventsByUser(userId);
    }

    // Get event by id
    @GetMapping("/users/{user_id}/events/{id}")
    Event getEvent(@PathVariable("id") Integer id) {
        return eventRepository.findById(id).get();
    }

    @PostMapping("/users/{user_id}/events")
    public @ResponseBody Event createEvent(@PathVariable("user_id") Integer userId, @RequestBody Event event) {
        event.setUserId(userId);
        return eventRepository.save(event);
    }
}
