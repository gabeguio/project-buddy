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
        console.log("viewproject constructor");
    }

    createTable(searchResults){

        if (searchResults.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = '<table><tr><th>Name</th><th>Ticket Count</th><th>Tickets</th></tr>';
        for (const res of searchResults) {
            html += `
            <th>Tickets</th>
            <th>Status</th>
            <th>Actions</th>
            <tr>
                <td>
                    <a href="projects.html?id=${res.id}">${res.projectTitle}</a>
                </td>
                <td>${res.ticketCount}</td>
                <td><a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Edit Ticket</a></td>
            </tr>`;
        }
        html += '</table>';

        return html;
    }

    /**
     * Once the client is loaded, get the playlist metadata and song list.
     */
    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        //const projectId = urlParams.get('projectId');
        //document.getElementById('project-title').innerText = "Loading Project ...";
        //const project = await this.client.getProject(projectId);
        //this.dataStore.set('project', project);
        //document.getElementById('tickets').innerText = "(loading tickets...)";
        //const tickets = await this.client.getProjectTickets(projectId);
        //this.dataStore.set('tickets', tickets);
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
        let ticketTag;
        for (ticketTag of projects.tickets) {
            tagHtml += '<div class="tag">' + tag + '</div>';
        }
        var searchResults = new Array();
        searchResults.push(['Design Home Page', 'In Progress', '<a href="#" class="button">View Ticket</a> <a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Delete Ticket</a>']);
        searchResults.push(['Implement API endpoint', 'Complete', '<a href="#" class="button">View Ticket</a> <a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Delete Ticket</a>']);
        searchResults.push(['Another task here', 'Not started', '<a href="#" class="button">View Ticket</a> <a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Delete Ticket</a>']);


        document.getElementById('projects').innerHTML = createTable(searchResults);
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

        const project = this.dataStore.get('project');
        if (project == null) {
            return;
        }

        document.getElementById('add-ticket').innerText = 'Adding...';
        const description = document.getElementById('ticket-description').value;
        const status = document.getElementById('ticket-status').value;
        const projectId = project.id;
        const ticketId = ticket.id;

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
