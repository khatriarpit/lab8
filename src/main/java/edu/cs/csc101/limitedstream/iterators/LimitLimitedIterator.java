package edu.cs.csc101.limitedstream.iterators;

/**
 * Impl of base iterator class.
 */
public class LimitLimitedIterator<T> implements LimitedIterator<T> {
  private final LimitedIterator<? extends T> iterator;
  private final long maxSize;
  private int cursor;

  public LimitLimitedIterator(long maxSize, LimitedIterator<? extends T> iterator) {
    this.iterator = iterator;
    this.maxSize = maxSize;
  }

  @Override
  public boolean hasNext() {
    return cursor < maxSize && iterator.hasNext();
  }

  @Override
  public T next() {
    cursor++;
    return iterator.next();
  }
}
