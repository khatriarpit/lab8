package edu.cs.csc101.limitedstream.iterators;

import java.util.function.Predicate;

/**
 * Base iterator class.
 */
public class FilterLimitedIterator<T> implements LimitedIterator<T> {
  private final Predicate<? super T> predicate;
  private final LimitedIterator<? extends T> iterator;
  private T nextElement;

  /**
   * Builds a filtering limited iterator based on the provided predicate.
   *
   * @param predicate filtering condition
   * @param iterator  underlying iterator
   */
  public FilterLimitedIterator(
          Predicate<? super T> predicate, LimitedIterator<? extends T> iterator) {
    this.predicate = predicate;
    this.iterator = iterator;
  }

  @Override
  public boolean hasNext() {
    findNext();
    return nextElement != null;
  }

  @Override
  public T next() {
    var next = nextElement;
    nextElement = null;
    return next;
  }

  /**
   * Sets instance variable 'nextElement' to the next element from the underlying iterator that
   * satisfies the predicate or null, if there is no such element.
   */
  private void findNext() {
    while (nextElement == null && iterator.hasNext()) {
      T presumedNext = iterator.next();
      if (predicate.test(presumedNext)) {
        nextElement = presumedNext;
      }
    }
  }
}
