package edu.cs.csc101.limitedstream.streams;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Limited stream interface.
 */
public interface LimitedStream<T> {
  /**
   * Produces a limited stream from an Iterable.
   *
   * @param iterator the basis of elements for the stream
   * @param <T>      the type of elements in the stream
   * @return a new limited stream
   */
  static <T> LimitedStream<T> from(Iterator<T> iterator) {
    return new BaseLimitedStream(iterator);
  }

  /**
   * Produces a stream containing ony those elements that satisfy the provided predicate. This is an
   * intermediate operation.
   *
   * @param predicate to be applied to each element to determine inclusion
   * @return another stream containing elements that satisfy the predicate
   */
  LimitedStream<T> filter(Predicate<? super T> predicate);

  /**
   * Produces a stream with at most the specified number of elements. This is an intermediate
   * operation.
   *
   * @param maxSize the limit on the number of elements produced by the stream
   * @return another stream containing at most the specified number of elements
   */
  LimitedStream<T> limit(long maxSize);

  /**
   * Produces a stream with elements mapped by the provided function. This is an intermediate
   * operation.
   *
   * @param mapper function to map elements from original stream to new stream
   * @param <R>    type of elements in resulting stream
   * @return another stream containing mapped elements
   */
  <R> LimitedStream<R> map(Function<? super T, ? extends R> mapper);

  /**
   * Returns a count of the number of elements in the stream. This is a terminal operation.
   *
   * @return the number of elements in the stream
   */
  long count();

  /**
   * Gathers the elements of the underlying stream into a list. This is a terminal operation.
   *
   * @return a list containing the elements of the underlying stream
   */
  List<T> asList();
}
