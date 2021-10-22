import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {

	/***
	 * Pre-condizioni: a != null Post-condizioni: al termine della procedura, a
	 * conterrà il suo reversal Effetti collaterali: a potrebbe essere modificato
	 */
	static void reverse(byte[] a) { // si modifica direttmente l'array a, si passa il riferimento
		for (int i = 0; i < a.length / 2; i++) {
			byte tmp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = tmp;

		}
	}

	/***
	 * Pre-condizioni: a != null, ciascuna posizione di a deve contenere un numero
	 * compreso tra 0 e 9 (inclusi) Post-condizioni:restituisce l'intero le cui
	 * cifre sono raprresentate dai numeri memorizzati in a
	 */
	static int digitsToNum(byte[] a) {
		int n = 0;

		for (byte b : a) {
			n = n * 10 + b;
		}

		return n;
	}

	/***
	 * Pre-condizioni: digits > 0, digits >= cifre di n, n>=0 Post-condizioni:
	 * restituisc un array contenente le cifre di n
	 */
	static byte[] numToDigits(int n, int digits) { // digits -> numero di cifre
		byte[] a = new byte[digits];
		for (int i = 0; i < digits; i++) {
			a[i] = (byte) (n % 10);
			n /= 10;
		}

		return a;
	}

	/***
	 * Pre-condizioni: n > 0 Post-condizioni: restituisca il numero successivo della
	 * sequenza di Kaprekar Effetti collaterali:
	 */
	static int nextKaprekar(int n) {
		byte[] a = numToDigits(n, 4);
		Arrays.sort(a);

		n = -digitsToNum(a);
		reverse(a);
		n += digitsToNum(a);

		return n;
	}

	/***
	 * Pre-condizioni: 0 <= n <= 9999, n deve avere almeno 2 cifre diverse
	 * Post-condizioni: Stampa la sequenza di Kaprekar a partire da n Effetti
	 * collaterali: System.out modificato
	 */
	static void printKaprekar(int n) {
		if (n < 0 || n > 9999)
			throw new IllegalArgumentException("n must be between 0 and 9999");

		while (n != 6174) {
			System.out.println(n);
			n = nextKaprekar(n);
		}
		System.out.println(n);
	}

	public static void main(String[] args) {
		InputStream is;
		try {
			is = new URL("https://www.random.org/integers/?num=1&min=0&max=9999&col=1&base=10&format=plain")
					.openStream();
		} catch (MalformedURLException e) {
			is = System.in;
		} catch (IOException e) {
			is = System.in;
		}

		Scanner s = new Scanner(is);
		printKaprekar(s.nextInt());

	}
}
