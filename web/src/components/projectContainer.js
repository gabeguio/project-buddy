import { projectContentCardTemplate } from "./projectContentCard";
import { projectOverview } from "./projectOverview";
import { projectMembers } from "./projectMembers";

function projectContentContainer(project, members) {
  const projectWrapperCard = document.createElement("div");
  projectWrapperCard.classList.add("project__content-wrapper");

  const overviewContent = projectOverview(project);
  const overviewCard = projectContentCardTemplate("overview", overviewContent);
  projectWrapperCard.appendChild(overviewCard);

  const membersContent = projectMembers(members);
  const membersCard = projectContentCardTemplate("members", membersContent);
  projectWrapperCard.appendChild(membersCard);

  return projectWrapperCard;
}

function renderProjectContentContainer(project, members) {
  const container = document.getElementById("project__content-container");
  if (container) {
    container.innerHTML = "";

    const projectCard = projectContentContainer(project, members);

    container.appendChild(projectCard);
  }
}

export { renderProjectContentContainer };
