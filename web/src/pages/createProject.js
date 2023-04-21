import TicketTrackerClient from '../api/ticketTrackerClient';
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';

/**
 * Logic needed for the create playlist page of the website.
 */
class CreateProject extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToViewProject'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.redirectToViewProject);
        this.header = new Header(this.dataStore);
    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        document.getElementById('create').addEventListener('click', this.submit);

        this.header.addHeaderToPage();

        this.client = new TicketTrackerClient();
    }

    /**
     * Method to run when the create playlist submit button is pressed. Call the MusicPlaylistService to create the
     * playlist.
     */
    async submit(evt) {
        evt.preventDefault();

        const errorMessageDisplay = document.getElementById('error-message');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const createButton = document.getElementById('create');
        const origButtonText = createButton.innerText;
        createButton.innerText = 'Loading...';

        const projectTitle = document.getElementById('project-title').value;
        const projectStatus = document.getElementById('project-status').value;
        const projectDescription = document.getElementById('project-description').value;

        const project = await this.client.createProject(projectTitle, projectDescription, projectStatus, (error) => {
            createButton.innerText = origButtonText;
            errorMessageDisplay.innerText = `Error: ${error.message}`;
            errorMessageDisplay.classList.remove('hidden');
        });
        this.dataStore.set('project', project);
        console.log("hello");
    }

    /**
     * When the playlist is updated in the datastore, redirect to the view playlist page.
     */
    redirectToViewProject() {
        const project = this.dataStore.get('project');
        if (project != null) {
            window.location.href = `/viewProject.html?projectId=${project.projectId}`;
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const createProject = new CreateProject();
    createProject.mount();
};

window.addEventListener('DOMContentLoaded', main);
