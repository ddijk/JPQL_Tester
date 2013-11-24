package jpacertjpa20chap8;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import jpacertjpa20chap8.entities.Project;
import jpacertjpa20chap8.entities.Project_;

public class CriteriaQueryTester
{

  public static void main(String[] args)
  {
    String unitName = "JPACertJPA20Chap8PU";//args[0];
    EntityManagerFactory emf
      = Persistence.createEntityManagerFactory(unitName);
    EntityManager em = emf.createEntityManager();
    // getAllProjects(em);
    getAllPearlProjectsGroupByName2(em);
    em.close();
    emf.close();
  }

  private static void getAllProjects(EntityManager em)
  {
    CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Project> q = cb.createQuery(Project.class);

    q.from(Project.class);

    for (Project p : em.createQuery(q).getResultList())
    {
      System.out.println("project id=" + p.getId() + ", naam=" + p.getName());
    }
  }

  private static void getAllPearlProjects(EntityManager em)
  {
    CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Project> q = cb.createQuery(Project.class);

    Root<Project> r = q.from(Project.class);
   // EntityType<Project> et = r.getModel();

    //   q.where(cb.equal(cb.literal("Pearl"), r.get(Project_.name)));
    q.where(cb.equal(r.get(Project_.name), "Pearl"));

    for (Project p : em.createQuery(q).getResultList())
    {
      System.out.println("project id=" + p.getId() + ", naam=" + p.getName());
    }
  }

  private static void getAllPearlProjectsGroupByName(EntityManager em)
  {
    CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<String> q = cb.createQuery(String.class);

    Root<Project> r = q.from(Project.class);
    q.select(r.get(Project_.name));
    q.groupBy(r.get(Project_.name));
 //   q.having(cb.gt(cb.count(r.get(Project_.name)), 2));
    // EntityType<Project> et = r.getModel();

    //   q.where(cb.equal(cb.literal("Pearl"), r.get(Project_.name)));
    // q.where(cb.equal(r.get(Project_.name), "Pearl"));
    for (String p : em.createQuery(q).getResultList())
    {
      System.out.println("project " + p);
    }
  }

  private static void getAllPearlProjectsGroupByName2(EntityManager em)
  {
    CriteriaBuilder cb = em.getCriteriaBuilder();

    CriteriaQuery<Project> q = cb.createQuery(Project.class);

    Root<Project> r = q.from(Project.class);
    // q.select(r.get(Project_.name));
    q.groupBy(r.get(Project_.name));
 //   q.having(cb.gt(cb.count(r.get(Project_.name)), 2));
    // EntityType<Project> et = r.getModel();

    //   q.where(cb.equal(cb.literal("Pearl"), r.get(Project_.name)));
    // q.where(cb.equal(r.get(Project_.name), "Pearl"));
    for (Project p : em.createQuery(q).getResultList())
    {
      System.out.println("project id=" + p.getId() + ", naam=" + p.getName());
    }
  }
}
