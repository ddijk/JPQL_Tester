package jpacertjpa20chap8.entities;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class DevelopmentProject extends Project
{
  public DevelopmentProject()
  {
  }

  public DevelopmentProject(String name)
  {
    super(name);
  }
}
