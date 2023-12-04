import { tasksComponent } from "./TasksComponent.js";

function projectDetailsTasks(tasks) {
  return `
    <div class="tasks_tasks-container">
      ${tasksComponent(tasks)}
    </div>
    `;
}

export { projectDetailsTasks };
