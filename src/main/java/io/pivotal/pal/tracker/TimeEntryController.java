package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }
    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        System.out.println("time entry to create "+timeEntryToCreate);
        TimeEntry timeentry=this.timeEntryRepository.create(timeEntryToCreate);
        System.out.println("time in controller+++++"+timeentry);
         return new ResponseEntity<>(timeentry, HttpStatus.CREATED);
    }
    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long timeEntryId) {
        TimeEntry timeEntry = this.timeEntryRepository.find(timeEntryId);
        if (timeEntry != null) {
            return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(this.timeEntryRepository.list(),HttpStatus.OK);
    }

    @PutMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry>  update(@PathVariable long timeEntryId,@RequestBody TimeEntry expected) {

        TimeEntry updatedTimeEntry = this.timeEntryRepository.update(timeEntryId,expected);
        if (updatedTimeEntry != null) {
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry>  delete(@PathVariable long timeEntryId) {
        this.timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<TimeEntry> (HttpStatus.NO_CONTENT);
    }
}
