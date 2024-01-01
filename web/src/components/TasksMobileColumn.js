import { tasksMobileTask } from "./TasksMobileTask";
import { sortTasksByStatus } from "../util/Sort";

function tasksMobileColumn(tasks) {
  const tasksByStatus = sortTasksByStatus(tasks);

  let columnsHTML = "";

  tasksByStatus.forEach((tasks, status) => {
    const tasksHTML = tasks
      .map((task) => tasksMobileTask(task))
      .join("");
    const cssStatusId = cssFormat(status);
    columnsHTML += `
        <div class="tasks__mobile-column" id="${cssStatusId}-content">
            ${tasksHTML}
        </div>
      `;
  });
  return columnsHTML;
}

function cssFormat(status) {
  return status.replaceAll(" ", "-").toLocaleLowerCase();
}

export { tasksMobileColumn };
