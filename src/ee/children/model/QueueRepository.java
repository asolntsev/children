package ee.children.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueueRepository {
  private KindergartenRepository kindergartens = new KindergartenRepository();
  private final Map<Integer, List<String>> queues = new HashMap<Integer, List<String>>();

  public void enqueue(Integer kindergartenId, String childCode) {
    if (!queues.containsKey(kindergartenId)) {
      queues.put(kindergartenId, new ArrayList<String>());
    }

    List<String> kindergartenQueue = queues.get(kindergartenId);
    kindergartenQueue.add(childCode);
  }

  public ChildState getChildState(String childCode) {
    ChildState result = new ChildState(childCode);

    for (Integer kindergartenId : queues.keySet()) {
      final List<String> kindergartenQueue = queues.get(kindergartenId);
      int position = kindergartenQueue.indexOf(childCode);
      if (position > -1) {
        result.add(kindergartens.get(kindergartenId), 1 + position);
      }
    }
    return result;
  }
}
