# Room-Scheduler-GUI
A room scheduler GUI built in NetBeans (version 8.2) using SwingFX with a Derby database in the backend

This was a school project for a sophomore-level class. We were required to use an old verison of NetBeans (8.2) and Java JDK (8u281). I believe this is because JavaDB isn't included in current versions of NetBeans.

Requirements:\
  &nbsp;&nbsp;-Java JDK 8u281\
  &nbsp;&nbsp;-NetBeans 8.2
  &nbsp;&nbsp;-Derby Database
 
 Dependencies:\
  &nbsp;&nbsp;-JDatePicker\
  &nbsp;&nbsp;-JCalendar
  
  Instructions:\
    &nbsp;&nbsp;1) Install NetBeans 8.2 (https://www.oracle.com/technetwork/java/javase/downloads/jdk-netbeans-jsp-3413139-esa.html) \
    &nbsp;&nbsp;2) Install JDK 8u281 (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) \
    &nbsp;&nbsp;3) Install Derby Database (https://db.apache.org/derby/releases/release-10_14_2_0.cgi) \
    &nbsp;&nbsp;4) Clone repository\
    &nbsp;&nbsp;5) Open a NetBeans project and find the repository directory\
    &nbsp;&nbsp;6) Resolve the dependencies upon opening the project\
      &nbsp;&nbsp;&nbsp;&nbsp; click on dependency then the Resolve button to the right
      &nbsp;&nbsp;&nbsp;&nbsp;i) Room-Scheduler>Dependencies>jdatepicker-1.3.4.jar\
      &nbsp;&nbsp;&nbsp;&nbsp;ii) Room-Scheduler>Dependencies>jcalendar-1.4.jar\
    &nbsp;&nbsp;7) Go to the Services tab on the right hand side\
    &nbsp;&nbsp;8) Right click on Java DB and go to properties\
      &nbsp;&nbsp;&nbsp;&nbsp;set the following:\
      &nbsp;&nbsp;&nbsp;&nbsp;i) Java DB Installation: Downloads>db-derby-10.14.2.0 (where ever you saved derby to, most likely the Downloads folder)\
      &nbsp;&nbsp;&nbsp;&nbsp;ii) Database Location: Room Scheduler/Derby Databases\
    &nbsp;&nbsp;9) Run with the green sideways triangle in the top bar

