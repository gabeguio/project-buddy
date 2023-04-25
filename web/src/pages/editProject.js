import TicketTrackerClient from "../api/ticketTrackerClient";
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from "../util/DataStore";

class EditProject extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'getProjectForPage', 'updateProject', 'createProjectForm', 'addProjectToPage',], this)
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
        this.dataStore.addChangeListener(this.addProjectToPage);
    
    }

    mount() {
        this.header.addHeaderToPage();
        this.client = new TicketTrackerClient();
        this.getProjectForPage();
    }

    async getProjectForPage() {
        const urlParams = new URLSearchParams(window.location.search);
        const projectId = urlParams.get('projectId');
        const project = await this.client.getProject(projectId);
        this.dataStore.set('project', project);
        console.log("project is stored");
    }
    
    async updateProject(event) {
        event.preventDefault();
        const urlParams = new URLSearchParams(window.location.search);
        const projectId = urlParams.get('projectId');
        const projectTitle = document.getElementById('projectTitle').value;
        const projectStatus = document.getElementById('projectStatus').value;
        const projectDescription = document.getElementById('projectDescription').value;
        const project = await this.client.updateProjectDetails(projectId, projectTitle, projectStatus, projectDescription);
        this.dataStore.set('project', project);
        alert(projectTitle + " has been updated.")
        window.location.href = `/viewProject.html?projectId=${projectId}`;

    }

    createProjectForm(project) {
        if (project.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = `
        <form>
        <label for="Project Title" >Project Title</label>
        <input type="text" id="projectTitle" value="${project.title}">
        <label required for="Project Status">Project Status</label>
        <select name="Project Status" id="projectStatus">
            <option value="Back Log">Back Log</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
        </select>
        <label for="Project Description">Project Description</label>
        <textarea rows="4" cols="50" id="projectDescription">${project.description}</textarea>
        </form>
        <button id="saveProject" href="viewProject.html?projectId=${project.projectId}">Save Changes</button>`;

        return html;
    }

    addProjectToPage() {
        const project = this.dataStore.get('project');
        if (project == null) {
            return;
        }

        document.getElementById('editProjectForm').innerHTML = this.createProjectForm(project);
        document.getElementById('saveProject').addEventListener('click', this.updateProject);
        

    }

}

const main = async () => {
    const editProject = new EditProject();
    editProject.mount();
};

window.addEventListener('DOMContentLoaded', main);