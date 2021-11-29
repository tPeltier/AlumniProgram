# TODO
---
[] packages

[] change grad year from string to int
[] change attendant arrayList to ids and then just call the map to get names to display
[] email regex
[] regex for other places (ie name's should only be letters)

[] maybe change the way date time is user input
[] fix donation display
[] clean up all prints 
[] change from saving to temps to saving to live files

[] look into password checking
[] unit testing

[] make "real" events and alumni & make more of them 

[] add a button to kill inputs?

[] out of bounds handling for time and date entry 

    [] we need to only allow 0-23 and 0-59 for time input

[] deleting events/training causes errors while signing up to other events (nullPointer)



# DONE
[x] make sure that the user is logged out upon deletion
[x] rearrange methods so that things are easier to read
[x] finish javaDoc

    [x] alumni

    [x] commonMethods

    [x] donation

    [x] event

    [x] host

    [x] inOut

    [x] invalidEntry

    [x] training

    [x] ui

[] finish reports

    [x] events by year

    [] listing guest speakers

        [] need to implement guest speakers into save files

    [x] list of people attending an event

    [x] display host for event/training

    [x] list of events/training alumni is attending

    [x] listing alumni

    [] ect

[x] look into how we are handling people attending events 

    [x] make events also have a total number of open spots and what not

    [x] make it to where you can only sign up for an event once

    [] do we want to save alumni objects instead of just names in the attendants arrayList

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

[x] fix training menu

[x] add check to see if event/training/alumni exist while deleting?


[x] entering the wrong id sometimes doesn't display the options again

---

---
christian's feed back

1) Input validation -- for example, I successfully entered "no" as the Alumni's Graduation Year when creating a new account. You do validate in some areas though, as I was corrected for trying to enter "no" as the Year when creating an event. May want to ensure you're using that validation at all possible points.


2) Not really a bug, but the output of the Display Events section is inconsistent. It outputs most of the data of the event in a format like "Variable: Data" but then jumps to "the Host is Mary and their area of expertise is topic1. They can be reached at .." which feels a bit odd

[x] fix host toString


3) When I tried to "Attend an Event" and put in an Event ID that isn't listed, I get a Null Pointer Exception. Here's the stack trace, hopefully it helps:

Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Event.checkForAttendance(String)" because the return value of "java.util.TreeMap.get(Object)" is null
	at InOut.alreadyAttendingEvent(InOut.java:810)
	at UI.attendEventSubMenu(UI.java:224)
	at UI.eventInterface(UI.java:178)
	at UI.loggedIn(UI.java:100)
	at UI.userInterface(UI.java:28)
	at App.main(App.java:9)

[x] add check for event's existence 

4) As you noted in your email, files aren't writing to the same place they're reading, so accounts aren't persisting through bug testing

5) When donating to an event, there is no confirmation that the donation occurred. It simply accepts the number input and brings back the menu.

[x] display donations after making a donation

6) Under "See my Donations" the output formatting is off. For example, I got: "Donation amount205.0" followed  by the date and time. Adding a ": " before the number would clean it up nicely. Kudos on the timestamping.


7) Entering an hour and minute separately when creating an event feels strange. I'm sure you're doing this for ease of use on the backend, so I don't fault you for it, it just feels odd.


8) I can enter "nah" as an email address when creating an event. Maybe consider a regex validation on email address entries?


9) Null Pointer Exception when entering an invalid Event ID number in Delete Event

[x] call check for event method

10) After deleting my own account, I got a Null Pointer Exception. Here's the stack trace:

Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Alumni.getName()" because the return value of "java.util.TreeMap.get(Object)" is null
	at InOut.getAlumniName(InOut.java:341)
	at UI.loggedIn(UI.java:92)
	at UI.userInterface(UI.java:28)
	at App.main(App.java:9)


11) Getting an "invalid password" error when trying to log back in, despite being absolutely certain I'm entering the exact same (one letter) password that I entered when creating an account

