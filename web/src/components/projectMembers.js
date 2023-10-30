// Function to generate the member table from an array of member objects.
function projectMembers(members) {
    return `
      <button class="btn">Add Member</button>
      <div class="members__table-container">
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Role</th>
              <th>Company</th>
              <th>Email</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            ${members
              .map(
                (member) => `
                  <tr>
                    <td>${member.name}</td>
                    <td>${member.role}</td>
                    <td>${member.company}</td>
                    <td>${member.email}</td>
                    <td><button class="btn">...</button></td>
                  </tr>
                `
              )
              .join('')}
          </tbody>
        </table
      </div>
    `;
  }
  
  export { projectMembers };