import { projectDetailsAbout } from "./ProjectDetailsAbout";
import { projectDetailsMembers } from "./ProjectDetailsMembers";
import { projectDetailsTasks } from "./ProjectDetailsTasks";

function projectDetails(project, members, tasks) {
  return `
    <div class="project__details">
      <div id="about-content">
        ${projectDetailsAbout(project)}
      </div>
      <div id="tasks-content">
        ${projectDetailsTasks(tasks)}
      </div>
      <div id="members-content">
        ${projectDetailsMembers(members)}
      </div>
    </div>
  `;
}

export { projectDetails };
