function projectDetailsAbout(project) {
  return `
        <h3 class="project__details-title">
            About
        </h3>
        <p class="project__description">
            ${project.description}
        </p>
        <p class="project__attribute">
            Tasks Complete: ${project.tasksCompleted}/${project.totalTasks}
        </p>
        <p class="project__attribute">
            Due Date: ${project.dueDate}
        </p>
        <p class="project__attribute">
            Owner: ${project.owner}
        </p>
        <p class="project__attribute">
            Top Contributor: ${project.topContributor}
        </p> 
      `;
}

export { projectDetailsAbout };
