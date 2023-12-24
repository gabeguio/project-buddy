//package com.service.test.helper;
//
//import java.util.List;
//
//import com.service.dynamodb.models.Project;
//import com.service.models.ProjectModel;
//
//
//public class ProjectTestHelper {
//
//    public static Project generateProject() {
//        Project project = new Project();
//        project.setProjectId("projectId");
//        project.setOwner("owner");
//        project.setProjectId("dateCreate");
//        project.setTitle("title");
//        project.setDescription("description");
//        project.setDueDate("dueDate");
//        project.setTasksCompleted(1);
//        project.setTotalTasks(1);
//        project.setTopContributor("topContributor");
//        return project;
//    }
//
//    public static boolean AssertProjectModelEquals(List<Project> projectList, List<ProjectModel> projectModels) {
//        for (int i = 0; i < projectModels.size(); i ++) {
//            if (!projectList.get(i).getProjectId().equals(projectModels.get(i).getProjectId())) {
//                return false;
//            }
//            if (!projectList.get(i).getOwner().equals(projectModels.get(i).getOwner())) {
//                return false;
//            }
//            if (!projectList.get(i).getDateCreated().equals(projectModels.get(i).getDateCreated())) {
//                return false;
//            }
//            if (!projectList.get(i).getTitle().equals(projectModels.get(i).getTitle())) {
//                return false;
//            }
//            if (!projectList.get(i).getDescription().equals(projectModels.get(i).getDescription())) {
//                return false;
//            }
//            if (!projectList.get(i).getTasksCompleted().equals(projectModels.get(i).getTasksCompleted())) {
//                return false;
//            }
//            if (!projectList.get(i).getTotalTasks().equals(projectModels.get(i).getTotalTasks())) {
//                return false;
//            }
//            if (!projectList.get(i).getTopContributor().equals(projectModels.get(i).getTopContributor())) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}
