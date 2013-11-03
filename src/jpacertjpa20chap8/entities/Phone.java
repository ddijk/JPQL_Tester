package jpacertjpa20chap8.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phone
{
  private String type;
  private Employee owner;

  public Phone()
  {
  }

  public Phone(String type, Employee owner, String number)
  {
    this.type = type;
    this.owner = owner;
    this.number = number;
  }

  @ManyToOne
  public Employee getOwner()
  {
    return owner;
  }

  public void setOwner(Employee owner)
  {
    this.owner = owner;
  }
  /**
   * Get the value of type
   *
   * @return the value of type
   */
  private int id;

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

  public String getType()
  {
    return type;
  }

  /**
   * Set the value of type
   *
   * @param type new value of type
   */
  public void setType(String type)
  {
    this.type = type;
  }
  private String number;

  /**
   * Get the value of number
   *
   * @return the value of number
   */
  public String getNumber()
  {
    return number;
  }

  /**
   * Set the value of number
   *
   * @param number new value of number
   */
  public void setNumber(String number)
  {
    this.number = number;
  }
}
