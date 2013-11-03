package jpacertjpa20chap8.entities;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class DesignProject extends Project
{
  public DesignProject()
  {
  }

  public DesignProject(String name)
  {
    super(name);
  }
}
