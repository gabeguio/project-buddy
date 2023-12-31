// Function to generate the member table from an array of member objects.
function projectDetailsMembers(members) {
  return `
      <div class="members__table-container">
        <table class="members__table">
          <thead>
            <tr class="members__table_header-row">
            <th>Name</th>
            <th>Role</th>
            <th>Company</th>
            <th>Email</th>
            <th>Date Joined</th
            <th></th>
            </tr>
          </thead>
          <tbody class="members__table_body">
            ${members
              .map(
                (member) => `
                  <tr>
                  <td>${member.firstName} ${member.lastName}</td>
                  <td>${member.role}</td>
                  <td>${member.company}</td>
                  <td>${member.email}</td>
                  <td>${member.dateJoined.substring(0,10)}</td>
                  <td>
                    <button
                      class="members__table_pen coming-soon">
                      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor">
                        <path d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-12.15 12.15a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32L19.513 8.2z" />
                      </svg>
                    </button>
                  </td>
                  </tr>
                `
              )
              .join("")}
          </tbody>
        </table
      </div>
    `;
}

export { projectDetailsMembers };
