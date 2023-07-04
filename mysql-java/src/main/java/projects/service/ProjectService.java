package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import projects.dao.ProjectDao; 
import projects.entity.Project; 
import projects.exception.DbException;

/*
 * THIS IS WHERE you place the business rules. For example, how the data behaves what is a value that is valid versus not 
 */
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

	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID= " + project.getProjectId() + " does not exist.");
		}
		
	}

	public void deleteProject(Integer projectId) {
		if(!projectDao.deleteProject(projectId)) {
			throw new DbException("Project with ID=" + projectId + " does not exist.");
		}
		
	}
}
