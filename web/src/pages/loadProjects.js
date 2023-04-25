import TicketTrackerClient from '../api/ticketTrackerClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view playlist page of the website.
 */
class LoadProjects extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'addProjectsToPage', 'createTable'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.addProjectsToPage);
        this.dataStore.addChangeListener(this.addTicketsToPage);
        this.header = new Header(this.dataStore);
        console.log("load-ticket constructor");
    }

    createTable(projects){
        if (projects.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = '<table><tr><th>Project Title</th><th>Status</th><th>Actions</th></tr>';
        for (const res of projects) {
            html += `
            <tr>
                <td>
                    <a href=viewProject.html?projectId=${res.projectId}>${res.title}</a>
                </td>
                <td>
                    ${res.status}
                </td>
                <td><a href="viewProject.html?projectId=${res.projectId}" class="view-button">View Project</a>
            </tr>`;
        }
        html += '</table>';

        return html;
    }

    /**
     * Once the client is loaded, get the playlist metadata and song list.
     */
    async clientLoaded() {
        //const projectId = urlParams.get('projectId');
        //document.getElementById('project-title').innerText = "Loading Project ...";
        const projects = await this.client.getAllProjects();
        this.dataStore.set('projects', projects);
        //document.getElementById('tickets').innerText = "(loading tickets...)";
        //const tickets = await this.client.getProjectTickets(projectId);
        //this.dataStore.set('tickets', tickets);
        console.log("projects", projects);
    }

    /**
     * Add the header to the page and load the TicketTrackerClient.
     */
    mount() {
        //document.getElementById('add-ticket').addEventListener('click', this.addTicket);
        this.header.addHeaderToPage();

        this.client = new TicketTrackerClient();
        this.clientLoaded();
    }

    /**
     * When the playlist is updated in the datastore, update the playlist metadata on the page.
     */
    addProjectsToPage() {
        const projects = this.dataStore.get('projects');
        if (projects == null) {
            return;
        }

        //document.getElementById('project-title').innerText = project.title;
        //document.getElementById('project-description').innerText = project.description;

        let ticketHtml = '';
        let projectId;
        for (projectId of projects) {
            ticketHtml += '<div class="projects">' + projectId + '</div>';
        }

        document.getElementById('projects').innerHTML = this.createTable(projects);
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const loadProjects = new LoadProjects();
    loadProjects.mount();
};

window.addEventListener('DOMContentLoaded', main);
