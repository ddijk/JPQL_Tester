package jpacertjpa20chap8.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address
{
  private String street;

  public Address()
  {
  }

  public Address(String street, String city, String state, String zip)
  {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;

  }

  /**
   * Get the value of street
   *
   * @return the value of street
   */
  public String getStreet()
  {
    return street;
  }

  /**
   * Set the value of street
   *
   * @param street new value of street
   */
  public void setStreet(String street)
  {
    this.street = street;
  }
  private String city;

  /**
   * Get the value of city
   *
   * @return the value of city
   */
  public String getCity()
  {
    return city;
  }

  /**
   * Set the value of city
   *
   * @param city new value of city
   */
  public void setCity(String city)
  {
    this.city = city;
  }
  private String state;

  /**
   * Get the value of state
   *
   * @return the value of state
   */
  public String getState()
  {
    return state;
  }

  /**
   * Set the value of state
   *
   * @param state new value of state
   */
  public void setState(String state)
  {
    this.state = state;
  }
  private String zip;

  /**
   * Get the value of zip
   *
   * @return the value of zip
   */
  public String getZip()
  {
    return zip;
  }

  /**
   * Set the value of zip
   *
   * @param zip new value of zip
   */
  public void setZip(String zip)
  {
    this.zip = zip;
  }
  private long id;

  /**
   * Get the value of id
   *
   * @return the value of id
   */
  public long getId()
  {
    return id;
  }

  /**
   * Set the value of id
   *
   * @param id new value of id
   */
  public void setId(long id)
  {
    this.id = id;
  }

  @Override
  public String toString()
  {
    return zip + ", " + city;
  }

}
