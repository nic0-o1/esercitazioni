/**
 * Classe rappresentante la struttura dati contenuta nella mappa
 * Key -> stringa
 * Value -> int *
 */
public class Item {
	private final String key;
	private final int value;

	public Item(String key, int value) {
		this.key = key;
		this.value = value;

		assert repOK();
	}

	public int Value() {
		return value;
	}

	public String Key() {
		return key;
	}

	private boolean repOK() {
		return this.key != null;
	}

	@Override
	public String toString() {
		return this.Key() + " -> " + this.Value();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Item))
			return false;

		Item other = (Item) obj;
		return this.Key().equals(other.Key());
	}

	@Override
	public int hashCode() {
		int hashCode = 7;

		hashCode = 31 * hashCode + this.Key().hashCode();

		return hashCode;
	}

}
