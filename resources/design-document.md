# Design Document

## Instructions

## Group 3 - Midstone Design

## 1. Problem Statement


_Reviewing and creating tasks for a software project._


## 2. Top Questions to Resolve in Review

_List the most important questions you have about your design, or things that you are still debating internally that you might like help to work through._

1. ERD is well-designed, specifically regarding cardinality.
2. API design and implementation in the code.
3. General front end questions.

## 3. Use Cases

_This is where we work backwards from the customer and define what our customers would like to do (and why). You may also include use cases for yourselves (as developers), or for the organization providing the product to customers._

U1. As a user, I want to be able to create tasks and add them to a project.

U2. As a user, I want to be able to delete tasks from a project.

U3. As a user, I want to review a list of tasks on a project to overview the work on a project.

U4. As a user, I would like to mark a task as complete to show what work has been done.

U5. As a user, I want to be able to create and/or delete a project.

U6. As a user, I want to be able to edit a project.

U7. As a user, I want to be able to review a list of projects.

## 4. Project Scope

_Clarify which parts of the problem you intend to solve. It helps reviewers know what questions to ask to make sure you are solving for what you say and stops discussions from getting sidetracked by aspects you do not intend to handle in your design._

### 4.1. In Scope

_Which parts of the problem defined in Sections 1 and 2 will you solve with this design? This should include the base functionality of your product. What pieces are required for your product to work?_

- CRUD functionality for a user to perform operations on tasks and projects.


_The functionality described above should be what your design is focused on. You do not need to include the design for any out of scope features or expansions._

### 4.2. Out of Scope

_Based on your problem description in Sections 1 and 2, are there any aspects you are not planning to solve? Do potential expansions or related problems occur to you that you want to explicitly say you are not worrying about now? Feel free to put anything here that you think your team can't accomplish in the unit, but would love to do with more time._

- Implementing roles for users because our main focus is to allow any user to have access to CRUD functionality for projects and tasks.
- Ability to prioritize tasks.

_The functionality here does not need to be accounted for in your design._

# 5. Proposed Architecture Overview

_Describe broadly how you are proposing to solve for the requirements you described in Section 2. This may include class diagram(s) showing what components you are planning to build. You should argue why this architecture (organization of components) is reasonable. That is, why it represents a good data flow and a good separation of concerns. Where applicable, argue why this architecture satisfies the stated requirements._
    
> To satisfy our requirements, we will need to design (possibly) two DynamoDB tables that will contain Projects created by our users and tasks that will be added to the projects. Each project will be identified by its projectId (partition Key). Each task will be identified by its taskId (partition Key) and a projectId (sort key). This dual-table design will allow us to query tasks for a specific project in an easily developed model. Our API will essentially have a GET, POST and DELETE method for projects and tasks. Measures will be taken so that when a project is deleted, we are also deleting the tasks from its respective table and vice versa.

# 6. API

## 6.1. Public Models

_Define the data models your service will expose in its responses via your *`-Model`* package. These will be equivalent to the *`PlaylistModel`* and *`SongModel`* from the Unit 3 project._

## 6.2. _First Endpoint_

_Describe the behavior of the first endpoint you will build into your service API. This should include what data it requires, what data it returns, and how it will handle any known failure cases. You should also include a sequence diagram showing how a user interaction goes from user to website to service to database, and back. This first endpoint can serve as a template for subsequent endpoints. (If there is a significant difference on a subsequent endpoint, review that with your team before building it!)_

_(You should have a separate section for each of the endpoints you are expecting to build...)_

## 6.3 _Second Endpoint_

_(repeat, but you can use shorthand here, indicating what is different, likely primarily the data in/out and error conditions. If the sequence diagram is nearly identical, you can say in a few words how it is the same/different from the first endpoint)_

# 7. Tables

_Define the DynamoDB tables you will need for the data your service will use. It may be helpful to first think of what objects your service will need, then translate that to a table structure, like with the *`Playlist` POJO* versus the `playlists` table in the Unit 3 project._

# 8. Pages

_Include mock-ups of the web pages you expect to build. These can be as sophisticated as mockups/wireframes using drawing software, or as simple as hand-drawn pictures that represent the key customer-facing components of the pages. It should be clear what the interactions will be on the page, especially where customers enter and submit data. You may want to accompany the mockups with some description of behaviors of the page (e.g. “When customer submits the submit-dog-photo button, the customer is sent to the doggie detail page”)_
