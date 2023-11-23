import { tasksMobileToggleSwitchTemplate } from "./TasksMobileToggleSwitch";
import { taskMobileColumnTemplate } from "./TasksMobileColumn";

function tasksMobileTemplate(tasks) {
  return `
  <div class="tasks__mobile-container">
    ${tasksMobileToggleSwitchTemplate(tasks)}
    ${taskMobileColumnTemplate(tasks)}
    </div>`;
}

export { tasksMobileTemplate };
