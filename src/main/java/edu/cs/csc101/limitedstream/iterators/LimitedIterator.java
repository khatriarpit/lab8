package edu.cs.csc101.limitedstream.iterators;

/**
 * Limited iterator interface.
 */
public interface LimitedIterator<T> {
  /**
   * Determine if there are elements remaining.
   *
   * @return true if elements remain, false otherwise
   */
  boolean hasNext();

  /**
   * The retrieve the next element and advance the interator.
   *
   * @return the next element
   * @throws java.util.NoSuchElementException if there is no element
   */
  T next();
}
