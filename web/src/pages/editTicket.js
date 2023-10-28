// import TicketTrackerClient from "../api/ticketTrackerClient";
// import Header from '../components/header';
// import BindingClass from '../util/bindingClass';
// import DataStore from "../util/DataStore";

// class EditTicket extends BindingClass {
//     constructor() {
//         super();
//         this.bindClassMethods(['mount', 'getTicketForPage', 'updateTicket', 'createTicketForm', 'addTicketToPage',], this)
//         this.dataStore = new DataStore();
//         this.header = new Header(this.dataStore);
//         this.dataStore.addChangeListener(this.addTicketToPage);
    
//     }

//     mount() {
//         this.header.addHeaderToPage();
//         this.client = new TicketTrackerClient();
//         this.getTicketForPage();

//     }

//     async getTicketForPage() {
//         const urlParams = new URLSearchParams(window.location.search);
//         const projectId = urlParams.get('projectId');
//         const ticketId = urlParams.get('ticketId');
//         const ticket = await this.client.getTicket(projectId, ticketId);
//         this.dataStore.set('ticketModel', ticket);
//         console.log("ticket is stored");
//     }
    
//     async updateTicket(event) {
//         event.preventDefault();
//         const urlParams = new URLSearchParams(window.location.search);
//         const projectId = urlParams.get('projectId');
//         const ticketId = urlParams.get('ticketId');
//         const ticketTitle = document.getElementById('ticketTitle').value;
//         const ticketStatus = document.getElementById('ticketStatus').value;
//         const ticketDescription = document.getElementById('ticketDescription').value;
//         const ticket = await this.client.updateTicketDetails(projectId, ticketId, ticketTitle, ticketStatus, ticketDescription);
//         this.dataStore.set('ticket', ticket);
//         alert(ticketTitle + " has been updated.")
//         window.location.href = `/viewProject.html?projectId=${projectId}`;

//     }

//     createTicketForm(ticket) {
//         // if (ticket.length === 0) {
//         //     return '<h4>No results found</h4>';
//         // }
//         let html = `
//         <form>
//         <label>Ticket Title</label>
//         <input type="text" id="ticketTitle" value="${ticket.title}">
//         <label>Ticket Status</label>
//         <select name="Ticket Status" id="ticketStatus">
//             <option value="Back Log">Back Log</option>
//             <option value="In Progress">In Progress</option>
//             <option value="Completed">Completed</option>
//         </select>
//         <label for="ticket Description">Ticket Description</label>
//         <textarea rows="4" cols="50" id="ticketDescription">${ticket.description}</textarea>
//         </form>
//         <button id="saveTicket">Save Changes</button>`;
//         console.log("after html");
//         return html;
//     }

//     addTicketToPage() {
//         const ticket = this.dataStore.get('ticketModel');
//         // if (ticket == null) {
//         //     return;
//         // }
//         document.getElementById('editTicketForm').innerHTML = this.createTicketForm(ticket);
//         document.getElementById('saveTicket').addEventListener('click', this.updateTicket);

//     }

// }

// const main = async () => {
//     const editTicket = new EditTicket();
//     editTicket.mount();
// };

// window.addEventListener('DOMContentLoaded', main);