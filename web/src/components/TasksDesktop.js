import { tasksDesktopColumn } from "./TasksDesktopColumn";

function tasksDesktop(tasks) {
  return `
    <div class="tasks__desktop-container">
      ${tasksDesktopColumn(tasks)}
    </div>
    `;
}

export { tasksDesktop };
