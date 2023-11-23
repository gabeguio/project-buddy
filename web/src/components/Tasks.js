import { tasksDesktopTemplate } from "./TasksDesktop";
import { tasksMobileTemplate } from "./TasksMobile";
import { addTasksToggleBarLogic } from "./TasksMobileToggleSwitch";

function tasksTemplate(tasks) {
  return `
      <h2 class="task__title">Tasks</h2>
      <hr class="task__hr" />
      ${tasksDesktopTemplate(tasks)}
      ${tasksMobileTemplate(tasks)}
  `;
}

function renderTasks(tasks) {
  const tasksContainer = document.querySelector(".tasks");
  tasksContainer.innerHTML = tasksTemplate(tasks);
  addTasksToggleBarLogic();
}

export { renderTasks };
