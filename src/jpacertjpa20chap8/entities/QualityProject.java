package jpacertjpa20chap8.entities;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class QualityProject extends Project
{
  public QualityProject()
  {
  }

  public QualityProject(String name)
  {
    super(name);
  }
}
