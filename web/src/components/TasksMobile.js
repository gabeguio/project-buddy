import { taskMobileColumnTemplate } from "./TasksMobileColumn";

function tasksMobileTemplate(tasks) {
  return `
    <div class="tasks__mobile-container">
      ${taskMobileColumnTemplate(tasks)}
    </div>
    `;
}

export { tasksMobileTemplate }