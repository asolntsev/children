package ee.children.model;

public class ChildPosition {
  private final ChildrensGarden garden;
  private final int place;
  private final int queueSize;

  public ChildPosition(ChildrensGarden garden, int place, int queueSize) {
    this.garden = garden;
    this.place = place;
    this.queueSize = queueSize;
  }

  public ChildrensGarden getGarden() {
    return garden;
  }

  public int getPlace() {
    return place;
  }

  public int getQueueSize() {
    return queueSize;
  }

  //    @Override
//    public String toString() {
//      return garden.name + " : " + place + " / " + queueSize;
//    }
}
