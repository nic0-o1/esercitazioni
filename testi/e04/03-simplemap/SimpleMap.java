import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleMap {
	private final List<Item> elem;

	public SimpleMap() {
		elem = new ArrayList<Item>();

		assert repOK();
	}

	public void Put(Item i) {
		if (this.Size() > 0 && elem.indexOf(i) != -1)
			throw new DuplicateKeyException("Impossibile inserire una chiave duplicata. " + i.toString());

		elem.add(i);

		assert repOK();
	}

	public Item Remove(String key) {
		Objects.requireNonNull(key, "La chiave non può essere vuota");

		if (this.Size() == 0)
			throw new EmptyMapException("Impossibile rimuovere dalla mappa vuota");

		for (int i = elem.size() - 1; i >= 0; i--) {
			if (elem.get(i).Key().equals(key)) {
				return elem.remove(i);
			}
		}
		assert repOK();

		throw new CantFindKeyException("Impossibile trovare la chiave specificata remove " + key);
	}

	public int Get(String key) {
		Objects.requireNonNull(key, "La chiave non può essere vuota");

		if (this.Size() == 0)
			throw new EmptyMapException("Impossibile prelevare dalla mappa vuota");

		for (Item i : elem) {
			if (i.Key() == key) {
				return i.Value();
			}
		}

		throw new CantFindKeyException("Impossibile trovare la chiave specificata get " + key);
	}

	public int Size() {
		return elem.size();
	}

	public boolean repOK() {
		return elem != null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Simple map");

		for (Item el : elem) {
			sb.append(el.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof SimpleMap))
			return false;

		SimpleMap other = (SimpleMap) obj;

		if (other.Size() != this.Size())
			return false;

		for (Item i : this.elem) {
			int oth = other.Get(i.Key());

			if (oth != i.Value()) {
				return false;
			}

		}
		return true;

	}

	@Override
	public int hashCode() {
		int hash = 0;

		for (Item i : elem) {
			hash = 31 * hash + (i.hashCode());
		}

		return hash;
	}
}
