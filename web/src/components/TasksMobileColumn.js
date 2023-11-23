import { tasksMobileTaskTemplate } from "./TasksMobileTask";

function taskMobileColumnTemplate(tasks) {
  const tasksByStatus = sortTasksByStatus(tasks);

  let columnsHTML = "";

  tasksByStatus.forEach((tasks, status) => {
    const tasksHTML = tasks
      .map((task) => tasksMobileTaskTemplate(task))
      .join("");
    const cssStatusId = formatStatusToBem(status);
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

function formatStatusToBem(status) {
  return status.replaceAll(" ", "-").toLocaleLowerCase();
}

export { taskMobileColumnTemplate };
