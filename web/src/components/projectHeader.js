function projectHeaderTemplate(project) {
  return `
        <h2 class="project__title">${project.title}</h2>
        <div class="project__switch-bar">
            <button class="project__btn-switch" id="btn-overview">Overview</button>
            <button class="project__btn-switch" id="btn-members">Members</button>
        </div>
    `;
}

function addSwitchBarLogic() {
  const overviewButton = document.getElementById("btn-overview");
  const membersButton = document.getElementById("btn-members");
  const overviewContent = document.getElementById("overview");
  const membersContent = document.getElementById("members");

  // Initially, show the "Overview" content.
  overviewButton.classList.add("project__btn-switch_selected");
  membersContent.style.display = "none";

  overviewButton.addEventListener("click", () => {
    // Show the "Overview" content and hide the "Members" content.
    overviewButton.classList.add("project__btn-switch_selected");
    membersButton.classList.remove("project__btn-switch_selected");
    overviewContent.style.display = "block";
    membersContent.style.display = "none";
  });

  membersButton.addEventListener("click", () => {
    // Show the "Members" content and hide the "Overview" content.
    membersButton.classList.add("project__btn-switch_selected");
    overviewButton.classList.remove("project__btn-switch_selected");
    membersContent.style.display = "block";
    overviewContent.style.display = "none";
  });
}

function renderProjectHeader(project) {
  console.log("first");
  const projectHeaderElement = document.getElementById("project__header");

  if (projectHeaderElement) {
    projectHeaderElement.innerHTML = "";

    const projectHeaderContent = projectHeaderTemplate(project);
    console.log("second");
    projectHeaderElement.innerHTML = projectHeaderContent;
    addSwitchBarLogic();
  }
}

export { renderProjectHeader };
