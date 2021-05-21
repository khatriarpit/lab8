package edu.cs.csc101.limitedstream.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

class LimitedStreamTest {
  @Test
  void countEmptyTest() {
    assertEquals(0, LimitedStream.from(List.of().iterator()).count());
  }

  @Test
  void countTest() {
    assertEquals(3, LimitedStream.from(List.of("a", "b", "c").iterator()).count());
  }

  @Test
  void asListEmptyTest() {
    assertEquals(List.of(), LimitedStream.from(List.of().iterator()).asList());
  }

  @Test
  void asListTest() {
    assertEquals(
            List.of("a", "b", "c"), LimitedStream.from(List.of("a", "b", "c").iterator()).asList());
  }

  @Test
  void limitFewerThanStreamTest() {
    assertEquals(4, LimitedStream.from(new FromIterator(0)).limit(4).count());
  }

  @Test
  void limitGreaterThanStreamTest() {
    assertEquals(2, LimitedStream.from(List.of(1, 2).iterator()).limit(4).count());
  }

  @Test
  void filterAsListTest() {
    assertEquals(
            List.of(2, 4, 6),
            LimitedStream.from(List.of(1, 2, 3, 4, 5, 6).iterator())
                    .filter(n -> (n & 1) == 0)
                    .asList());
  }

  @Test
  void mapAsListTest() {
    assertEquals(
            List.of(2, 5, 4),
            LimitedStream.from(List.of("hi", "hello", "ciao").iterator()).map(String::length).asList());
  }

  @Test
  void limitFilterAsListTest() {
    assertEquals(
            List.of(10, 20, 30, 40, 50),
            LimitedStream.from(new FromIterator(1)).filter(n -> n % 10 == 0).limit(5).asList());
  }

  @Test
  void filterLimitAsListTest() {
    assertEquals(
            List.of(),
            LimitedStream.from(new FromIterator(1)).limit(5).filter(n -> n % 10 == 0).asList());
  }
}
