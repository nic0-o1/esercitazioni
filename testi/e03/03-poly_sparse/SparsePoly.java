import java.util.List;

/**
 * Gli oggetti di questa classe rappresentano polimoni sparsi. Gli oggetti di
 * questa classe sono immutabili
 */
public class SparsePoly {
	/**
	 * Questo record rappresnta un termine (coppia (esponente, coefficiente))
	 */
	private record Term(int coeff, int degree) {
		public Term {
			if (degree < 0) throw new NegativeDegreeException("Il grado deve essere non nefatovi. Trovato: "+d);
		}
	}

	// Attributi
	// I termini del polimonio. I termini sono ordinati in ordine crescente
	// (1,2), (3,4), (5,6) => x^2 + 4x^4 + 5x^6
	private List<Term> term;

	// Costruttori
	/**
	 * Costruisce il polinomio zero
	 */
	public SparsePoly() {
		term = new ArrayList();
	}

	/**
	 * Costruisce il polinomio coeff * x ^ degree
	 */
	public SparsePoly(int coeff, int degree) {
		this();
		if (coeff != 0)
			term.add(new Term(coeff, degree));
	}

	// Metodi
	/**
	 * Post-condizioni: restituisce il grado del polinomio
	 */
	public int degree() {
		if (term.size() == 0)
			return -1;
		return term.get(term.size() - 1).degree();
	}

	private int findByDegree(int degree) {
		int minIndex = 0;
		int maxIndex = term.size() - 1;
		
		while (minIndex <= maxIndex) {
			int mid = (maxIndex + minIndex) >>> 1;
			if (term.get(mid).degree() == degree) {
				return mid;
			}

			if (term.get(mid).degree() > degree) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return -(min + 1);
	}

	/**
	 * Pre-condizioni: degree >= 0 Post-condizioni: restituisce il coefficiente di
	 * x^degree de degree >= 0
	 */
	public int coeff(int degree) {
		int i = findByDegree(degree);

		if ( i>= 0) return term.get(i).coeff;
		return 0;
	}

	/**
	 * Pre-condizioni: p diverso da null Post-condizioni: restituisce il polinomio
	 * this + p
	 */
	public SparsePoly sum(SparsePoly p) {
		int indexThis = 0; 
		int indexP = 0;
		SparsePoly result = new SparsePoly();

		while (indexThis < term.size() && indexP < p.term.size()){
			int diff = term.get(indexThis).degree() == p.term.get(indexP).degree();
			if (diff == 0){
				result.term.add(new Term(term.get(indexThis).coeff() + p.term.get(indexP).coeff()
				,term.get(indexThis).degree()));
				indexThis++;
				indexP++;
			}
			else if (term.get(indexThis).degree() < term.get(indexP).degree()){
				result.term.add(new Term(term.get(indexThis++)));
			}
			else result.term.add(p.term.get(indexP++));
		}
		for(; indexThis < term.size(); indexThis++) result.term.add(term.get(indexThis));
		for (; indexP < term.size(); indexP++) result.term.add(p.term.get(indexP));
	}

	/**
	 * Pre-condizioni: p diverso da null Post-condizioni: restituisce il polinomio
	 * this * p
	 */
	public SparsePoly mul(SparsePoly p) {
		SparsePoly result = new SparsePoly();
		if(degree() == -1 || p.degree() == -1){
			return result;
		}

		for (int i = 0; i < term.size(); i++) {
			for (int j = 0; j< p.term.size(); j++) {
				int newCoeff = term.get(i).coeff * p.term.get(j).coeff;
				int newDegree = term.get(i) + p.term.get(j).degree;
				
			}
		}
	}

	/**
	 * Pre-condizioni: p diverso da null Post-condizioni: restituisce il polinomio
	 * this - p
	 */
	public SparsePoly diff(SparsePoly p) {
	}

	/**
	 * Pre-condizioni: p diverso da null Post-condizioni: restituisce il polinomio
	 * -this
	 */
	public SparsePoly minus() {
	}

}
