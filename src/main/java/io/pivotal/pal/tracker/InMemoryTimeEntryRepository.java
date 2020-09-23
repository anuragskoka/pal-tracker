package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.*;

public class InMemoryTimeEntryRepository  implements TimeEntryRepository{

private Map timeEntyRepo= new HashMap<Long,TimeEntry>();
private long  timeEntrySeq=1L;

    public TimeEntry create(TimeEntry timeEntry) {
        long id=timeEntrySeq++;
       TimeEntry newTimeEntry= new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntyRepo.put(id,newTimeEntry);
        System.out.println("id un reporsitory"+id);
        System.out.println("id un reporsitory"+newTimeEntry);
        return newTimeEntry;
    }

//    private  long getNext() {
//        long  timeEntrySeq= 1L;
//        return timeEntrySeq=timeEntrySeq++;
//    }


    @Override
    public TimeEntry find(Long id) {
        return (TimeEntry) timeEntyRepo.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
       if( !timeEntyRepo.containsKey(id)) {
           return null;
       }
        TimeEntry updatedEntry=new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntyRepo.put(id,updatedEntry);
        return (TimeEntry) timeEntyRepo.get(id);



    }

    @Override
    public List<TimeEntry> list() {
        Collection<TimeEntry> values = timeEntyRepo.values();
        List<TimeEntry> listOfValues
                = new ArrayList<TimeEntry>(values);

        return listOfValues;
    }

    @Override
    public TimeEntry delete(long id) {
        return (TimeEntry) timeEntyRepo.remove(id);
    }


}
