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
        this.bindClassMethods(['clientLoaded', 'mount', 'addProjectsToPage', 'addTicketsToPage', 'addTicket', 'createTable'], this);
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
                <td>${res.status}</td>
                <td><a href="viewTickets.html?projectId=${res.projectId}" class="view-button">View Tickets</a> <a href="#" class="editProjects-button">Edit Projects</a> <a href="#" class="editStatus-button">Edit Status</a><a href="#" class="delete-button">Delete Project</a></td>
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

    /**
     * When the songs are updated in the datastore, update the list of songs on the page.
     */
    addTicketsToPage() {
        const tickets = this.dataStore.get('tickets')

        if (tickets == null) {
            return;
        }

        let ticketHtml = '';
        let ticket;
        for (ticket of tickets) {
            ticketHtml += `
                <li class="ticket">
                    <span class="title">${ticket.title}</span>
                    <span class="status">${ticket.description}</span>
                    <span class="description">${ticket.description}</span>
                    <span class="actionButtons">${ticket.description}</span>
                </li>
            `;
        }
        document.getElementById('tickets').innerHTML = ticketHtml;
    }

    /**
     * Method to run when the add song playlist submit button is pressed. Call the TicketTrackerService to add a ticket to the
     * project.
     */
    async addTicket() {
        const errorMessageDisplay = document.getElementById('error-message');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const projects = this.dataStore.get('projects');
        if (projects == null) {
            return;
        }

        document.getElementById('add-ticket').innerText = 'Adding...';
        const description = document.getElementById('ticket-description').value;
        const status = document.getElementById('ticket-status').value;
        const projectId = projects.id;
        //const ticketId = ticket.id;

        const ticketList = await this.client.createTicketToProject(projectId, ticketId, description, status, (error) => {
            errorMessageDisplay.innerText = `Error: ${error.message}`;
            errorMessageDisplay.classList.remove('hidden');
        });

        this.dataStore.set('tickets', ticketList);

        document.getElementById('add-ticket').innerText = 'Add Ticket';
        document.getElementById("add-ticket-form").reset();
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
