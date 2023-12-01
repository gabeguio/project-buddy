import { projectDetails } from "./ProjectDetails";
import { projectDetailsMenu, configureProjectDetailsMenu } from "./ProjectDetailsMenu";
import { configureTasksMobileMenu } from "./TasksMobileMenu";

function projectComponent(project, members, tasks) {
  return `
    <h2 class="project__title">${project.title}</h2>
    <hr class="projects__hr" />
    ${projectDetailsMenu()}
    ${projectDetails(project, members, tasks)}

`;
}

function renderProject(project, members, tasks) {
  const container = document.querySelector(".project");
  container.innerHTML = projectComponent(project, members, tasks);
  configureProjectDetailsMenu();
  configureTasksMobileMenu();
}

export { renderProject };
