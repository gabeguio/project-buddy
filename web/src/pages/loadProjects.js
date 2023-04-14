import MusicPlaylistClient from '../api/musicPlaylistClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";


class LoadProjects extends BindingClass{
    constructor() {
            super();
            this.bindClassMethods(['clientLoaded', 'mount', 'getHTMLForLoadedProjects',
            'viewTicket', 'editTicket', 'markTicketAsComplete', 'deleteTicket'], this);
            this.dataStore = new DataStore();
            this.dataStore.addChangeListener(this.addPlaylistToPage);
            this.dataStore.addChangeListener(this.addSongsToPage);
            this.header = new Header(this.dataStore);
            console.log("loadproject constructor");
    }


    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        const projectId = urlParams.get('projectId');
        document.getElementById('project-title').innerText = "Loading Project ...";
        const playlist = await this.client.getPlaylist(projectId);
        this.dataStore.set('project', project);
        document.getElementById('tickets').innerText = "(loading tickets...)";
        const songs = await this.client.getProjectTasks(projectId);
        this.dataStore.set('tasks', tasks);
    }


    mount() {
        document.getElementById('add-tasks').addEventListener('click', this.addTasks);

        this.header.addHeaderToPage();

        this.client = new MusicPlaylistClient();
        this.clientLoaded();
    }

    /**
     * When the playlist is updated in the datastore, update the playlist metadata on the page.
     */
    addProjectToPage() {
        const project = this.dataStore.get('project');
        if (project == null) {
            return;
        }

        document.getElementById('project-id').innerText = playlist.name;
        document.getElementById('playlist-owner').innerText = playlist.customerName;



    getHTMLForSearchResults(searchResults) {
        if (searchResults.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = '<table><tr><th>Name</th><th>Song Count</th><th>Tags</th></tr>';
        for (const res of searchResults) {
            html += `
            <tr>
                <td>
                    <a href="playlist.html?id=${res.id}">${res.name}</a>
                </td>
                <td>${res.songCount}</td>
                <td>${res.tags?.join(', ')}</td>
            </tr>`;
        }
        html += '</table>';

        return html;
    }

}