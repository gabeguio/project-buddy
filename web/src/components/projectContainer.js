import { projectContentCardTemplate } from "./projectContentCard";
import { projectOverview } from "./projectOverview";
import { projectMembers } from "./projectMembers";
import { projectTasks } from "./projectTasks";

function projectContentContainer(project, members, tasks) {
  const projectWrapperCard = document.createElement("div");
  projectWrapperCard.classList.add("project__content-wrapper");

  const overviewContent = projectOverview(project);
  const overviewCard = projectContentCardTemplate("overview", overviewContent);
  projectWrapperCard.appendChild(overviewCard);

  const membersContent = projectMembers(members);
  const membersCard = projectContentCardTemplate("members", membersContent);
  projectWrapperCard.appendChild(membersCard);

  console.log('zero')
  const tasksContent = projectTasks(tasks);
  console.log('first')
  const tasksCard = projectContentCardTemplate("tasks", tasksContent);
  projectWrapperCard.appendChild(tasksCard);

  return projectWrapperCard;
}

function renderProjectContentContainer(project, members, tasks) {
  const container = document.getElementById("project__content-container");
  if (container) {
    container.innerHTML = "";

    const projectCard = projectContentContainer(project, members, tasks);

    container.appendChild(projectCard);
  }
}

export { renderProjectContentContainer };
