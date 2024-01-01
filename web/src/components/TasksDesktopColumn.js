import { tasksDesktopTask, emptyDesktopTask } from "./TasksDesktopTask";
import { sortTasksByStatus } from "../util/Sort";

function tasksDesktopColumn(tasks) {
  const tasksByStatus = sortTasksByStatus(tasks);

  let columnsHTML = "";

  tasksByStatus.forEach((tasks, status) => {
    const tasksHTML = tasks.map((task) => tasksDesktopTask(task)).join("");
    
    columnsHTML += `
        <div class="tasks__desktop-column">
          <h2 class="tasks__column-title">${status}: <span class="tasks__total">${tasks.length}</span>
          </h2>
            ${tasksHTML}
        </div>
      `;
  });

  return columnsHTML;
}

export { tasksDesktopColumn };
