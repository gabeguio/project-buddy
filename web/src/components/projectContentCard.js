// Function to generate the project content card.
function projectContentCardTemplate(id, content) {
    const card = document.createElement('div');
    card.classList.add('project__content');
    card.id = id;
    card.innerHTML = content;
    return card;
  }
  
  export { projectContentCardTemplate };
  