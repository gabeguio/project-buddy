import { tasksDesktopTask } from "./TasksDesktopTask";

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

export { tasksDesktopColumn };
