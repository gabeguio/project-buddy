import { tasksComponent } from "./TasksComponent.js";

function projectDetailsTasks(tasks) {
  return `
    <h3 class="project__details-title">
        Tasks
    </h3>
    <div class="tasks_tasks-container">
      ${tasksComponent(tasks)}
    </div>
    `;
}

export { projectDetailsTasks };
