import { tasksMobileTask } from "./TasksMobileTask";

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

function sortTasksByStatus(tasks) {
  return tasks.reduce((map, task) => {
    const { status } = task;
    if (map.has(status)) {
      map.get(status).push(task);
    } else {
      map.set(status, [task]); // Store as an array for the status
    }
    return map;
  }, new Map());
}

function cssFormat(status) {
  return status.replaceAll(" ", "-").toLocaleLowerCase();
}

export { tasksMobileColumn };
