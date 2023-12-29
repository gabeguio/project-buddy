import { sortTasksByStatus } from "../util/Sort";

function tasksMobileMenu(tasks) {
  const tasksByStatus = sortTasksByStatus(tasks);

  return `
    <div class="tasks__mobile-menu">
        <button class="tasks__mobile-btn" id="to-do-btn">
            <div>
              <p>To Do: 
                <span class="tasks__total">
                ${tasksByStatus.get("To Do").length}
                </span>
              </p>
            </div>
            <div class="tasks__mobile-check" id="to-do-check">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" >
                <path fill-rule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12zm13.36-1.814a.75.75 0 10-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 00-1.06 1.06l2.25 2.25a.75.75 0 001.14-.094l3.75-5.25z" clip-rule="evenodd" />
              </svg>
          </div>
        </button>
        <button class="tasks__mobile-btn" id="in-progress-btn">
            <div>
              <p>In Progress: 
                <span class="tasks__total">
                ${tasksByStatus.get("In Progress").length}
                </span>
              </p>
            </div>
            <div class="tasks__mobile-check" id="in-progress-check">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" >
              <path fill-rule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12zm13.36-1.814a.75.75 0 10-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 00-1.06 1.06l2.25 2.25a.75.75 0 001.14-.094l3.75-5.25z" clip-rule="evenodd" />
              </svg>
            </div>
        </button>
        <button class="tasks__mobile-btn" id="under-review-btn">
            <div>
              <p>Under Review: 
                <span class="tasks__total">
                ${tasksByStatus.get("Under Review").length}
                </span>
              </p>
            </div>
            <div class="tasks__mobile-check" id="under-review-check">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" >
                <path fill-rule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12zm13.36-1.814a.75.75 0 10-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 00-1.06 1.06l2.25 2.25a.75.75 0 001.14-.094l3.75-5.25z" clip-rule="evenodd" />
              </svg>
          </div>
        </button>
        <button class="tasks__mobile-btn" id="completed-btn">
            <div>
              <p>Completed: 
                <span class="tasks__total">
                ${tasksByStatus.get("Completed").length}
                </span>
              </p>
            </div>
            <div class="tasks__mobile-check" id="completed-check">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" >
                <path fill-rule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12zm13.36-1.814a.75.75 0 10-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 00-1.06 1.06l2.25 2.25a.75.75 0 001.14-.094l3.75-5.25z" clip-rule="evenodd" />
              </svg>
          </div>
        </button>
  </div>`;
}

function configureTasksMobileMenu() {
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

  // Checks content by status
  const todoCheck = document.getElementById("to-do-check");
  const inProgressCheck = document.getElementById("in-progress-check");
  const underReviewCheck = document.getElementById("under-review-check");
  const completedCheck = document.getElementById("completed-check");

  // Initially, show the "to-do-column" content
  todoButton.classList.add("tasks__mobile-btn_selected");
  inProgressContent.style.display = "none";
  underReviewContent.style.display = "none";
  completedContent.style.display = "none";

  // Default checks
  todoCheck.style.display = "block";
  inProgressCheck.style.display = "none";
  underReviewCheck.style.display = "none";
  completedCheck.style.display = "none";

  // Show the "to-do" content and hide the "in-progress", "under-review", and "completed" content.
  todoButton.addEventListener("click", () => {
    // Toggle select for "to-do" button
    todoButton.classList.add("tasks__mobile-btn_selected");

    // Toggle unselect for "in-progress", "under-review", and "completed" buttons
    inProgressButton.classList.remove("tasks__mobile-btn_selected");
    underReviewButton.classList.remove("tasks__mobile-btn_selected");
    completedButton.classList.remove("tasks__mobile-btn_selected");

    // Toggle display 'block' for all "to-do" content tasks and todo check
    todoContent.style.display = "block";
    todoCheck.style.display = "block";

    // Toggle display 'none' for all "in-progress", "under-review", and "completed" content tasks
    inProgressContent.style.display = "none";
    underReviewContent.style.display = "none";
    completedContent.style.display = "none";

    // Toggle checks for each status off
    inProgressCheck.style.display = "none";
    underReviewCheck.style.display = "none";
    completedCheck.style.display = "none";
  });

  // Show the "in-progress" content and hide the "to-do", "under-review", and "completed" content.
  inProgressButton.addEventListener("click", () => {
    // Toggle select for "in-progress" button
    inProgressButton.classList.add("tasks__mobile-btn_selected");

    // Toggle unselect for "to-do", "under-review", and "completed" buttons
    todoButton.classList.remove("tasks__mobile-btn_selected");
    underReviewButton.classList.remove("tasks__mobile-btn_selected");
    completedButton.classList.remove("tasks__mobile-btn_selected");

    // Toggle display 'block' for all "in-progress" content tasks
    inProgressContent.style.display = "block";
    inProgressCheck.style.display = "block";

    // Toggle display 'none' for all "to-do", "under-review", and "completed" content tasks
    todoContent.style.display = "none";
    underReviewContent.style.display = "none";
    completedContent.style.display = "none";

    // Toggle checks for each status off
    todoCheck.style.display = "none";
    underReviewCheck.style.display = "none";
    completedCheck.style.display = "none";
  });

  // Show the "under-review" content and hide the "to-do", "in-progress", and "completed" content.
  underReviewButton.addEventListener("click", () => {
    // Toggle select for "under-review" button
    underReviewButton.classList.add("tasks__mobile-btn_selected");

    // Toggle unselect for "to-do", "in-progress", and "completed" buttons
    todoButton.classList.remove("tasks__mobile-btn_selected");
    inProgressButton.classList.remove("tasks__mobile-btn_selected");
    completedButton.classList.remove("tasks__mobile-btn_selected");

    // Toggle display 'block' for all "under-review" content tasks
    underReviewContent.style.display = "block";
    underReviewCheck.style.display = "block";

    // Toggle display 'none' for all "to-do", "in-progress", and "completed" content tasks
    todoContent.style.display = "none";
    inProgressContent.style.display = "none";
    completedContent.style.display = "none";

    // Toggle checks for each status off
    todoCheck.style.display = "none";
    inProgressCheck.style.display = "none";
    completedCheck.style.display = "none";
  });

  // Show the "completed" content and hide the "to-do", "in-progress", and "under-review" content.
  completedButton.addEventListener("click", () => {
    // Toggle select for "completed" button
    completedButton.classList.add("tasks__mobile-btn_selected");

    // Toggle unselect for "to-do", "in-progress", and "under-review" buttons
    todoButton.classList.remove("tasks__mobile-btn_selected");
    inProgressButton.classList.remove("tasks__mobile-btn_selected");
    underReviewButton.classList.remove("tasks__mobile-btn_selected");

    // Toggle display 'block' for all "completed" content tasks
    completedContent.style.display = "block";
    completedCheck.style.display = "block";

    // Toggle display 'none' for all "to-do", "in-progress", and "under-review" content tasks
    todoContent.style.display = "none";
    inProgressContent.style.display = "none";
    underReviewContent.style.display = "none";

    // Toggle checks for each status off
    todoCheck.style.display = "none";
    inProgressCheck.style.display = "none";
    underReviewCheck.style.display = "none";
  });
}

export { tasksMobileMenu, configureTasksMobileMenu };
