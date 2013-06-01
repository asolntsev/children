package ee.children.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChildrensGardenRepository {
  private Map<Integer, ChildrensGarden> gardens = new LinkedHashMap<Integer, ChildrensGarden>();

  public ChildrensGardenRepository() {
    gardens.put(1, new ChildrensGarden(1, "Tallinna Lindakivi Lasteaed"));
    gardens.put(2, new ChildrensGarden(2, "Tallinna Arbu Lasteaed"));
    gardens.put(3, new ChildrensGarden(3, "Tallinna Lasteaed Kirsike"));
  }

  public Collection<ChildrensGarden> getChildrenGardens() {
    return gardens.values();
  }

  public ChildrensGarden get(int id) {
    return gardens.get(id);
  }
}
