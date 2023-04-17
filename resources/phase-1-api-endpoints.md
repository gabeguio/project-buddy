# **API Endpoints**

Projects

- U1. As a user, I want to be able to get a project, to review information about its title and description.

| URL | /projects/{projectId}                              |
| --- |----------------------------------------------------|
| Method | GET                                                |
| Parameters | projectId                                          |
| Request Data | Data structure for ProjectModel                    |
| Responses | • 200 ProjectModel  • 404 ProjectNotFoundException |
- U2. As a user, I want to be able to create a project with a title and description to begin adding tasks.

| URL | /projects/                                                                              |
| --- |-----------------------------------------------------------------------------------------|
| Method | POST                                                                                    |
| Parameters |                                                                                         |
| Request Data | name, description                                                                       |
| Responses | • 200 return recently saved project (ProjectModel) • 405 InvalidAttributeValueException |
- U3. As a user, I want to be able to delete a project, because the project was created by mistake.

| URL | /projects/{projectId}                                                           |
| --- |---------------------------------------------------------------------------------|
| Method | DELETE                                                                          |
| Parameters | projectId                                                                       |
| Request Data | nothing                                                                         |
| Responses | • 200 returning the database item (ProjectModel) • 400 ProjectNotFoundException |
- U4. As a user, I want to be able to update a project, to change the name or description of a project.

| URL | /projects/{projectId}                                                                                                  |
| --- |------------------------------------------------------------------------------------------------------------------------|
| Method | PUT                                                                                                                    |
| Parameters |                                                                                                                        |
| Request Data | projectId, name, description, status                                                                                   |
| Responses | • 200 returning the item just saved (ProjectModel) • 404 ProjectNotFoundException • 405 InvalidAttributeValueException |
- U5. As a user, I want to be able to update a project, to mark it as complete.

| URL | /projects/status-update/projectId                                   |
| --- |---------------------------------------------------------------------|
| Method | PUT                                                                 |
| Parameters | projectId, “COMPLETE”                                               |
| Request Data | Object Status - String StatusENUMs- BACKLOG- IN_PROGRESS- COMPLETED |
| Responses | • 200 • 401 InvalidRequestException • 404 ProjectNotFoundException  |

Tasks

- U1. As a user, I want to be able to get a task from a project, to review information about its title, description, and status.

| URL | /tasks/{taskId}                             |
| --- |---------------------------------------------|
| Method | GET                                         |
| Parameters | taskId                                      |
| Request Data | Data structure for TaskModel                |
| Responses | • 200 TaskModel • 404 TaskNotFoundException |
- U2. As a user, I want to be able to create a task for a project, with title, description.

| URL |  /projects/{projectid}/tickets                                                                                           |
| --- |------------------------------------------------------------------------------------------------------|
| Method | POST                                                                                                 |
| Parameters |                                                                                                      |
| Request Data | name, description, status                                                                            |
| Responses | • 200 item created sent to database • 404 TaskNotFoundException • 405 InvalidAttributeValueException |
- U3. As a user, I want to be able to delete tasks from a project, because they were made by mistake.

| URL | /tasks/{taskId}                                                    |
| --- |--------------------------------------------------------------------|
| Method | DELETE                                                             |
| Parameters | taskId                                                             |
| Request Data | nothing                                                            |
| Responses | • 200 item created sent to database • 400 ProjectNotFoundException |
- U4. As a user, I want to be able to update tasks from a project, marking it as “complete” to show what work has been done.

| URL | /tasks/status-update/taskId                                         |
| --- |---------------------------------------------------------------------|
| Method | PUT                                                                 |
| Parameters | taskId                                                              |
| Request Data | Object Status - String StatusENUMs- BACKLOG- IN_PROGRESS- COMPLETED |
| Responses | • 200 • 401 InvalidRequestException • 404 ProjectNotFoundException  |

Querying Tasks and Projects

- U1. As a user, I want to be able to review a list of projects.

| URL | /projects/ |
| --- | --- |
| Method | GET (Scan) |
| Parameters | ? |
| Request Data | Returns List<ProjectModel> |
| Responses | • 200 List<ProjectModel> |
- U2. As a user, I want to review a list of tasks on a project to overview the work on a project.

| URL | /projects/{projectId}/tasks |
| --- | --- |
| Method | GET (Query) |
| Parameters | projectId |
| Request Data | Returns List<TaskModels> |
| Responses | • 200 List<TaskModels> |