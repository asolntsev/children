package ee.children.model;

import java.util.ArrayList;
import java.util.List;

public class ChildState {
  private final String childCode;
  private final List<PositionInQueue> queues = new ArrayList<PositionInQueue>();

  public ChildState(String childCode) {
    this.childCode = childCode;
  }

  public void add(Kindergarten kindergartenId, int position) {
    queues.add(new PositionInQueue(kindergartenId, position));
  }

  public String getChildCode() {
    return childCode;
  }

  public List<PositionInQueue> getQueues() {
    return queues;
  }

  public static class PositionInQueue {
    private final Kindergarten kindergarten;
    private final int position;

    public PositionInQueue(Kindergarten kindergarten, int position) {
      this.kindergarten = kindergarten;
      this.position = position;
    }

    public Kindergarten getKindergarten() {
      return kindergarten;
    }

    public int getPosition() {
      return position;
    }

    @Override
    public String toString() {
      return "At " + kindergarten.getName() + " position " + position;
    }
  }
}
