package ee.children.model;

public class Kindergarten {
  final int id;
  private final String name;

  public Kindergarten(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
