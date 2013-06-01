package ee.children.model;

import java.util.*;

public class ParentChildRepository {
  private final Set<ParentChild> parentChildren = new HashSet<ParentChild>();

  public Set<String> children(String parentCode) {
    Set<String> children = new HashSet<String>(5);
    for (ParentChild parentChild : parentChildren) {
      if (parentChild.parentCode.equals(parentCode)) {
        children.add(parentChild.childCode);
      }
    }
    return children;
  }

  public void register(String parentCode, String childCode) {
    parentChildren.add(new ParentChild(parentCode, childCode));
  }
}
