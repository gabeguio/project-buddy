function projectDetailsAbout(project) {
  return `
        <h3 class="project__details-title">
            About
        </h3>
        <div class="project__about-container">
            <div id="project__description-wrapper">
                <p class="project__description">
                    ${project.description}
                </p>
            </div>
            <div>
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
            </div>
        </div>
      `;
}

export { projectDetailsAbout };
