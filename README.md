Github link: https://github.com/s3881314/A2

This is the sysmtem of Able Care Home for staff. In this system, I implemented the GUI and some basic functions. If you just downloaded this project, please open this project and run the "MenuForAbleCareHome.java" in "src/GUI" Intellij.

"DO NOT DELETE AuthorizationList.txt IN Archive"
"DO NOT DELETE root IN MangerList.txt"

If user wants to execute this project from scratch, please delete "Archive" in project and copy "Default Archive" as new "Archive" in "src"

For this system. I designed a few interfaces to implement log in/log out and the menu for each function. Using JavaFX and SceneBuilder to set up basic buttons and controllers. For the date, I used Datepicker to limit the input. Also, using choicebox for user to choose their position between manager, doctor and nurse.

User can type in account "root" and password "root" as manager to log in.

In the system, user can add manager, doctor, nurse and resident with proper authorization. Otherwise, the authorization exception will be catched. Also, there are some functions could only be execute by some staff. For example, only manager can add staff or resident to the system, only nurse can move resident to other bed, only doctor can attach and update prescription to patient via bed number.

While assigning shifts for medical staff, the amount of time for doctor should be less than 1 hour and the amount of time for nurse should be less than 8 hours. Also, the shifts for nurse are two specific shifts which are from 8am to 16pm and from 14pm to 22pm. The shift time shoulbe be set between 8am to 22pm. Otherwise, the ShiftException will be throw out. This will be checked in the method checkCompliance().

There is a function to show the status of bed in each ward. Blue as male, red as female and white as empty.

//How To Use This System//
In the login page, choose position and type in ID and password to get into the system. Choose the function which user would like to execute and fill in the information. On the right side of the page, there are two rows to show the current user position and ID. All the related files will be saved in Archive folder to store.
