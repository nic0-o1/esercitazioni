import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Sol {
	public static void main(String[] args) {

		IntSet set = new IntSet();

		set.Insert(5);
		set.Insert(3);
		set.Insert(2);
		set.Insert(8);
		set.Insert(9);
		set.Insert(1);


		Iterator<Integer> filtered = new FilterIterator<>(
			set.iterator(),
			new IsGreaterThen(5)
			);
		while (filtered.hasNext()) System.out.println(filtered.next());
	}
}
