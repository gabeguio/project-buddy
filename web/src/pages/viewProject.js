import MusicPlaylistClient from "../api/musicPlaylistClient";
import Header from '../components/header';
import BindingClass from '../util/bindingClass';

class ViewProject extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount'], this)
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.redirectToViewPlaylist);
        this.header = new Header(this.dataStore);
    }
}

mount() {
    document.getElementById('create').addEventListener('click', this.submit);

    this.header.addHeaderToPage();

    this.client = new MusicPlaylistClient();
}

const main = async () => {
    const viewProject = new ViewProject();
};

window.addEventListener('DOMContentLoaded', main);