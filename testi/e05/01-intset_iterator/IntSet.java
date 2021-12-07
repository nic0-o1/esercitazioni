
import java.util.ArrayList;
import java.util.List;

public class IntSet {
	private List<Integer> elem;

	public IntSet() {
		elem = new ArrayList<Integer>();
	}

	public int size() {
		return elem.size();
	}

	public boolean contains(int i) {
		return elem.contains(i);
	}

	public void insert(int n) {
		elem.add(n);
	}

	public void remove(int i) {
		if (this.size() == 0)
			throw new EmptyException("Impossibile rimuovere da un IntSet vuoto");

		if (this.contains(i)) {
			elem.remove(Integer.valueOf(i));	
		}
	}

	public int choose() throws EmptyException {
		if (this.size() == 0)
			throw new EmptyException("Impossibile scegliere da un IntSet vuoto");

		return elem.get(this.size() - 1);
	}

	@Override
	public String toString() {
		StringBuilder r = new StringBuilder("IntSet : {");
    	if (this.size() > 0) {
      		for (int i = 0; i < elem.size() - 1; i++) 
			  r.append(elem.get(i)).append(", ");
			  
			r.append(elem.get(elem.size() - 1));
    }
    r.append('}');
    return r.toString();
	}

}
