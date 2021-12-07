import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IntSet implements Iterable<Integer> {

	private List<Integer> elem;
	private boolean sorted = false;

	public IntSet() {
		elem = new ArrayList<Integer>();
		sorted = true;

	}

	public void Insert(int x) {
		if (!this.Contains(x)) {
			elem.add(x);
		}
	}

	public int Remove(int x) {
		if (this.Size() == 0)
			throw new EmptyException("Set vuoto");
		sorted = false;
		return elem.remove(x);
	}

	public boolean Contains(int x) {
		return elem.contains(x);
	}

	public int Size() {
		return elem.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IntSet {\n");

		for (int val : elem) {
			sb.append(val);
			sb.append(" ");
		}
		return sb.append("}").toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IntSet))
			return false;

		IntSet other = (IntSet) obj;

		if (!sorted) {
			Collections.sort(elem);
			sorted = true;
		}

		if (!other.sorted) {
			Collections.sort(other.elem);
			other.sorted = true;
		}

		return elem.equals(other.elem);
	}

	@Override
	public int hashCode() {
		int hash = 0;

		for (Integer val : elem) {
			hash = 31 * hash + Integer.hashCode(val);
		}

		return hash;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int nextIndex = 0;

			@Override
			public Integer next() {
				if (!hasNext())
					throw new NoSuchElementException();

				return elem.get(nextIndex++);
			}

			@Override
			public boolean hasNext() {
				return nextIndex < Size();
			}
		};
	}

}