import ProjectClient from "../api/ProjectClient";
import Header from "../components/Header";
import BindingClass from "../util/BindingClass";
import DataStore from "../util/DataStore";
import { renderProjects } from "../components/projectDetailsCard.js";

class Index extends BindingClass {
  constructor() {
    super();

    this.bindClassMethods(
      ["mount", "displayAllProjects"],
      this
    );

    // Create a new datastore with an initial "empty" state.
    this.dataStore = new DataStore();
    this.header = new Header(this.dataStore);
    console.log("Index constructor");
  }

  mount() {
    this.header.createSiteNavBar();
    this.client = new ProjectClient();
    this.displayAllProjects();
  }

  async displayAllProjects() {
    const projects = await this.client.getProjects()
    console.log(projects);
    renderProjects(projects, ".projects__projects-container");
  }
}

const main = async () => {
  const index = new Index();
  index.mount();
};

window.addEventListener("DOMContentLoaded", main);
