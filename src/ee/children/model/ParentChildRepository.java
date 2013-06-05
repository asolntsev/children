package ee.children.model;

import java.util.*;

public class ParentChildRepository {
  private final Map<String, List<String>> parentChildren = new HashMap<String, List<String>>();

  public void register(String parentCode, String childCode) {
    if (!parentChildren.containsKey(parentCode)) {
      parentChildren.put(parentCode, new ArrayList<String>());
    }
    parentChildren.get(parentCode).add(childCode);
  }

  public List<String> getChildren(String parentCode) {
    if (!parentChildren.containsKey(parentCode)) {
      return Collections.emptyList();
    }
    return parentChildren.get(parentCode);
  }
}
