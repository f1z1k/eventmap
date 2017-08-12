package com.example.sigkill.eventmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sigkill on 8/12/17.
 */

public class EventSaver {
    public List<Event> Events;
    private static final EventSaver ourInstance = new EventSaver();

    public static EventSaver getInstance() {
        return ourInstance;
    }

    private EventSaver() {
        Events = new ArrayList<Event>();
    }

    public void store_event(Event event) {
        Events.add(event);
    }
}
