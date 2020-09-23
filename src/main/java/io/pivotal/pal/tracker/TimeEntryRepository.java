package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    public  TimeEntry find(Long id);

    public TimeEntry update(long id, TimeEntry timeEntry);

    public List<TimeEntry> list();

    public TimeEntry delete(long id);
}
