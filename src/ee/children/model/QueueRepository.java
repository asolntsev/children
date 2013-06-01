package ee.children.model;

import java.util.*;

public class QueueRepository {
  public Map<Integer, GardenQueue> gardens = new HashMap<Integer, GardenQueue>();

  public void add(String childCode, ChildrensGarden garden) {
    GardenQueue gardenQueue = gardens.get(garden.id);
    if (gardenQueue == null) {
      gardenQueue = new GardenQueue(garden);
      gardens.put(garden.id, gardenQueue);
    }

    gardenQueue.add(childCode);
  }

  public List<ChildPosition> getChildPositions(String childCode) {
    List<ChildPosition> result = new ArrayList<ChildPosition>(3);
    for (GardenQueue gardenQueue : gardens.values()) {
      if (gardenQueue.contains(childCode)) {
        result.add(new ChildPosition(gardenQueue.garden, gardenQueue.placeOf(childCode), gardenQueue.size()));
      }
    }
    return result;
  }

  public GardenQueue getQueue(ChildrensGarden garden) {
    return gardens.get(garden.id);
  }

  static class GardenQueue {
    public final ChildrensGarden garden;
    private final List<String> children = new ArrayList<String>();

    GardenQueue(ChildrensGarden garden) {
      this.garden = garden;
    }

    public int size() {
      return children.size();
    }

    public void add(String personCode) {
      if (children.contains(personCode)) {
        throw new IllegalArgumentException("Child is already in queue: " + personCode);
      }
      children.add(personCode);
    }

    public int placeOf(String personCode) {
      if (!contains(personCode)) {
        return 0;
      }
      return 1 + children.indexOf(personCode);
    }

    public boolean contains(String personCode) {
      return children.contains(personCode);
    }
  }

  public static class ChildPosition {
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
}
