package battlecode.client.communicate;

import java.io.Serializable;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Observation
  implements Serializable
{
  private static final long serialVersionUID = 1266905875770411107L;
  private ObserverMap observedData = null;
  private String mapStart = "<--";
  private String mapEnd = "-->";
  private String elementSeperator = "==";
  
  public ObserverMap getObservedData()
  {
    return this.observedData;
  }
  
  public void setObservedData(ObserverMap observedData)
  {
    this.observedData = observedData;
  }
  
  public Observation()
  {
    this.observedData = new ObserverMap();
  }
  
  public String toString()
  {
    return getString(this.observedData.getMap(), this.mapStart, this.mapEnd);
  }
  
  public String getString(Map<String, Object> map, String newMapMark, String endMapMark)
  {
    String str = newMapMark;
    for (String key : map.keySet()) {
      try
      {
        String value = (String)map.get(key);
        str = str + this.elementSeperator + key + "=" + value;
      }
      catch (Exception e)
      {
        str = str + getString((Map)map.get(key), newMapMark, endMapMark);
      }
    }
    return str + endMapMark;
  }
}
