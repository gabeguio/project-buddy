import ProjectClient from "../api/ProjectClient";
import Header from "../components/Header";
import BindingClass from "../util/BindingClass";
import DataStore from "../util/DataStore";

class Lp extends BindingClass {
  constructor() {
    super();

    this.bindClassMethods(["mount"], this);

    // Create a new datastore with an initial "empty" state.
    this.header = new Header(this.dataStore);
    console.log("lp constructor");
  }

  mount() {
    // Wire up the form's 'submit' event and the button's 'click' event to the search method.
    // document.getElementById('search-playlists-form').addEventListener('submit', this.search);
    // document.getElementById('search-btn').addEventListener('click', this.search);

    this.header.createSiteNavBar();

    this.client = new ProjectClient();
  }
}

const main = async () => {
  const lp = new Lp();
  lp.mount();
};

window.addEventListener("DOMContentLoaded", main);
