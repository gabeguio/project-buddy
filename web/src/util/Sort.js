const sortTasksByStatus = (tasks) => {
  const basicStatuses = ["To Do", "In Progress", "Under Review", "Completed"];

  // Initialize the map with all basic statuses
  const initialMap = new Map(basicStatuses.map((status) => [status, []]));

  const resultMap = tasks.reduce((map, task) => {
    const { status } = task;
    if (map.has(status)) {
      map.get(status).push(task);
    } else {
      // If status is not in the map (which should not happen), handle it here
      // This can occur if the task status is different from the basic statuses
      // You can handle such cases based on your specific requirements
    }
    return map;
  }, initialMap);

  // Create a new map with keys sorted in the desired order
  const sortedMap = new Map(
    basicStatuses.map((status) => [status, resultMap.get(status)])
  );

  return sortedMap;
}

export { sortTasksByStatus };
