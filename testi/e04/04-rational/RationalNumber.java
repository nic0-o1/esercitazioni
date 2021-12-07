import java.util.Objects;

public class RationalNumber {
	private int num;
	private int den;

	public RationalNumber(int num) {
		this(num, 1);
	}

	public RationalNumber(int num, int den) {
		Objects.requireNonNull(den, "Il denominatore non può essere vuoto");
		Objects.requireNonNull(num, "Il numeratore non può essere vuoto");

		if (den == 0)
			throw new IllegalArgumentException("Il denominatore non può essere = a 0");

		if (num == 0)
			den = 1;

		if (den < 0) {
			num = -1 * num;
			den = -1 * den;
		}

		if (num < 0 && den < 0) {
			num = Math.abs(num);
			den = Math.abs(den);
		}

		int cd = gcd(num, den);

		this.num = num / cd;
		this.den = den / cd;

		assert repOK();
	}

	public int Num() {
		return num;
	}

	public int Den() {
		return den;
	}

	public RationalNumber Add(RationalNumber n) {
		Objects.requireNonNull(n);
		return new RationalNumber(this.Num() * n.Den() + n.Num() * this.Den(), this.Den() * n.Den());
	}

	public RationalNumber Mul(RationalNumber n) {
		Objects.requireNonNull(n);
		return new RationalNumber(this.Num() * n.Num(), this.Den() * n.Den());
	}

	public RationalNumber Div(RationalNumber n) {
		Objects.requireNonNull(n);
		return Mul(n.Reciprocal());
	}

	public RationalNumber Reciprocal() {
		return new RationalNumber(this.Den(), this.Num());
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}

		return a;
	}

	/**
	 * Den != 0, Num != 0
	 * 
	 */
	public boolean repOK() {
		return den != 0
				&& num != 0;
	}

	@Override
	public String toString() {
		if (den != 1)
			return num + "/" + den;

		return num + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof RationalNumber))
			return false;

		RationalNumber other = (RationalNumber) obj;

		return other.Num() == this.Num() && other.Den() == this.Den();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.Num(), this.Den());
	}

}
