function projectTasks(tasks) {
  // Separate tasks into four categories by status
  const categories = {
    'To Do': [],
    'In Progress': [],
    'Under Review': [],
    'Completed': [],
  };

  // Group tasks by status
  tasks.forEach((task) => {
    categories[task.status].push(task);
  });

  // Create HTML for each category
  const categoryHTML = Object.entries(categories)
    .map(([status, tasksInCategory]) => `
      <div class="task-container__status-column">
        <h2>${status}</h2>
        ${tasksInCategory
          .map((task) => `
            <div class="tasks__task-wrapper">
              <div href="" class="tasks__task-wrapper_details">
                <h2 class="tasks__task-title">${task.title}</h2>
                <h3 class="tasks__task-attribute">${task.dateCreated}</h3>
                <h3 class="tasks__task-attribute">${task.assignedTo}</h3>
              </div>
              <div class="tasks__task-description">
                ${task.description}
              </div>
            </div>
          `)
          .join('')}
      </div>
    `)
    .join('');

  return `
    <div class="tasks__task-container">
      ${categoryHTML}
    </div>
  `;
}

export { projectTasks };