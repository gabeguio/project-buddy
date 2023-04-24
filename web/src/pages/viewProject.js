import TicketTrackerClient from "../api/ticketTrackerClient";
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from "../util/DataStore";

class ViewProject extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['getProjectForPage', 'getTicketsForPage', 'mount', 'createProjectTable',  'createTicketsTable', 'addProjectToPage', 'addTicketsToPage', 'deleteTicket'], this)
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
        this.dataStore.addChangeListener(this.addProjectToPage);
        this.dataStore.addChangeListener(this.addTicketsToPage);
    
    }

    async getProjectForPage() {
        const urlParams = new URLSearchParams(window.location.search);
        const projectId = urlParams.get('projectId');
        const project = await this.client.getProject(projectId);
        this.dataStore.set('project', project);
        console.log("project is stored");
    }

    async getTicketsForPage() {
        const urlParams = new URLSearchParams(window.location.search);
        const projectId = urlParams.get('projectId');
        const tickets = await this.client.getAllTicketsByProject(projectId);
        this.dataStore.set('ticketList', tickets);
        console.log("tickets are stored");
    }

    mount() {
        this.header.addHeaderToPage();
        this.client = new TicketTrackerClient();
        this.getProjectForPage();
        this.getTicketsForPage();
    }

    createProjectTable(project) {
        if (project.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = `
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
                    ${project.title}
                    </td>
                    <td>
                    ${project.status}
                    </td>
                    <td>
                    ${project.description}
                    </td>
                    <td>
                        <a href="editProject.html?projectId=${project.projectId}" class="edit-button">Edit Project</a>
                        <a href="#" class="delete-button">Delete Project</a>
                    </td>
                </tr>
            </table>`;

        return html;
    }

    createTicketsTable(tickets) {
        const project = this.dataStore.get('project');
        if (project == null) {
            return;
        }

        let html = `
        <form>
            <table>
                <tr>
                    <th>
                    Ticket Title
                    </th>
                    <th>
                    Ticket Status
                    </th>
                    <th>
                    Ticket Description
                    </th>
                    <th
                    Actions
                    </th>
                </tr>`;
        
        for (const ticket of tickets) {
            html += `
                <tr>
                    <td>
                    ${ticket.title}
                    </td>
                    <td>
                    ${ticket.status}
                    </td>
                    <td>
                    ${ticket.description}
                    </td>
                    <td>
                        <a href="editTicket.html?projectId=${project.projectId}&ticketId=${ticket.ticketId}" class="edit-button">Edit Ticket</a>
                    </td>
                    <td>
                        <button id="deleteTicket" class="delete-button">Delete Ticket</button>
                    </td>
                </tr>`;
            }

        html += `
            </table>
        </form>`;

        return html;
    }

    addProjectToPage() {
        const project = this.dataStore.get('project');
        if (project == null) {
            return;
        }

        document.getElementById('viewProjectTable').innerHTML = this.createProjectTable(project);
    }

    addTicketsToPage() {
        const tickets = this.dataStore.get('ticketList');
        if (tickets == null) {
            return;
        }

        document.getElementById('viewTicketsTable').innerHTML = this.createTicketsTable(tickets);
        document.getElementById('deleteTicket').addEventListener('click', this.deleteTicket);
    }


 async deleteTicket(event) {
        if(confirm("Are you sure you want to delete this ticket?")){
            event.preventDefault();
            const urlParams = new URLSearchParams(window.location.search);
            console.log("getting event button", event.target.dataset.ticketid);
            const projectId = urlParams.get('projectId');
            const ticketId = event.target.dataset.ticketid;
            await this.client.deleteTicket(projectId, ticketId);
            alert(ticketId + " has been deleted.");
            location.reload();
        }
        
    }
}

const main = async () => {
    const viewProject = new ViewProject();
    viewProject.mount();
};

window.addEventListener('DOMContentLoaded', main);