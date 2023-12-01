import { tasksMobileMenu } from "./TasksMobileMenu";
import { tasksMobileColumn } from "./TasksMobileColumn";

function tasksMobile(tasks) {
  return `
  <div class="tasks__mobile-container">
    ${tasksMobileMenu(tasks)}
    ${tasksMobileColumn(tasks)}
    </div>`;
}

export { tasksMobile };
