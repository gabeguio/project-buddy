function projectHeaderTemplate(project) {
  return `
        <h2 class="project__title">${project.title}</h2>
        <hr class="project__hr" />
        <div class="project__switch-bar">
            <button class="project__btn-switch" id="btn-overview">Overview</button>
            <button class="project__btn-switch" id="btn-members">Members</button>
            <button class="project__btn-switch" id="btn-tasks">Tasks</button>
        </div>
    `;
}

function addSwitchBarLogic() {
  const overviewButton = document.getElementById("btn-overview");
  const membersButton = document.getElementById("btn-members");
  const tasksButton = document.getElementById("btn-tasks");
  const overviewContent = document.getElementById("overview");
  const membersContent = document.getElementById("members");
  const tasksContent = document.getElementById("tasks");

  // Initially, show the "Overview" content.
  overviewButton.classList.add("project__btn-switch_selected");
  membersContent.style.display = "none";
  tasksContent.style.display = "none";

  overviewButton.addEventListener("click", () => {
    // Show the "Overview" content and hide the "Members" content.
    overviewButton.classList.add("project__btn-switch_selected");
    membersButton.classList.remove("project__btn-switch_selected");
    tasksButton.classList.remove("project__btn-switch_selected");
    overviewContent.style.display = "block";
    membersContent.style.display = "none";
    tasksContent.style.display = "none";
  });

  membersButton.addEventListener("click", () => {
    // Show the "Members" content and hide the "Overview" content.
    membersButton.classList.add("project__btn-switch_selected");
    overviewButton.classList.remove("project__btn-switch_selected");
    tasksButton.classList.remove("project__btn-switch_selected");
    membersContent.style.display = "block";
    overviewContent.style.display = "none";
    tasksContent.style.display = "none";
  });

  tasksButton.addEventListener("click", () => {
    // Show the "Tasks" content and hide the "Overview" content.
    tasksButton.classList.add("project__btn-switch_selected");
    overviewButton.classList.remove("project__btn-switch_selected");
    membersButton.classList.remove("project__btn-switch_selected");
    tasksContent.style.display = "block";
    overviewContent.style.display = "none";
    membersContent.style.display = "none";
  });
}

function renderProjectHeader(project) {
  const projectHeaderElement = document.getElementById("project__header");

  if (projectHeaderElement) {
    projectHeaderElement.innerHTML = "";

    const projectHeaderContent = projectHeaderTemplate(project);
    projectHeaderElement.innerHTML = projectHeaderContent;
    addSwitchBarLogic();
  }
}

export { renderProjectHeader };
