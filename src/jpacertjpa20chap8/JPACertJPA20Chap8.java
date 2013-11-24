/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacertjpa20chap8;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpacertjpa20chap8.entities.Address;
import jpacertjpa20chap8.entities.Department;
import jpacertjpa20chap8.entities.DevelopmentProject;
import jpacertjpa20chap8.entities.Employee;
import jpacertjpa20chap8.entities.Phone;
import jpacertjpa20chap8.entities.QualityProject;
import jpacertjpa20chap8.helper.ProjAssignHelper;

/**
 *
 * @author DickD
 */
public class JPACertJPA20Chap8
{
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    System.out.println("hai");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPACertJPA20Chap8PU");
    EntityManager em = emf.createEntityManager();

    Department lukkienDev = new Department("Lukkien Development");
    Department ortecDev = new Department("Ortec Development");
    Department ortecIP = new Department("Ortec IP");
    Address address = new Address("zilverschoonlaan", "vleuten", "utrecht", "3452AA");

    Employee dick = new Employee("dick", address, 555);
    dick.setDept(lukkienDev);
    Phone phone = new Phone("cell", dick, "061234");
    List<Phone> phones = Arrays.asList(phone);
    dick.setPhones(phones);
    Employee martin = new Employee("Martin van Krieken", address, 555);
    Employee erik = new Employee("Erik Mom", address, 555);
    Employee bas = new Employee("Bas Leerink", address, 555);

    DevelopmentProject pearl = new DevelopmentProject("Pearl");
    DevelopmentProject opal = new DevelopmentProject("Opal");
    DevelopmentProject cordoba = new DevelopmentProject("Cordoba");
    QualityProject sonar = new QualityProject("Sonar");

    ProjAssignHelper projAssignHelper = new ProjAssignHelper();
    projAssignHelper.assignEmployeeToProject(dick, pearl, cordoba);
    projAssignHelper.assignEmployeeToProject(erik, pearl);
    projAssignHelper.assignEmployeeToProject(martin, cordoba);

    // departments
    em.persist(lukkienDev);

    // projects
    em.persist(pearl);
    em.persist(cordoba);
    em.persist(opal);
    em.persist(sonar);

    // employees
    em.persist(dick);
    em.persist(erik);
    em.persist(martin);

    em.persist(phone);

    em.getTransaction().begin();

    em.getTransaction().commit();
    em.close();
    emf.close();
  }

}
