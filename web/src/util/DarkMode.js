const darkMode = () => {
    const themeToggleBtns = document.querySelectorAll('#theme-toggle');
  
    // State
    const theme = localStorage.getItem('theme');

    const favicon = document.querySelector('link[rel="icon"]')
  
    // On mount
    // theme && document.body.classList.add(theme);
    if (theme) {
      document.body.classList.add(theme)
      document.querySelector('.header__emblem-large').setAttribute('src', "images/pb-emblem-large-light.png")
      document.querySelector('.header__emblem-small').setAttribute('src', "images/pb-emblem-small-light.png")
      document.querySelector('.header__emblem-mini').setAttribute('src', "images/pb-emblem-mini-light.png")
      favicon.href = "images/pb-favicon-light.png";
    } else {
      document.querySelector('.header__emblem-large').setAttribute('src', "images/pb-emblem-large-dark.png")
      document.querySelector('.header__emblem-small').setAttribute('src', "images/pb-emblem-small-dark.png")
      document.querySelector('.header__emblem-mini').setAttribute('src', "images/pb-emblem-mini-dark.png")
      favicon.href = "images/pb-favicon-dark.png";
    }

  
    // Handlers
    const handleThemeToggle = () => {
      document.body.classList.toggle('light-mode');
      const favicon = document.querySelector('link[rel="icon"]')
      if (document.body.classList.contains('light-mode')) {
        localStorage.setItem('theme', 'light-mode');
        document.querySelector('.header__emblem-large').setAttribute('src', "images/pb-emblem-large-light.png")
        document.querySelector('.header__emblem-small').setAttribute('src', "images/pb-emblem-small-light.png")
        document.querySelector('.header__emblem-mini').setAttribute('src', "images/pb-emblem-mini-light.png")
        favicon.href = "images/pb-favicon-light.png";
      } else {
        localStorage.removeItem('theme');
        document.body.removeAttribute('class');
        document.querySelector('.header__emblem-large').setAttribute('src', "images/pb-emblem-large-dark.png")
        document.querySelector('.header__emblem-small').setAttribute('src', "images/pb-emblem-small-dark.png")
        document.querySelector('.header__emblem-mini').setAttribute('src', "images/pb-emblem-mini-dark.png")
        favicon.href = "images/pb-favicon-dark.png";
      }
    };
  
    // Events
    themeToggleBtns.forEach(btn =>
      btn.addEventListener('click', handleThemeToggle)
    );
  };
  
  export default darkMode;