function projectOverview(project) {
    return `
        <h3 class="project__attribute">
        Tasks Complete: ${project.tasksComplete}/${project.totalTasks}
        </h3>
        <h3 class="project__attribute">
        Due Date: ${project.dueDate}
        </h3>
        <h3 class="project__attribute">
        Owner: ${project.owner}
        </h3>
        <h3 class="project__attribute">
        Top Contributor: ${project.topContributor}
        </h3> 
        <p class="project__description">
        ${project.description}
        </p>
        <button class="btn">Add Task</button>
      `;
  }

  export { projectOverview };