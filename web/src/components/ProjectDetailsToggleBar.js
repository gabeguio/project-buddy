function projectDetailsToggleBarTemplate() {
  return `
        <div class="project__menu">
            <button class="project__btn" id="about-btn">About</button>
            <button class="project__btn" id="members-btn">Members</button>
        </div>
    `;
}

function addProjectToggleBarLogic() {
  const aboutButton = document.getElementById("about-btn");
  const membersButton = document.getElementById("members-btn");
  const aboutContent = document.getElementById("about-content");
  const membersContent = document.getElementById("members-content");

  // Initially, show the "about" content.
  aboutButton.classList.add("project__btn-selected");
  membersContent.style.display = "none";

  aboutButton.addEventListener("click", () => {
    // Show the "about" content and hide the "Members" content.
    aboutButton.classList.add("project__btn-selected");
    membersButton.classList.remove("project__btn-selected");
    aboutContent.style.display = "block";
    membersContent.style.display = "none";
  });

  membersButton.addEventListener("click", () => {
    // Show the "Members" content and hide the "about" content.
    membersButton.classList.add("project__btn-selected");
    aboutButton.classList.remove("project__btn-selected");
    membersContent.style.display = "block";
    aboutContent.style.display = "none";
  });
}

export { projectDetailsToggleBarTemplate, addProjectToggleBarLogic };
