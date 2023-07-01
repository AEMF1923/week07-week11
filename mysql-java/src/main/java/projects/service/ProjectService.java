package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import projects.dao.ProjectDao; 
import projects.entity.Project; 


public class ProjectService {
	private ProjectDao projectDao = new ProjectDao(); 
	
	//not sure why we need these little gray things. what are they called?
	/**
	 * 
	 * @param project
	 * @return
	 */
	
	
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}

	/**
	 * 
	 * @return
	 */
	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */

	public Project fetchProjectById(Integer projectId) {
		
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
				"Project with project Id = " + projectId + " does not exist."));
	}
}
