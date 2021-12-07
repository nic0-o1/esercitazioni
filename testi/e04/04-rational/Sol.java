import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol {
	public static void main(String[] args) {
		List<RationalNumber> elem = new ArrayList<RationalNumber>();
		File file = new File("input-1.txt");

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				elem.add(new RationalNumber(scanner.nextInt(), scanner.nextInt()));
			}

		} catch (FileNotFoundException e) {
		} catch (RuntimeException e) {
		} catch (Exception e) {
		}

		RationalNumber somma, prod, div;
		int equals = 0;
		somma = elem.get(0);
		prod = elem.get(0);
		div = elem.get(0);
		for (int i = 1; i < elem.size(); i++) {
			try {

				somma = somma.Add(elem.get(i));
				prod = prod.Mul(elem.get(i));
				div = div.Div(elem.get(i));

			} catch (IllegalArgumentException e) {
				// System.out.println(e.toString());

			}
		}

		for (int i = 0; i < elem.size(); i++) {
			for (int j = i; j < elem.size(); j++) {
				if (i != j && elem.get(i).equals(elem.get(j)))
					equals++;
			}

		}

		System.out.println(somma.toString());
		System.out.println(prod.toString());
		System.out.println(div.toString());
		System.out.println(equals);
	}
}
