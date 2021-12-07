import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {

	private final Iterator<T> iterator;
	private final Predicate<T> predicate;
	private boolean hasNext;
	private T next;

	public FilterIterator(final Iterator<T> source, Predicate<T> filter) {
		this.iterator = source;
		this.predicate = filter;
	}
	
	@Override
	public boolean hasNext() {
		while(!hasNext && iterator.hasNext()) {
			next = iterator.next();
			hasNext = predicate.test(next);
		}
		return hasNext;
	}
	@Override
	public T next() {
		if(!hasNext()) throw new NoSuchElementException();
		hasNext  = false;
		return next;
	}
  }