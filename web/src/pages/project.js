import ProjectClient from "../api/ProjectClient";
import Header from "../components/Header";
import BindingClass from "../util/BindingClass";
import DataStore from "../util/DataStore";
import { renderProjectHeader } from "../components/projectHeader";
import { renderProjectContentContainer } from "../components/projectContainer";
import { sampleProjects } from "../data/sampleProjects";
import { sampleMembers } from "../data/sampleMembers";

class Project extends BindingClass {
  constructor() {
    super();

    this.bindClassMethods(["mount", "displayProject"], this);

    // Create a new datastore with an initial "empty" state.
    this.dataStore = new DataStore();
    this.header = new Header(this.dataStore);
    console.log("Project constructor");
  }

  mount() {
    this.header.createSiteNavBar();
    this.client = new ProjectClient();
    this.displayProject();
  }

  async displayProject() {
    // const project = await this.client.getProjectById()
    const urlParams = new URLSearchParams(window.location.search);
    const projectId = urlParams.get("projectId");
    console.log(projectId);
    const project = await this.client.getProject(projectId);
    console.log(JSON.stringify(project));

    // NOTE: Content's of the project are rendered before the header to allow header toggle switch assignment for the projects contents
    renderProjectContentContainer(project, sampleMembers);
    renderProjectHeader(project);
  }
}

const main = async () => {
  const project = new Project();
  project.mount();
};

window.addEventListener("DOMContentLoaded", main);
