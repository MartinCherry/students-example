# Student App Example

To run application run command - mvn spring-boot:run

Application is running on http://localhost:8080/students/

Application gives user options to:
* Add Tutor
* Add Course
* Add Student
* Register Course to Student

---

## Primary options

To add Tutor ->

http://localhost:8080/students/addTutor {POST}

```
{
  "id": 0,
  "name": "string",
  "surname": "string"
}
```

To add Course ->

http://localhost:8080/students/addCourse {POST}

```
{
  "name": "string",
  "tutor_id": 0
}
```
To add student ->

http://localhost:8080/students/addStudent {POST}

```
{
  "name": "string",
  "surname": "string"
}
```

To add Student with Course ->

http://localhost:8080/students/addStudentRequest {POST}

```
{
  "name": "string",
  "surname": "string",
  "courseId": 0
}
```

To add Course for already registered Student ->

http://localhost:8080/students/{studentID}/{courseID} {POST}


To get all Courses with their Tutors, that Studant has been registered to ->

http://localhost:8080/students/getStudentCourses {GET}


## Secondary options

| Function | Request Type| Description|
|:-----:|:---:|:--:|
| http://localhost:8080/students/getTutors/{tutorId} |  GET | Get specific Tutor |
| http://localhost:8080/students/getTutors |  GET | Get All Tutors |
| http://localhost:8080/students/getCourses/{courseId} |  GET | Get specific Course |
| http://localhost:8080/students/getCourses |  GET | Get All Courses |
| http://localhost:8080/students/geStudents/{StudentId} |  GET | Get specific Student |
| http://localhost:8080/students/getStudents |  GET | Get All Students |


---
# Databases
---

Application is configured to run on H2 database.
You can connect to database console from http://localhost:8080/h2-console

<img width="570" alt="Screenshot 2022-11-28 at 10 12 52" src="https://user-images.githubusercontent.com/109744061/204226638-87242734-632e-49d3-8c3b-7d549883c1ee.png">


___

## PostgreSQL

To configur database to work on PostgreSQL, change ```student-app.connection-type=[in-memory]``` [application.properties](https://github.com/MartinCherry/students-example/blob/main/src/main/resources/application.properties) 

to ```[postgresql]```

and configure [DatabaseConfiguration.java](https://github.com/MartinCherry/students-example/blob/main/src/main/java/com/example/studentexample/configuration/DatabaseConfiguration.java)

```
    String username = [PostgreSQL username];
    String password = [PostgreSQL password];
    String url = [PostgreSQL url];
```

---
## Swagger

Application is configured to work with swagger.

To acces swagger UI go to -> http://localhost:8080/swagger-ui/index.html
