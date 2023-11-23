import { projectDetailsContainerTemplate } from "./ProjectDetails";
import { projectDetailsToggleBarTemplate } from "./ProjectDetailsToggleBar";
import { addProjectToggleBarLogic } from "./ProjectDetailsToggleBar";

function projectTemplate(project, members) {
  return `
    <h2 class="project__title">${project.title}</h2>
    <hr class="project__hr" />
    ${projectDetailsToggleBarTemplate()}
    ${projectDetailsContainerTemplate(project, members)}
`;
}

function renderProject(project, members) {
  const container = document.getElementById("project__content-container");
  container.innerHTML = projectTemplate(project, members);
  addProjectToggleBarLogic();
}

export { renderProject };
