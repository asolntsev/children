package ee.children.model;

import ee.children.model.QueueRepository.GardenQueue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueRepositoryTest {
  ChildrensGarden rose = new ChildrensGarden(1, "Rose");
  ChildrensGarden tulip = new ChildrensGarden(2, "Tulip");

  @Test
  public void canAddChildToQueue() {
    QueueRepository repository = new QueueRepository();
    repository.add("1111111111", rose);
    repository.add("1111111111", tulip);

    final GardenQueue queueRose = repository.getQueue(rose);
    assertEquals(1, queueRose.size());
    assertEquals(1, queueRose.placeOf("1111111111"));

    final GardenQueue queueTulip = repository.getQueue(tulip);
    assertEquals(1, queueTulip.size());
    assertEquals(1, queueTulip.placeOf("1111111111"));
  }

  @Test
  public void childrenAreAuthenticatedByPersonCode() {
    QueueRepository repository = new QueueRepository();
    repository.add("1111111111", rose);
    repository.add("1111111111", tulip);

    repository.add("2222222222", rose);
    repository.add("3333333333", rose);
    repository.add("3333333333", tulip);

    assertEquals(3, repository.getQueue(rose).size());
    assertEquals(2, repository.getQueue(tulip).size());

    assertEquals(1, repository.getQueue(rose).placeOf("1111111111"));
    assertEquals(2, repository.getQueue(rose).placeOf("2222222222"));
    assertEquals(3, repository.getQueue(rose).placeOf("3333333333"));

    assertEquals(1, repository.getQueue(tulip).placeOf("1111111111"));
    assertEquals(2, repository.getQueue(tulip).placeOf("3333333333"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void cannotAddChildTwiceToSameGarden() {
    QueueRepository repository = new QueueRepository();
    repository.add("1111111111", rose);
    repository.add("1111111111", rose);
  }
}
