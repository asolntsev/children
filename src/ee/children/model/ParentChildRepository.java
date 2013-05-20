package ee.children.model;

import java.util.*;

public class ParentChildRepository {
  private final Map<String, Set<String>> parentChildren = new HashMap<String, Set<String>>();

  public Set<String> children(String parentCode) {
    if (!parentChildren.containsKey(parentCode)) {
      return Collections.emptySet();
    }
    return parentChildren.get(parentCode);
  }

  public void registerChild(String parentCode, String childCode) {
    if (!parentChildren.containsKey(parentCode)) {
      parentChildren.put(parentCode, new LinkedHashSet<String>(3));
    }
    parentChildren.get(parentCode).add(childCode);
  }
}
