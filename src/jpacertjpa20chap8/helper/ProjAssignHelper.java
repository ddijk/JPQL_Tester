package jpacertjpa20chap8.helper;

import jpacertjpa20chap8.entities.Employee;
import jpacertjpa20chap8.entities.Project;

public class ProjAssignHelper
{

  public void assignEmployeeToProject(Employee dick, Project... projects)
  {
    for (Project proj : projects)
    {
      dick.getProjects().add(proj);
      proj.getEmployees().add(dick);
    }
  }
}
