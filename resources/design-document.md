# v2-design-document

## ***1. Top Questions to Resolve in Review***

*Important questions:*

1. *Is the ERD well-designed, specifically regarding cardinality?*
2. *What is the API design and implementation in the code?*
3. *What are the general front end questions?*

## ***2. Use Cases***

*Customer use cases:*

- *1. As a user, I want to be able to get a project, to review information about its title and description.*
- *2. As a user, I want to be able to create a project with a title and description to begin adding tasks.*
- *3. As a user, I want to be able to delete a project, because the project was created by mistake.*
- *4. As a user, I want to be able to update a project, to change the name or description of a project.*
- *5. As a user, I want to be able to update a project, to mark it as complete.*

*Task use cases:*

- *6. As a user, I want to be able to get a task from a project, to review information about its title, description, and status.*
- *7. As a user, I want to be able to create a task for a project, with title and description.*
- *8. As a user, I want to be able to delete tasks from a project, because they were made by mistake.*
- *9. As a user, I want to be able to update tasks from a project, marking it as “complete” to show what work has been done.*

*Querying Tasks and Projects*

- *10. As a user, I want to be able to review a list of projects.*
- *11. As a user, I want to review a list of tasks on a project to overview the work on a project.*

## ***3. Project Scope***

*Clarify which parts of the problem you intend to solve.*

### ***3.1. In Scope***

*Which parts of the problem defined in Sections 1 and 2 will you solve with this design?*

- *CRUD functionality for a user to perform operations on tasks and projects.*

*The functionality described above should be what your design is focused on.*

### ***3.2. Out of Scope***

*Based on your problem description in Sections 1 and 2, are there any aspects you are not planning to solve?*

- *Implementing roles for users because our main focus is to allow any user to have access to CRUD functionality for projects and tasks.*
- *Ability to prioritize tasks.*
- *Creating specific users.*

*The functionality here does not need to be accounted for in your design.*

# ***4. Proposed Architecture Overview***

*Describe broadly how you are proposing to solve for the requirements you described in Section 2.*

*To satisfy our requirements, we will need to design (possibly) two DynamoDB tables that will contain Projects created by our users and tasks that will be added to the projects. Each project will be identified by its projectId (partition Key). Each task will be identified by its taskId (partition Key) and a projectId (sort key). This dual-table design will allow us to query tasks for a specific project in an easily developed model. Our API will essentially have a GET, POST and DELETE method for projects and tasks. Measures will be taken so that when a project is deleted, we are also deleting the tasks from its respective table and vice versa. Request objects will be created that will hold the parameters for each method.*

# ***5. API***

### ***5.1. Public Models***

*Define the data models your service will expose in its responses via your -Model package.*

### ***5.2. Get Project/Tasks Endpoint***

*Describe the behavior of the first endpoint you will build into your service API.*

*(You should have a separate section for each of the endpoints you are expecting to build...)*

- *Accepts GET requests to /projects/:projectId and/or /tasks/:taskId*
- *Accepts project ID and returns the corresponding ProjectModel.*
    - *If the given project ID is not found, will throw a ProjectNotFoundException.*
    - *If the given task ID is not found, wil throw a TaskNotFoundException.*

### ***5.3 Create Project and/or Create Task***

*(repeat, but you can use shorthand here, indicating what is different, likely primarily the data in/out and error conditions. If the sequence diagram is nearly identical, you can say in a few words how it is the same/different from the first endpoint)*

- *Accepts POST requests to /projects and/or /tasks.*
- *Accepts data to create a new project or a new task with a provided name and description. Returns the new project/task, including a unique projectId/taskId assigned by the task management service.*
- *For security concerns, we will validate the provided project/task name does not contain any invalid characters: " ' \*
    - *If the project/task name contains any of the invalid characters, will throw an InvalidAttributeValueException.*

### ***5.4 Update Project/Task Endpoint***

- *Accepts PUT requests to /projects/:projectId and /tasks/:taskId.*
- *Accepts data to update a project/task including a projectId/taskId, an updated project/task name and updated status. Returns the updated project or task.*
    - *If the project/task is not found, will throw a ProjectNotFoundException or TaskNotFoundException.*
- *For security concerns, we will validate the provided project/task name does not contain invalid characters: " ' \*
    - *If the project/task name contains invalid characters, will throw an InvalidAttributeValueException.*

### ***5.5 Delete Project/Task***

- *Accepts DELETE requests to /projects/:projectId and /tasks/:taskId.*
- *Accepts a projectId or taskId.*
    - *If the project or task is not found, will throw a ProjectNotFoundException or TaskNotFoundException.*

# ***6. Tables***

*Define the DynamoDB tables you will need for the data your service will use.*

### ***6.1 Projects***

| Field | Type |
| --- | --- |
| projectId | String (Hash Key) |
| name | String |
| description | String |
| status | String |

### ***6.2 Tasks***

| Field | Type |
| --- | --- |
| projectId | String (Hash Key) |
| taskId | String (Range Key) |
| name | String |
| description | String |
| status | String |
