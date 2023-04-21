import TicketTrackerClient from "../api/ticketTrackerClient";
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from "../util/DataStore";

class ViewProject extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'clientLoaded', 'addProjectToPage', 'createTable', 'updateProject'], this)
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
        this.dataStore.addChangeListener(this.addProjectToPage);
    
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
    }

    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        const projectId = urlParams.get('projectId');
        const project = await this.client.getProject(projectId);
        this.dataStore.set('project', project);
        console.log(projectId);
    }

    mount() {
        this.header.addHeaderToPage();
        this.client = new TicketTrackerClient();
        this.clientLoaded();
    }

    createTable(project) {
        if (project.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = `
        <form>
            <table>
                <tr>
                    <th>
                    Project Title
                    </th>
                    <th>
                    Project Status
                    </th>
                    <th>
                    Project Description
                    </th>
                    <th
                    Actions
                    </th>
                </tr>`;
        
        html += `
                <tr>
                    <td>
                        <input readonly type="text" value="${project.title}" id="projectTitle"></input>
                    </td>
                    <td>
                        <input type="text" value="${project.status}" id="projectStatus"></input>
                    </td>
                    <td>
                        <input type="text" value="${project.description}" id="projectDescription"></input>
                    </td>
                    <td>
                        <a href="#" class="view-button">View Tickets</a>
                        <a href="#" class="editProjects-button">Edit Projects</a>
                        <a href="#" class="editStatus-button">Edit Status</a>
                        <a href="#" class="delete-button">Delete Project</a>
                    </td>
                </tr>
            </table>
                <button id="saveProject">save</button>
        </form>`;

        return html;
    }

    addProjectToPage() {
        const project = this.dataStore.get('project');
        if (project == null) {
            return;
        }

        document.getElementById('viewProjectTable').innerHTML = this.createTable(project);
        document.getElementById('saveProject').addEventListener('click', this.updateProject);
    }
}

const main = async () => {
    const viewProject = new ViewProject();
    viewProject.mount();
};

window.addEventListener('DOMContentLoaded', main);