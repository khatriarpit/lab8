package edu.cs.csc101.limitedstream.iterators;

import java.util.function.Function;

/**
 * Impl of base iterator class.
 */
public class MapLimitedIterator<R, T> implements LimitedIterator<R> {
  private final LimitedIterator<? super T> iterator;
  private final Function<? super T, ? extends R> mapper;

  public MapLimitedIterator(
          Function<? super T, ? extends R> mapper, LimitedIterator<? super T> iterator) {
    this.iterator = iterator;
    this.mapper = mapper;
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public R next() {
    var next = (T) iterator.next();
    return mapper.apply(next);
  }
}
