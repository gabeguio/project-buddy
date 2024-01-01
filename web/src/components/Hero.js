function heroTemplate() {
  return `
    <h1 class="hero__title">
    Streamline your Workflow with Ease
    </h1>
    <p class="hero__description">
        Effortless Project Management for Dynamic Task Tracking and Worry-Free Deadline Scheduling.
    </p>
    <a class="hero__btn btn" href="projects.html">Start Demo</a>
    `;
}

function renderHero() {
  const heroSectionElement = document.querySelector(".hero");
  heroSectionElement.innerHTML = heroTemplate();
}

export { renderHero };
