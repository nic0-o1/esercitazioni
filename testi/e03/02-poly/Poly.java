
public class Poly {
	private int deg;
	private int coeff;

	public Poly() {
		this.deg = 0;
		this.coeff = 0;
	}

	public Poly(int deg, int coeff) {
		if (deg < 0) throw new NegativeExponentException("deg must be positive");
		this.deg = deg;
		this.coeff = coeff;
	}

	public int degree() {
		return deg;
	}

	public int coeff() {
		return coeff;
	}

	public Poly add(Poly q) {
		//Si assume che si sommino monomi con lo stesso grado
		if (q.degree() != this.deg) throw new DegreeNotEqualException("Impossibile sommare monomi con gradi differenti");

		return new Poly(this.deg, this.coeff + q.Coeff());
	}

	public Poly sub(Poly q) {
		//Si assume che si sottraggano monomi con lo stesso grado
		if (q.degree() != this.deg) throw new DegreeNotEqualException("Impossibile sommare monomi con gradi differenti");

		return new Poly(this.deg, this.coeff - q.coeff());
	}

	public Poly mul(Poly q) {
		return new Poly(this.deg + q.deg, this.coeff * q.coeff());
	}
	
	public Poly minus(Poly q) {
		return new Poly(q.deg, -1*q.coeff());
	}

	@Override
	public String toString() {
		return "Polinomio: " + this.coeff +"x"+ "^ " + this.deg;
	}

	
}
