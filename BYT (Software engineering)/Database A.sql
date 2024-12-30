CREATE TABLE Lesson
(
	Id varchar(36) NULL,
	Room varchar(255) NULL,
	Studentgroup varchar(255) NULL,
	Subject varchar(255) NULL,
	Teacher varchar(255) NULL,
	Timeslot varchar(255) NULL,
	LessonID varchar(36) NOT NULL,
	TimetableID varchar(36) NULL,
	TeacherID varchar(36) NULL,
	TimeslotID varchar(36) NULL,
	RoomID varchar(36) NULL,
	CONSTRAINT PK_Lesson PRIMARY KEY (LessonID)
)

;

CREATE TABLE Room
(
	Id varchar(36) NULL,
	Name varchar(255) NULL,
	RoomID varchar(36) NOT NULL,
	CONSTRAINT PK_Room PRIMARY KEY (RoomID)
)

;

CREATE TABLE Teacher
(
	Id varchar(36) NULL,
	Name varchar(255) NULL,
	TeacherID varchar(36) NOT NULL,
	CONSTRAINT PK_Teacher PRIMARY KEY (TeacherID)
)

;

CREATE TABLE Timeslot (
    Dayofweek varchar(36) NULL,
    Endtime timestamp with time zone NULL,
    Id varchar(36) NULL,
    Starttime timestamp with time zone NULL,
    TimeslotID varchar(36) NOT NULL,
    CONSTRAINT PK_Timeslot PRIMARY KEY (TimeslotID)
);


CREATE TABLE Timetable
(
	Lessons varchar(255) NULL,
	Name varchar(255) NULL,
	Rooms varchar(255) NULL,
	Score varchar(255) NULL,
	Solverstatus varchar(255) NULL,
	Timeslots varchar(255) NULL,
	TimetableID varchar(36) NOT NULL,
	CONSTRAINT PK_Timetable PRIMARY KEY (TimetableID)
)

;

ALTER TABLE Lesson 
 ADD CONSTRAINT FK_Lesson_Timetable
	FOREIGN KEY (TimetableID) REFERENCES Timetable (TimetableID) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Lesson 
 ADD CONSTRAINT FK_Lesson_who
	FOREIGN KEY (TeacherID) REFERENCES Teacher (TeacherID) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Lesson 
 ADD CONSTRAINT FK_Lesson_when
	FOREIGN KEY (TimeslotID) REFERENCES Timeslot (TimeslotID) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Lesson 
 ADD CONSTRAINT FK_Lesson_where
	FOREIGN KEY (RoomID) REFERENCES Room (RoomID) ON DELETE No Action ON UPDATE No Action
;

