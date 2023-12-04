function projectDetailsAbout(project) {
  return `
        <div class="project__about-container">
            <div class="project__description">
                <p>
                    ${project.description}
                </p>
            </div>
            <div>
                <ul class="project__attributes">
                    <li class="project__attribute">Tasks Complete: ${project.tasksCompleted}/${project.totalTasks}</li>
                    <li class="project__attribute">Due Date: ${project.dueDate}</li>
                    <li class="project__attribute">Owner: ${project.owner}</li>
                    <li class="project__attribute">Top Contributor: ${project.topContributor}</li>
                </ul>
            </div>
        </div>
      `;
}

export { projectDetailsAbout };
