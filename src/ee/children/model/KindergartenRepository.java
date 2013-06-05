package ee.children.model;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class KindergartenRepository {
  private Map<Integer, Kindergarten> kindergartens = new LinkedHashMap<Integer, Kindergarten>();

  public KindergartenRepository() {
    kindergartens.put(1, new Kindergarten(1, "Tallinna Lindakivi Lasteaed"));
    kindergartens.put(2, new Kindergarten(2, "Tallinna Arbu Lasteaed"));
    kindergartens.put(3, new Kindergarten(3, "Tallinna Lasteaed Kirsike"));
  }

  public Collection<Kindergarten> all() {
    return kindergartens.values();
  }

  public Kindergarten get(int id) {
    return kindergartens.get(id);
  }
}
