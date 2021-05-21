package edu.cs.csc101.limitedstream.streams;

import java.util.Iterator;

public class FromIterator implements Iterator<Integer> {
  private int value;

  public FromIterator(int value) {
    this.value = value;
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public Integer next() {
    return value++;
  }
}
