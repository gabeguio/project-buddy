import { taskDesktopColumnTemplate } from "./TasksDesktopColumn";

function tasksDesktopTemplate(tasks) {
  return `
    <div class="tasks__desktop-container">
      ${taskDesktopColumnTemplate(tasks)}
    </div>
    `;
}

export { tasksDesktopTemplate };
