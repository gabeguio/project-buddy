import ProjectClient from "../api/ProjectClient";
import BindingClass from "../util/BindingClass";

/**
 * The header component for the website.
 */
export default class Header extends BindingClass {
  constructor() {
    super();

    const methodsToBind = [
      "createSiteNavBar",
      "createUserInfoForHeader",
      "createLoginButton",
      "createLoginButton",
      "createLogoutButton",
    ];
    this.bindClassMethods(methodsToBind, this);

    this.client = new ProjectClient();
  }

  async createSiteNavBar() {
    // Create home link for header's navigation menu
    const homeLink = document.createElement("a");
    homeLink.classList.add("header__link");
    homeLink.href = "index.html";
    homeLink.innerText = "Home";
    const listItemHome = document.createElement("li");
    listItemHome.appendChild(homeLink);

    // Create profile link for header's navigation menu
    const profileLink = document.createElement("a");
    profileLink.classList.add("header__link");
    profileLink.href = "#";
    profileLink.innerText = "Profile";
    const listItemProfile = document.createElement("li");
    listItemProfile.appendChild(profileLink);

    // Create list item line seperator
    const listItemLineSeperator = document.createElement("li");
    listItemLineSeperator.classList.add("header__line");

    // Toggle button for header's navigation menu
    const sunImageReference = document.createElement("path");
    sunImageReference.setAttribute(
      "d",
      "M12 2.25a.75.75 0 01.75.75v2.25a.75.75 0 01-1.5 0V3a.75.75 0 01.75-.75zM7.5 12a4.5 4.5 0 119 0 4.5 4.5 0 01-9 0zM18.894 6.166a.75.75 0 00-1.06-1.06l-1.591 1.59a.75.75 0 101.06 1.061l1.591-1.59zM21.75 12a.75.75 0 01-.75.75h-2.25a.75.75 0 010-1.5H21a.75.75 0 01.75.75zM17.834 18.894a.75.75 0 001.06-1.06l-1.59-1.591a.75.75 0 10-1.061 1.06l1.59 1.591zM12 18a.75.75 0 01.75.75V21a.75.75 0 01-1.5 0v-2.25A.75.75 0 0112 18zM7.758 17.303a.75.75 0 00-1.061-1.06l-1.591 1.59a.75.75 0 001.06 1.061l1.591-1.59zM6 12a.75.75 0 01-.75.75H3a.75.75 0 010-1.5h2.25A.75.75 0 016 12zM6.697 7.757a.75.75 0 001.06-1.06l-1.59-1.591a.75.75 0 00-1.061 1.06l1.59 1.591z"
    );

    const sunImage = document.createElement("svg");
    sunImage.setAttribute("xmlns", "http://www.w3.org/2000/svg");
    sunImage.setAttribute("viewBox", "0 0 24 24");
    sunImage.setAttribute("fill", "currentColor");

    const sunButton = document.createElement("button");
    sunButton.classList.add("header__sun");
    sunButton.href = "#";
    sunButton.innerText = "Profile";
    const listItemToggleMode = document.createElement("li");
    sunImage.appendChild(sunImageReference);
    sunButton.appendChild(sunImage);
    listItemToggleMode.appendChild(sunButton);

    // Create user-info link for header's navigation menu
    const currentUser = await this.client.getIdentity();
    const listItemUserInfo = this.createUserInfoForHeader(currentUser);

    const headerNav = document.createElement("nav");
    const headerNavMenu = document.createElement("ul");
    headerNavMenu.classList.add("header__menu");
    headerNavMenu.appendChild(listItemHome);
    headerNavMenu.appendChild(listItemProfile);
    headerNavMenu.appendChild(listItemLineSeperator);
    headerNavMenu.appendChild(listItemUserInfo);

    headerNav.appendChild(headerNavMenu);

    const header = document.getElementById("header");
    header.classList.add("container");
    header.appendChild(headerNav);
  }

  createUserInfoForHeader(currentUser) {
    const userInfo = document.createElement("li");

    const childContent = currentUser
      ? this.createLogoutButton(currentUser)
      : this.createLoginButton();

    userInfo.appendChild(childContent);

    return userInfo;
  }

  createLoginButton() {
    return this.createButton("Login", this.client.login);
  }

  createLogoutButton(currentUser) {
    return this.createButton(`Logout: ${currentUser.name}`, this.client.logout);
  }

  createButton(text, clickHandler) {
    const button = document.createElement("a");
    button.href = "#";
    button.innerText = text;

    button.addEventListener("click", async () => {
      await clickHandler();
    });

    return button;
  }
}
