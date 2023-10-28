// import TicketTrackerClient from "../api/ticketTrackerClient";
// import Header from '../components/header';
// import BindingClass from '../util/bindingClass';
// import DataStore from "../util/DataStore";

// class ViewTickets extends BindingClass {
//     constructor() {
//         super();
//         this.bindClassMethods(['clientLoaded', 'mount', 'addTicketsToPage', 'createTicketsTable'], this);
//         this.dataStore = new DataStore();
//         this.dataStore.addChangeListener(this.addTicketsToPage);
//         this.header = new Header(this.dataStore);
//         console.log("load-ticket constructor");
//     }

//     async clientLoaded() {
//         const urlParams = new URLSearchParams(window.location.search);
//         const projectId = urlParams.get('projectId');
//         const tickets = await this.client.getAllTicketsByProject(projectId);
//         this.dataStore.set('ticketList', tickets);
//         console.log("tickets are stored");
//     }

//     mount() {
//         this.client = new TicketTrackerClient();
//         this.header.addHeaderToPage();
//         this.clientLoaded();
//     }

//     createTicketsTable(tickets) {

//         let html = `
//         <form>
//             <table>
//                 <tr>
//                     <th>
//                     Ticket Title
//                     </th>
//                     <th>
//                     Ticket Status
//                     </th>
//                     <th>
//                     Ticket Description
//                     </th>
//                     <th
//                     Actions
//                     </th>
//                 </tr>`;
//         console.log("outside loop");
        
//         for (const ticket of tickets) {
//         console.log("inside loop");
//         html += `
//                 <tr>
//                     <td>
//                         <input readonly type="text" value="${ticket.title}" id="ticketTitle"></input>
//                     </td>
//                     <td>
//                         <input type="text" value="${ticket.status}" id="ticketStatus"></input>
//                     </td>
//                     <td>
//                         <input type="text" class="ticketDescription" value="${ticket.description}" id="ticketDescription"></input>
//                     </td>
//                     <td>
//                         <a href="" class="delete-button">Delete Ticket</a>
//                     </td>
//                     <td>
//                         <a href="" class="editProjects-button">Edit Ticket</a>
//                     </td>
//                      <td>
//                         <a href="" class="view-button">View Ticket</a>
//                     </td>
//                 </tr>`;

//         }

//         html += `
//         </table>
//         <button id="saveProject">Save Changes</button>
//         </form>`;

//         return html;
//     }

//     addTicketsToPage() {
//         const tickets = this.dataStore.get('ticketList');
//         if (tickets == null) {
//             return;
//         }

//         document.getElementById('viewTicketsTable').innerHTML = this.createTicketsTable(tickets);
//     }
// }

// const main = async () => {
//     const viewTickets = new ViewTickets();
//     viewTickets.mount();
// };

// window.addEventListener('DOMContentLoaded', main);