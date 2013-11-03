package jpacertjpa20chap8.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee
{
  private int id;
  private String name;
  private Address address;
  private List<Phone> phones = new ArrayList<Phone>();
  private Department dept;
  private List<Project> projects = new ArrayList<Project>();

  ;

  public Employee()
  {
  }

  public Employee(String name, Address address, long salary)
  {

    this.name = name;
    this.address = address;


    this.dept = dept;

    this.salary = salary;
  }

  @Id
  @GeneratedValue
  public int getId()
  {
    return id;
  }

  @ManyToMany(cascade = CascadeType.PERSIST)
  public List<Project> getProjects()
  {
    return projects;
  }

  public void setProjects(List<Project> projects)
  {
    this.projects = projects;
  }

  @ManyToOne
  public Department getDept()
  {
    return dept;
  }

  public void setDept(Department dept)
  {
    this.dept = dept;
  }

  @OneToMany(mappedBy = "owner")
  public List<Phone> getPhones()
  {
    return phones;
  }

  public void setPhones(List<Phone> phones)
  {
    this.phones = phones;
  }

  @Embedded
  @AttributeOverride(name = "id", column =
    @Column(name = "aid"))
  public Address getAddress()
  {
    return address;
  }

  public void setAddress(Address address)
  {
    this.address = address;
  }

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
  private long salary;

  /**
   * Get the value of salary
   *
   * @return the value of salary
   */
  public long getSalary()
  {
    return salary;
  }

  /**
   * Set the value of salary
   *
   * @param salary new value of salary
   */
  public void setSalary(long salary)
  {
    this.salary = salary;
  }

  public void setId(int id)
  {
    this.id = id;
  }
}
