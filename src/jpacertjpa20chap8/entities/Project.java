package jpacertjpa20chap8.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
//@Inheritance
abstract public class Project
{
  private int id;
  private List<Employee> employees = new ArrayList<Employee>();

  public Project()
  {
  }

  public Project(String name)
  {
    this.employees = employees;
    this.name = name;
  }

  @ManyToMany(mappedBy = "projects")
  public List<Employee> getEmployees()
  {
    return employees;
  }

  public void setEmployees(List<Employee> employees)
  {
    this.employees = employees;
  }

  /**
   * Get the value of id
   *
   * @return the value of id
   */
  @Id
  @GeneratedValue
  public int getId()
  {
    return id;
  }

  /**
   * Set the value of id
   *
   * @param id new value of id
   */
  public void setId(int id)
  {
    this.id = id;
  }
  private String name;

  /**
   * Get the value of name
   *
   * @return the value of name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Set the value of name
   *
   * @param name new value of name
   */
  public void setName(String name)
  {
    this.name = name;
  }
}
