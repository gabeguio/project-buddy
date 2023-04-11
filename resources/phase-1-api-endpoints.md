# phase-1-api-endpoints

# **API Endpoints**

Projects

- U1. As a user, I want to be able to get a project, to review information about its title and description.

| URL | /projects/{projectId} |
| --- | --- |
| Method | GET |
| Parameters | projectId |
| Request Data | Data structure for ProjectModel |
| Responses | • 200 ProjectModel 
• 404 ProjectNotFoundException |
- U2. As a user, I want to be able to create a project with a title and description to begin adding tasks.

| URL | /projects |
| --- | --- |
| Method | POST |
| Parameters | name, description |
| Request Data | nothing |
| Responses | • 405 InvalidAttributeValueException |
- U3. As a user, I want to be able to delete a project, because the project was created by mistake.

| URL | /projects/{projectId} |
| --- | --- |
| Method | DELETE |
| Parameters | projectId |
| Request Data | nothing |
| Responses | • 400 ProjectNotFoundException |
- U4. As a user, I want to be able to update a project, to change the name or description of a project.

| URL | /projects/{projectId} |
| --- | --- |
| Method | PUT |
| Parameters | projectId, name, description |
| Request Data | nothing |
| Responses | • 404 ProjectNotFoundException
• 405 InvalidAttributeValueException |
- U5. As a user, I want to be able to update a project, to mark it as complete.

| URL | /projects/{projectId} |
| --- | --- |
| Method | POST |
| Parameters | projectId, “COMPLETE” |
| Request Data | nothing |
| Responses | • 404 ProjectNotFoundException |
- U6. As a user, I want to be able to update a project, from complete to in progress, in case a project was incorrectly updated.

| URL | /projects/{projectId} |
| --- | --- |
| Method | POST |
| Parameters | projectId, “IN_PROGRESS” |
| Request Data | nothing |
| Responses | • 404 ProjectNotFoundException |

Tasks

- U1. As a user, I want to be able to get a task from a project, to review information about its title, description, and status.

| URL | /tasks/{taskId} |
| --- | --- |
| Method | GET |
| Parameters | taskId |
| Request Data | Data structure for TaskModel |
| Responses | • 200 TaskModel
• 404 TaskNotFoundException |
- U2. As a user, I want to be able to create a task for a project, with title, description.

| URL | /tasks/ |
| --- | --- |
| Method | POST |
| Parameters | name, description |
| Request Data | nothing |
| Responses | • 404 TaskNotFoundException
• 405 InvalidAttributeValueException |
- U3. As a user, I want to be able to delete tasks from a project, because they were made by mistake.

| URL | /projects/{projectId} |
| --- | --- |
| Method | DELETE |
| Parameters | projectId |
| Request Data | nothing |
| Responses | • 400 ProjectNotFoundException |
- U4. As a user, I want to be able to update tasks from a project, marking it as “complete” to show what work has been done.

| URL | /projects/{projectId} |
| --- | --- |
| Method | PUT |
| Parameters | name, description |
| Request Data | nothing |
| Responses | • 400 ProjectNotFoundException |

Querying Tasks and Projects

- U1. As a user, I want to be able to review a list of projects.

| URL | /projects/all/ |
| --- | --- |
| Method | GET (Scan) |
| Parameters | ? |
| Request Data | Returns List<ProjectModel> |
| Responses | • 200 List<ProjectModel> |
- U2. As a user, I want to review a list of tasks on a project to overview the work on a project.

| URL | /tasks/all/ |
| --- | --- |
| Method | GET (Query) |
| Parameters | projectId |
| Request Data | Returns List<TaskModels> |
| Responses | • 200 List<TaskModels> |