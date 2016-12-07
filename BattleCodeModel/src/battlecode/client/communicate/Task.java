package battlecode.client.communicate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task
  implements Serializable
{
  private static final long serialVersionUID = 2883450075308570079L;
  private List<String> arguments = null;
  private String taskName = null;
  
  public Task()
  {
    this.arguments = new ArrayList();
  }
  
  public List<String> getArguments()
  {
    return this.arguments;
  }
  
  public void setArguments(List<String> arguments)
  {
    this.arguments = arguments;
  }
  
  public String getTaskName()
  {
    return this.taskName;
  }
  
  public void setTaskName(String taskName)
  {
    this.taskName = taskName;
  }
  
  public void addTask(String taskname, String... args)
  {
    this.taskName = taskname;
    this.arguments = Arrays.asList(args);
  }
}
