function projectDetailsToggleBarTemplate() {
  return `
        <div class="project__details_toggle-bar">
            <button class="project__details_toggle-btn" id="overview-btn">Overview</button>
            <button class="project__details_toggle-btn" id="members-btn">Members</button>
        </div>
    `;
}

function addToggleBarLogic() {
  const overviewButton = document.getElementById("overview-btn");
  const membersButton = document.getElementById("members-btn");
  const overviewContent = document.getElementById("overview-content");
  const membersContent = document.getElementById("members-content");

  // Initially, show the "Overview" content.
  overviewButton.classList.add("project__details_toggle-btn_selected");
  membersContent.style.display = "none";

  overviewButton.addEventListener("click", () => {
    // Show the "Overview" content and hide the "Members" content.
    overviewButton.classList.add("project__details_toggle-btn_selected");
    membersButton.classList.remove("project__details_toggle-btn_selected");
    overviewContent.style.display = "block";
    membersContent.style.display = "none";
  });

  membersButton.addEventListener("click", () => {
    // Show the "Members" content and hide the "Overview" content.
    membersButton.classList.add("project__details_toggle-btn_selected");
    overviewButton.classList.remove("project__details_toggle-btn_selected");
    membersContent.style.display = "block";
    overviewContent.style.display = "none";
  });
}

// function renderProjectHeader(project) {
//   const projectHeaderElement = document.getElementById("project__header");

//   if (projectHeaderElement) {
//     projectHeaderElement.innerHTML = "";

//     const projectHeaderContent = projectHeaderTemplate(project);
//     projectHeaderElement.innerHTML = projectHeaderContent;
//     addSwitchBarLogic();
//   }
// }

export { projectDetailsToggleBarTemplate, addToggleBarLogic };
