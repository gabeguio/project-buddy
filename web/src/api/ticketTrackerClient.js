import axios from "axios";
import BindingClass from "../util/bindingClass";
import Authenticator from "./authenticator";

/**
 * Client to call the MusicPlaylistService.
 *
 * This could be a great place to explore Mixins. Currently the client is being loaded multiple times on each page,
 * which we could avoid using inheritance or Mixins.
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes#Mix-ins
 * https://javascript.info/mixins
  */
export default class TicketTrackerClient extends BindingClass {

    constructor(props = {}) {
        super();

        const methodsToBind = ['clientLoaded', 'getIdentity', 'login', 'logout', 'getProject', 'getTicket', 'getAllTicketsByProject', 'createProject', 'createTicket'];
        this.bindClassMethods(methodsToBind, this);

        this.authenticator = new Authenticator();;
        this.props = props;

        axios.defaults.baseURL = process.env.API_BASE_URL;
        this.axiosClient = axios;
        this.clientLoaded();
    }

    /**
     * Run any functions that are supposed to be called once the client has loaded successfully.
     */
    clientLoaded() {
        if (this.props.hasOwnProperty("onReady")) {
            this.props.onReady(this);
        }
    }

    /**
     * Get the identity of the current user
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The user information for the current user.
     */
    async getIdentity(errorCallback) {
        try {
            const isLoggedIn = await this.authenticator.isUserLoggedIn();

            if (!isLoggedIn) {
                return undefined;
            }

            return await this.authenticator.getCurrentUserInfo();
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async login() {
        this.authenticator.login();
    }

    async logout() {
        this.authenticator.logout();
    }

    async getTokenOrThrow(unauthenticatedErrorMessage) {
        const isLoggedIn = await this.authenticator.isUserLoggedIn();
        if (!isLoggedIn) {
            throw new Error(unauthenticatedErrorMessage);
        }

        return await this.authenticator.getUserToken();
    }

    /**
     * Gets the project for the given ID.
     * @param projectId Unique identifier for a project
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The project's metadata.
     */
    async getProject(projectId, errorCallback) {
        try {
            const response = await this.axiosClient.get(`projects/${projectId}`);
            return response.data.project;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
     * Gets a ticket for the given ID from a project for the given project.
     * @param projectId Unique identifier for a project
     * @param ticketId Unique identifier for a ticket
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The ticket's metadata.
     */
    async getTicket(projectId, ticketId, errorCallback) {
        try {
            const response = await this.axiosClient.get(`projects/${projectId}/tickets/${ticketId}`);
            return response.data.ticket;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
     * Get the tickets on a given project by the project's identifier.
     * @param projectId Unique identifier for a playlist
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The list of songs on a playlist.
     */
    async getAllTicketsByProject(projectId, errorCallback) {
        try {
            const response = await this.axiosClient.get(`/projects/${projectId}/tickets`);
            return response.data.ticketList;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
     * Create a new project owned by any user.
     * @param title The title of the project to create.
     * @param description the description to overview the project.
     * @param status status for information on whether the status is in back log, in progress, or completed.
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The project that has been created.
     */
    async createProject(title, description, status, errorCallback) {
        try {
            const token = await this.getTokenOrThrow("Only authenticated users can create projects.");
            const response = await this.axiosClient.post(`projects`, {
                title: title,
                description: description,
                status: status
            }, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            return response.data.project;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
     * Create a new project owned by any user.
     * @param projectId The project that will have a new ticket.
     * @param title The title of the ticket to create.
     * @param description the description to overview the ticket.
     * @param status status for information on whether the status is in back log, in progress, or completed.
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The project that has been created.
     */
    async createTicket(projectId, title, description, status, errorCallback) {
        try {
            const token = await this.getTokenOrThrow("Only authenticated users can create ticket.");
            const response = await this.axiosClient.post(`tickets`, {
                projectId: projectId,
                title: title,
                description: description,
                status: status,
            }, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            return response.data.ticket;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
     * Helper method to log the error and run any error functions.
     * @param error The error received from the server.
     * @param errorCallback (Optional) A function to execute if the call fails.
     */
    handleError(error, errorCallback) {
        console.error(error);

        const errorFromApi = error?.response?.data?.error_message;
        if (errorFromApi) {
            console.error(errorFromApi)
            error.message = errorFromApi;
        }

        if (errorCallback) {
            errorCallback(error);
        }
    }
}
