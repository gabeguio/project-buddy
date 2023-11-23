function tasksMobileToggleSwitchTemplate(tasks) {
  const tasksByStatus = sortTasksByStatus(tasks);

  return `
    <div class="tasks__mobile-toggle-switch-container">
        <button class="tasks__mobile-toggle-status-btn" id="to-do-btn">
            To Do
            <span class="tasks__column-status-title_number">
            ${tasksByStatus.get("To Do").length}
            </span>
        </button>
        <button class="tasks__mobile-toggle-status-btn" id="in-progress-btn">
            In Progress
            <span class="tasks__column-status-title_number">
            ${tasksByStatus.get("In Progress").length}
            </span>
        </button>
        <button class="tasks__mobile-toggle-status-btn" id="under-review-btn">
            Under Review
            <span class="tasks__column-status-title_number">
            ${tasksByStatus.get("Under Review").length}
            </span>
        </button>
        <button class="tasks__mobile-toggle-status-btn" id="completed-btn">
            Complete
            <span class="tasks__column-status-title_number">
            ${tasksByStatus.get("Completed").length}
            </span>
        </button>
  </div>`;
}

function addTasksToggleBarLogic() {
  // Buttons
  const todoButton = document.getElementById("to-do-btn");
  const inProgressButton = document.getElementById("in-progress-btn");
  const underReviewButton = document.getElementById("under-review-btn");
  const completedButton = document.getElementById("completed-btn");

  // Tasks content by status
  const todoContent = document.getElementById("to-do-content");
  const inProgressContent = document.getElementById("in-progress-content");
  const underReviewContent = document.getElementById("under-review-content");
  const completedContent = document.getElementById("completed-content");

  // Initially, show the "to-do-column" content
  todoButton.classList.add("tasks__mobile-toggle-status-btn_selected");
  inProgressContent.style.display = "none";
  underReviewContent.style.display = "none";
  completedContent.style.display = "none";

  // Show the "to-do" content and hide the "in-progress", "under-review", and "completed" content.
  todoButton.addEventListener("click", () => {
    // Toggle select for "to-do" button
    todoButton.classList.add("tasks__mobile-toggle-status-btn_selected");

    // Toggle unselect for "in-progress", "under-review", and "completed" buttons
    inProgressButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );
    underReviewButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );
    completedButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );

    // Toggle display 'block' for all "to-do" content tasks
    todoContent.style.display = "block";

    // Toggle display 'none' for all "in-progress", "under-review", and "completed" content tasks
    inProgressContent.style.display = "none";
    underReviewContent.style.display = "none";
    completedContent.style.display = "none";
  });

  // Show the "in-progress" content and hide the "to-do", "under-review", and "completed" content.
  inProgressButton.addEventListener("click", () => {
    // Toggle select for "in-progress" button
    inProgressButton.classList.add("tasks__mobile-toggle-status-btn_selected");

    // Toggle unselect for "to-do", "under-review", and "completed" buttons
    todoButton.classList.remove("tasks__mobile-toggle-status-btn_selected");
    underReviewButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );
    completedButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );

    // Toggle display 'block' for all "in-progress" content tasks
    inProgressContent.style.display = "block";

    // Toggle display 'none' for all "to-do", "under-review", and "completed" content tasks
    todoContent.style.display = "none";
    underReviewContent.style.display = "none";
    completedContent.style.display = "none";
  });

  // Show the "under-review" content and hide the "to-do", "in-progress", and "completed" content.
  underReviewButton.addEventListener("click", () => {
    // Toggle select for "under-review" button
    underReviewButton.classList.add("tasks__mobile-toggle-status-btn_selected");

    // Toggle unselect for "to-do", "in-progress", and "completed" buttons
    todoButton.classList.remove("tasks__mobile-toggle-status-btn_selected");
    inProgressButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );
    completedButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );

    // Toggle display 'block' for all "under-review" content tasks
    underReviewContent.style.display = "block";

    // Toggle display 'none' for all "to-do", "in-progress", and "completed" content tasks
    todoContent.style.display = "none";
    inProgressContent.style.display = "none";
    completedContent.style.display = "none";
  });

  // Show the "completed" content and hide the "to-do", "in-progress", and "under-review" content.
  completedButton.addEventListener("click", () => {
    // Toggle select for "completed" button
    completedButton.classList.add("tasks__mobile-toggle-status-btn_selected");

    // Toggle unselect for "to-do", "in-progress", and "under-review" buttons
    todoButton.classList.remove("tasks__mobile-toggle-status-btn_selected");
    inProgressButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );
    underReviewButton.classList.remove(
      "tasks__mobile-toggle-status-btn_selected"
    );

    // Toggle display 'block' for all "completed" content tasks
    completedContent.style.display = "block";

    // Toggle display 'none' for all "to-do", "in-progress", and "under-review" content tasks
    todoContent.style.display = "none";
    inProgressContent.style.display = "none";
    underReviewContent.style.display = "none";
  });
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

export { tasksMobileToggleSwitchTemplate, addTasksToggleBarLogic };
