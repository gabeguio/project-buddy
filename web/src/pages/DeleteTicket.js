import TicketTrackerClient from '../api/ticketTrackerClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";


class LoadProjects extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToViewProject'], this);
        this.dataStore = new DataStore();
        this.datastore.addChangeListener(this.redirectToViewProject);
        this.header = new Header(this.dataStore);
    }

    mount() {
        document.getElementById('delete').addEventListener('click', this.delete);
        this.header.addHeaderToPage();
    t   his.client = new TicketTrackerClient();
    }

    async submit(event) {
        event.preventDefault();

        const errorMessageDisplay = document.getElementById('error-message');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const createButton = document.getElementById('delete');
        const origButtonText = createButton.innerText;
        createButton.innerText = 'deleting...';

        const projectId = document.getElementById('project-id').value;
        const ticketId = document.getElementById('ticketId').value;

        this.datastore.deleteTicket(projectId, ticketId);

    }

redirectToViewProject() {
            const project = this.dataStore.get('project');
            if (project != null) {
                window.location.href = `/project.html?id=${project.id}`;
            }
        }

const main = async () => {
        const deleteTicket = new deleteTicket();
        deleteTicket.mount();
    };

    window.addEventListener('DOMContentLoaded', main);