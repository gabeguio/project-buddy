import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

class LoadProjects{

    function CreateTable() {

        // CREATE DYNAMIC TABLE.
//        var table = document.createElement('table');

        // SET THE TABLE ID.
        // WE WOULD NEED THE ID TO TRAVERSE AND EXTRACT DATA FROM THE TABLE.
        table.setAttribute('id', 'ticketTable');
        table.setAttribute('border', '2px');


        var arrHead = new Array();
        arrHead = ['ProjectName', 'Status', 'Description'];

        var arrValue = new Array();

        arrValue.push(['Design Home Page', 'In Progress', '<a href="#" class="button">View Ticket</a> <a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Delete Ticket</a>']);
        arrValue.push(['Implement API endpoint', 'Complete', '<a href="#" class="button">View Ticket</a> <a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Delete Ticket</a>']);
        arrValue.push(['Another task here', 'Not started', '<a href="#" class="button">View Ticket</a> <a href="#" class="button">Edit Ticket</a> <a href="#" class="button">Delete Ticket</a>']);

        var tr = table.insertRow(-1);

        for (var h = 0; h < arrHead.length; h++) {
            var th = document.createElement('th');              // TABLE HEADER.
            th.innerHTML = arrHead[h];
            tr.appendChild(th);
        }

        for (var c = 0; c <= arrValue.length - 1; c++) {
            tr = table.insertRow(-1);

            for (var j = 0; j < arrHead.length; j++) {
                var td = document.createElement('td');          // TABLE DEFINITION.
                td = tr.insertCell(-1);
                td.innerHTML = arrValue[c][j];                  // ADD VALUES TO EACH CELL.
            }
        }
    }
    function GetHTMLForResults(results) {
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


}