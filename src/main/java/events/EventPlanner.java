package events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventPlanner {
    public static void main(String[] args) {
        LocalDate after = LocalDate.of(2022, 12, 29);
        LocalDate before = LocalDate.of(2023, 1, 1);

        Event event1 = new Event(LocalDate.of(2022, 12, 30), "petrecere");
        Event event2 = new Event(LocalDate.of(2022, 12, 31), "revelion");
        Event event3 = new Event(LocalDate.of(2022, 12, 29), "zi de nastere");
        Event event4 = new Event(LocalDate.of(2023, 2, 1), "after-party");

        List<Event> eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);

        System.out.println(findEventByDateInterval(before, after, eventList));
        System.out.println(getEventByDateInterval(before, after, eventList));
    }

    public static List<String> findEventByDateInterval(LocalDate before, LocalDate after, List<Event> eventList) {
        return eventList.stream()
                .filter(event -> event.getDate().isBefore(before))
                .filter(event -> event.getDate().isAfter(after))
                .map(event -> event.getName())
                .collect(Collectors.toList());
    }

    public static List<String> getEventByDateInterval(LocalDate before, LocalDate after, List<Event> eventList) {
        List<String> eventsInterval = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getDate().isAfter(after) && event.getDate().isBefore(before)) {
                eventsInterval.add(event.getName());
            }
        }
        return eventsInterval;
    }
}