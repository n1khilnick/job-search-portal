# Job Search Portal 

## Built With
* `Java 17`
* `Maven 4.0.0`
* `Spring Boot 3.0.5`
*  `IntelliJ IDEA 2023.1 (Community Edition)`


## Data Flow

### 1. Model:
* Created `Jobs` entity class along with data id, title, description, location, salary, enum jobType and added validations on them.
* Used @Table and @Entity annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like @Data, @NoArgsConstructor, @AllArgsConstructor getters and setters for those object generate automatically.
* Used various validation like @NotNull, @NotEmpty, @NotBlank, @Min, @Max, @Size, @Email and @Pattern on the fields.

### 2. Controller:
* Created `JobsController` class in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation @GetMapping , @PostMapping , @PutMapping , @DeleteMapping to map the HTTP web requests to the specific handler methods.
* Used @Valid annotations to trigger validations while inserting data.

#### API Reference:

* Add Jobs:
```*.sh-session
  http://localhost:8080/jobs/save
```

* Get all Jobs:
```*.sh-session
  http://localhost:8080/jobs/getAll
```

* Get Jobs By ID:
```*.sh-session
  http://localhost:8080/jobs/searchJobs/{title}
```

* Get Jobs by jobType:
```*.sh-session
  http://localhost:8080/jobs/searchJobs/jobType/{jobType}
```

* Get Jobs by Job title and description:
```*.sh-session
  http://localhost:8080/jobs/searchJobs/{title}/{description}
```

* Update Jobs by Job Type
```*.sh-session
  http://localhost:8080/jobs/update/{id}/{jobType}
```

* Delete Jobs by ID
```*.sh-session
  http://localhost:8080/jobs/delete/{id}
```


### 3. Service:
* Created `JobService` class in which provide some business functionalities of every handler methods.
* Used **@Service** annotation to indicate that a class belongs to the service layer.

### 4. Repository:
* Created `JobDao` interface class that extends CrudRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used Iterable <Jobs> to manage the data of Users by performing CRUD operations.
* Used **@Repository** annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.

## Data Structure Used
* Used Iterable<Jobs> to store the Jobs type object.

## Project Summary
* In this project I performed CRUD operation like add user,get user,delete user and update user.<br/>
* I had also performed validation on entity fields by using various validations annotations like @NotNull, @NotEmpty, @NotBlank, @Min, @Max, @Size, @Email and @Pattern on the fields.<br/>
* Also used interface CrudRepository class for generic CRUD inbuilt operations like save,saveAll,updateById, etc.<br/>
* Created and used my own custom finder methods and wrote operations using custom queries.<br/>
