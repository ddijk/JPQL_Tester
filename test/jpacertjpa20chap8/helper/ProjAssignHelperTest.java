/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacertjpa20chap8.helper;

import org.junit.Test;

import jpacertjpa20chap8.entities.DevelopmentProject;
import jpacertjpa20chap8.entities.Employee;
import junit.framework.Assert;

/**
 *
 * @author DickD
 */
public class ProjAssignHelperTest
{
  ProjAssignHelper projAssignHelper = new ProjAssignHelper();

  public ProjAssignHelperTest()
  {
  }

  @Test
  public void testAssignOneEmployeeToOneProject()
  {
    Employee dick = new Employee();
    dick.setId(1);
    DevelopmentProject pearl = new DevelopmentProject("Pearl");
    projAssignHelper.assignEmployeeToProject(dick, pearl);

    Assert.assertEquals("Dick should have one project", 1, dick.getProjects().size());
    Assert.assertEquals("Pearl should have one employee", 1, pearl.getEmployees().size());
    Assert.assertEquals("Dick should be assigned to Pearl", pearl, dick.getProjects().get(0));
    Assert.assertEquals("Pearl should have dick working on it", dick, pearl.getEmployees().get(0));
  }

  @Test
  public void testAssignOneEmployeeToMultipleProjects()
  {
    Employee dick = new Employee();
    dick.setId(1);
    DevelopmentProject pearl = new DevelopmentProject("Pearl");
    DevelopmentProject cordoba = new DevelopmentProject("Cordoba");
    projAssignHelper.assignEmployeeToProject(dick, pearl);
    projAssignHelper.assignEmployeeToProject(dick, cordoba);

    Assert.assertEquals("Dick should have two projects", 2, dick.getProjects().size());
    Assert.assertEquals("Pearl should have one employee", 1, pearl.getEmployees().size());
    Assert.assertEquals("Cordoba should have one employee", 1, cordoba.getEmployees().size());
    Assert.assertTrue("Dick should be assigned to Pearl", dick.getProjects().contains(pearl));
    Assert.assertTrue("Dick should be assigned to Cordoba", dick.getProjects().contains(cordoba));
    Assert.assertTrue("Pearl should have dick working on it", pearl.getEmployees().contains(dick));
    Assert.assertTrue("Cordoba should have dick working on it", cordoba.getEmployees().contains(dick));
  }

  @Test
  public void testAssignMultipleEmployeeToOneProject()
  {
    Employee dick = new Employee();
    dick.setId(1);
    Employee erik = new Employee();
    erik.setId(2);
    DevelopmentProject pearl = new DevelopmentProject("Pearl");
    projAssignHelper.assignEmployeeToProject(dick, pearl);
    projAssignHelper.assignEmployeeToProject(erik, pearl);

    Assert.assertEquals("Dick should have one project", 1, dick.getProjects().size());
    Assert.assertEquals("Pearl should have two employee", 2, pearl.getEmployees().size());
    Assert.assertTrue("Dick should be assigned to Pearl", dick.getProjects().contains(pearl));
    Assert.assertTrue("Erik should be assigned to Pearl", erik.getProjects().contains(pearl));
    Assert.assertTrue("Pearl should have dick working on it", pearl.getEmployees().contains(dick));
    Assert.assertTrue("Pearl should have erik working on it", pearl.getEmployees().contains(erik));
  }
}
