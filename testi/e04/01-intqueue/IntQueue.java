
public class IntQueue {
	private final int[] elements;
	private int head, tail;

	public IntQueue(int size) {
		elements = new int[size];
		head = -1;
		tail = 0;

		assert repOK();
	}

	public void Enqueue(int n) {
		if(isFull()) throw new FullQueueException("Impossibile inserire in una coda piena");
		if (isEmpty()) head = 0;
		elements[tail] = n;
		tail = (tail + 1) % elements.length;

		assert repOK();
	}

	public int Dequeue() {
		if(isEmpty()) throw new EmptyQueueException("Impossibile rimuovere da una coda vuota");
		int r = elements[head];
    	head = (head + 1) % elements.length;
    	if (head == tail) {
     		head = -1;
      		tail = 0;
    	}
		assert repOK();
		return r;
	}

	public boolean isFull() {
		return head == tail;
	}

	public boolean isEmpty() {
		return head == -1;
	}

	public int size() {
		if(isEmpty()) return 0;
		if(isFull()) return elements.length;
		return (tail - head + elements.length) % elements.length;

	}

	/**
	 * Invariante di rappresentazione
	 * Elements not null
	 * size <= elements.length
	 * head >= -1
	 * tail >= 0
	 * tail <= elements.length
	 * head != -1 || tail == 0
	 *   
	 * */
	public boolean repOK(){
		return elements != null 
		&& size() <= elements.length
		&& head >= -1
		&& tail >= 0
		&& tail <= elements.length
		&& (head != -1 || tail == 0);
 	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IntQueue : [");
		if (!isEmpty()) {
			int i;
			for (i = 0; i < size() - 1; i++)
				sb.append(elements[(head + i) % elements.length]).append(", ");
			sb.append(elements[(head + i) % elements.length]);
			}
			sb.append(']');
		return sb.toString();
	}
}
