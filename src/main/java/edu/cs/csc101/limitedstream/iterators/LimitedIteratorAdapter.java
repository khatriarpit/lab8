package edu.cs.csc101.limitedstream.iterators;

import java.util.Iterator;

/**
 * This is just an adapter for the standard iterator to focus on the basic iteration steps
 * (effectively eliminating remove as an option).
 *
 * @param <T> elements returned by the iterator
 */
public class LimitedIteratorAdapter<T> implements LimitedIterator<T> {
  private final Iterator<? extends T> iterator;

  public LimitedIteratorAdapter(Iterator<? extends T> iterator) {
    this.iterator = iterator;
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public T next() {
    return iterator.next();
  }
}
