import { tasksDesktopTemplate } from "./TasksDesktop";

function tasksTemplate(tasks) {
  return `
      <h2 class="task__title">Tasks</h2>
      <hr class="task__hr" />
      ${tasksDesktopTemplate(tasks)}
  `;
}

function renderTasks(tasks) {
  const tasksContainer = document.querySelector(".tasks");
  tasksContainer.innerHTML = tasksTemplate(tasks);
}

export { renderTasks };
