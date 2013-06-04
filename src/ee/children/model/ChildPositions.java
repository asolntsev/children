package ee.children.model;

import java.util.List;

public class ChildPositions {
  private final String childCode;
  private final List<ChildPosition> childPositions;

  public ChildPositions(String childCode, List<ChildPosition> childPositions) {
    this.childCode = childCode;
    this.childPositions = childPositions;
  }

  public String getChildCode() {
    return childCode;
  }

  public List<ChildPosition> getChildPositions() {
    return childPositions;
  }
}
