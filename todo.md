# TODO
---
[] packages
[] change from saving to temps to saving to live files
[] unit testing
[] rearrange methods so that things are easier to read
[] make "real" events and alumni & make more of them 

[] add a button to kill inputs?
[] finish javaDoc
    [x] alumni
    [] commonMethods
    [x] donation
    [x] event
    [x] host
    [] inOut
    [] invalidEntry
    [x] training
    [x] ui
[] finish reports
    [x] events by year
    [] listing guest speakers
    [] list of people attending an event
    [x] display host for event/training
    [] list of events/training alumni is attending
    [x] listing alumni
    [] ect
[] look into how we are handling people attending events 
    [x] make events also have a total number of open spots and what not
    [] do we want to save alumni objects instead of just names in the attendants arrayList
    [x] make it to where you can only sign up for an event once
[x] make toString human readable
    [x] alumni
    [x] events
    [x] training
[x] make it so you can only delete events you own (like editing)
[x] display alumni/event/training that was edited right after editing (only that obj, not the whole list)

### this might need more work
[x] make localDateTimes out of the date in the donation (see below)
### this could be incorrect, check
[x] finish save method for training
---
# LIST OF BUGS:
[x] negative numbers need help
[] out of bounds handling for time and date entry 
[x] fix training menu
[x] add check to see if event/training/alumni exist while deleting?
[] deleting events/training causes errors while signing up to other events (nullPointer)
[x] entering the wrong id sometimes doesn't display the options again
[] we need to only allow 0-23 and 0-59 for time input
[]
[]
[]
[]
---
* only ask for total number of seats
    * everything else is calculated 
    * open = total - attending
    * attending = size of arrayList?
* order should be total, open, attending