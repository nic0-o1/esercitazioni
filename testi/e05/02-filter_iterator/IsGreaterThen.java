import java.util.function.Predicate;

public class IsGreaterThen implements Predicate<Integer> {
	public final int threshold;

	public IsGreaterThen(final int threshold) {
		this.threshold = threshold;
	}

	@Override
	public boolean test(Integer t) {
		return t > threshold;
	}
}