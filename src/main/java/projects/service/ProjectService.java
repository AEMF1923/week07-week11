package projects.service;

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
}
