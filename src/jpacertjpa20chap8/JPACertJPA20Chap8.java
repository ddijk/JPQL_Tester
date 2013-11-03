/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacertjpa20chap8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpacertjpa20chap8.entities.Address;
import jpacertjpa20chap8.entities.Department;
import jpacertjpa20chap8.entities.DesignProject;
import jpacertjpa20chap8.entities.Employee;
import jpacertjpa20chap8.entities.Phone;
import jpacertjpa20chap8.entities.Project;
import jpacertjpa20chap8.entities.QualityProject;

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

    Department dept = new Department("Development");
    Address address = new Address("zilverschoonlaan", "vleuten", "utrecht", "3452AA");



    Employee e1 = new Employee("dick", address, 555);
    e1.setDept(dept);
    Phone phone = new Phone("cell", e1, "061234");
    List<Phone> phones = Arrays.asList(phone);
    e1.setPhones(phones);


    DesignProject proj = new DesignProject("Pearl");
    QualityProject proj2 = new QualityProject("Sonar");

    List<Project> projList = new ArrayList<Project>();
    projList.add(proj);
    projList.add(proj2);

    proj.getEmployees().add(e1);
    proj2.getEmployees().add(e1);
    e1.setProjects(projList);

    em.persist(dept);
    em.persist(proj);
    em.persist(e1);
    em.persist(phone);

    em.getTransaction().begin();

    em.getTransaction().commit();
    em.close();
    emf.close();
  }
}
