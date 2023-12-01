import { tasksDesktop } from "./TasksDesktop";
import { tasksMobile } from "./TasksMobile";

function tasksComponent(tasks) {
  return `
    ${tasksDesktop(tasks)}
    ${tasksMobile(tasks)}
  `;
}

export { tasksComponent };
