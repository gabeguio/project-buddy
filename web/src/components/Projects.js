import { truncateDesc, truncateDate } from "../util/Formatters";

function projectTemplate(project) {
  const {
    projectId,
    owner,
    dateCreated,
    dateLastUpdated,
    dateDue,
    title,
    description,
    totalCompletedTasks,
    totalTasks,
    topMemberByTasksCompleted,
  } = project;

  return `
      <a href=/project.html?projectId=${projectId} class="projects__link">
        <div href="" class="projects__wrapper">
          <h2 class="projects__title">${title}</h2>
          <p class="projects__description">${truncateDesc(description, 150)}</p>
          <hr class="projects__attribute-hr" />
          <div class="projects__attribute-container">
            <p class="projects__attribute">
              <button class="projects__icon">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" >
                    <path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 119 0 4.5 4.5 0 01-9 0zM3.751 20.105a8.25 8.25 0 0116.498 0 .75.75 0 01-.437.695A18.683 18.683 0 0112 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 01-.437-.695z" clip-rule="evenodd" />
                  </svg>
              </button>
              ${owner}
            </p>
            <p class="projects__attribute">
              <button class="projects__icon">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" >
                    <path fill-rule="evenodd" d="M6.75 2.25A.75.75 0 017.5 3v1.5h9V3A.75.75 0 0118 3v1.5h.75a3 3 0 013 3v11.25a3 3 0 01-3 3H5.25a3 3 0 01-3-3V7.5a3 3 0 013-3H6V3a.75.75 0 01.75-.75zm13.5 9a1.5 1.5 0 00-1.5-1.5H5.25a1.5 1.5 0 00-1.5 1.5v7.5a1.5 1.5 0 001.5 1.5h13.5a1.5 1.5 0 001.5-1.5v-7.5z" clip-rule="evenodd" />
                  </svg>
              </button>
              ${truncateDate(dateDue)}
            </p>
          </div>
        </div>  
      </a>
    `;
}

function renderProjects(projects) {
  const projectsContainer = document.querySelector(".projects__container");

  projects.forEach((project) => {
    const projectCard = document.createElement("div");
    projectCard.innerHTML = projectTemplate(project);
    projectsContainer.appendChild(projectCard);
  });
}

export { renderProjects };
