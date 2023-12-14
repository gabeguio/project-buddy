import ProjectClient from "../api/ProjectClient";
import Header from "../components/Header";
import BindingClass from "../util/BindingClass";
import DataStore from "../util/DataStore";
import { sampleProjects } from "../data/sampleProjects";
import { renderProjects } from "../components/Projects";

class Index extends BindingClass {
  constructor() {
    super();

    this.bindClassMethods(["mount", "displayProjects"], this);

    // Create a new datastore with an initial "empty" state.
    this.dataStore = new DataStore();
    this.header = new Header(this.dataStore);
    console.log("Projects constructor");
  }

  mount() {
    this.header.header();
    this.client = new ProjectClient();
    this.displayProjects();
  }

  async displayProjects() {
    // const projects = await this.client.getProjects()
    renderProjects(sampleProjects);
  }
}

const main = async () => {
  const index = new Index();
  index.mount();
};

window.addEventListener("DOMContentLoaded", main);
