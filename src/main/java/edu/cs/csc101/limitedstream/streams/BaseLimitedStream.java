package edu.cs.csc101.limitedstream.streams;

import edu.cs.csc101.limitedstream.iterators.FilterLimitedIterator;
import edu.cs.csc101.limitedstream.iterators.LimitLimitedIterator;
import edu.cs.csc101.limitedstream.iterators.LimitedIterator;
import edu.cs.csc101.limitedstream.iterators.LimitedIteratorAdapter;
import edu.cs.csc101.limitedstream.iterators.MapLimitedIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This is base class for limited stream.
 */
public class BaseLimitedStream<T> implements LimitedStream<T> {
  private final LimitedIterator<? extends T> iterator;

  public BaseLimitedStream(Iterator<? extends T> iterator) {
    this.iterator = new LimitedIteratorAdapter<>(iterator);
  }

  private BaseLimitedStream(LimitedIterator<? extends T> iterator) {
    this.iterator = iterator;
  }

  @Override
  public LimitedStream<T> filter(Predicate<? super T> predicate) {
    return new BaseLimitedStream<>(new FilterLimitedIterator<>(predicate, iterator));
  }

  @Override
  public LimitedStream<T> limit(long maxSize) {
    return new BaseLimitedStream<>(new LimitLimitedIterator<>(maxSize, iterator));
  }

  @Override
  public <R> LimitedStream<R> map(Function<? super T, ? extends R> mapper) {
    return new BaseLimitedStream<>(new MapLimitedIterator<>(mapper, iterator));
  }

  @Override
  public long count() {
    var i = 0;

    while (iterator.hasNext()) {
      i++;
      iterator.next();
    }

    return i;
  }

  @Override
  public List<T> asList() {
    List<T> list = new ArrayList<>();

    while (iterator.hasNext()) {
      list.add(iterator.next());
    }

    return list;
  }
}
