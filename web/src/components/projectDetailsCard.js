function projectDetailsCardTemplate(project) {
    // Define the maximum description length (e.g., 117 characters)
    const maxDescriptionLength = 237;
  
    // Truncate the description if it exceeds the maximum length
    const truncatedDescription =
      project.description.length > maxDescriptionLength
        ? project.description.slice(0, maxDescriptionLength) + "..."
        : project.description;
  
    return `
      <a href=/project.html?projectId=${project.projectId} class="projects__project-link">
        <div class="projects__project-wrapper">
          <div href="" class="projects__project-wrapper_details">
            <h2 class="projects__project-title">${project.title}</h2>
            <h3 class="projects__project-attribute">
              Tasks Complete: ${project.tasksCompleted}/${project.totalTasks}
            </h3>
            <h3 class="projects__project-attribute">
              Due Date: ${project.dueDate}
            </h3>
            <h3 class="projects__project-attribute">Owner: ${project.owner}</h3>
            <h3 class="projects__project-attribute">
              Top Contributor: ${project.topContributor}
            </h3>
          </div>
          <div class="projects__project-description">
            ${truncatedDescription}
          </div>
        </div>
      </a>
    `;
  }
  
  
  function renderProjects(projects, container) {
    const projectsContainer = document.querySelector(container);
  
    if (!projectsContainer) {
      console.error(`Container element ${container} not found.`);
      return;
    }
  
    projects.forEach((project) => {
      const projectDetailsCard = document.createElement("div");
      projectDetailsCard.innerHTML = projectDetailsCardTemplate(project);
      projectsContainer.appendChild(projectDetailsCard);
    });
  }
  
  export { projectDetailsCardTemplate, renderProjects };
  