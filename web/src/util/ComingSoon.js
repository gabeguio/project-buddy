const comingSoon = () => {
  const comingSoonBtns = document.querySelectorAll(".coming-soon");

  comingSoonBtns.forEach((btn) =>
    btn.addEventListener("click", () => {
      alert("Glad you're here! This feature is coming soon...");
    })
  );
};

export default comingSoon;
