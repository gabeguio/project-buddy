import { projectDetailsAbout } from "./ProjectDetailsAbout";
import { projectDetailsMembers } from "./ProjectDetailsMembers";

function projectDetailsContainerTemplate(project, members) {
  return `
    <div class="project__details-container">
      <div class="project__details" id="about-content">
        ${projectDetailsAbout(project)}
      </div>
      <div class="project__details" id="members-content">
        ${projectDetailsMembers(members)}
      </div>
    </div>
  `;
}

export { projectDetailsContainerTemplate };
