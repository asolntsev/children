package ee.children.model;

public class ChildrensGarden {
  long id;
  private String name;

  public ChildrensGarden(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }
}