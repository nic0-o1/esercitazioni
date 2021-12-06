import java.util.ArrayList;
import java.util.List;

public class UnboundedIntQueue {
	private final ArrayList<Integer> elem;

	public UnboundedIntQueue() {
		elem = new ArrayList<Integer>();

		assert repOK();
	}

	public void Enqueue(int value) {
		elem.add(value);

		assert repOK();
	}

	public int Dequeue() {
		if (isEmpty())
			throw new EmptyUnboundedIntQueueException("Coda vuota");

		assert repOK();

		return elem.remove(0);
	}

	public int size() {
		return elem.size();
	}

	public boolean repOK() {
		return elem != null;
	}

	public boolean isEmpty() {
		return elem.size() <= 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("UnboundedIntQueue [");

		for (int i : elem) {
			sb.append(i);
			sb.append(' ');
		}
		sb.append(']');
		return sb.toString();
	}

}
