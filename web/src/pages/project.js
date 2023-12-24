import ProjectClient from "../api/ProjectClient";
import Header from "../components/Header";
import BindingClass from "../util/BindingClass";
import DataStore from "../util/DataStore";
import { renderProject } from "../components/ProjectComponent";
import { sampleProjects } from "../data/sampleProjects";
import { sampleMembers } from "../data/sampleMembers";
import { sampleTasks } from "../data/sampleTasks";


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
    this.header.header();
    this.client = new ProjectClient();
    this.displayProject();
  }

  async displayProject() {
    // const project = await this.client.getProjectById()
    // const urlParams = new URLSearchParams(window.location.search);
    // const projectId = urlParams.get("projectId");
    const project = await this.client.getProject("aB3Rt7");
    const members = await this.client.getMembers("aB3Rt7");
    // const tasks = sampleTasks;

    // NOTE: Content's of the project are rendered before the header to allow header toggle switch assignment for the projects contents
    renderProject(project, members, sampleTasks);
  }
}

const main = async () => {
  const project = new Project();
  project.mount();
};

window.addEventListener("DOMContentLoaded", main);
