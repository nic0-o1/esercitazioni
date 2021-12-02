import java.util.Scanner;

public class provaDelNove {
	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {
			int num = s.nextInt();

			GenearaProve(num);
		}

	}
	
	private static void GenearaProve(int num) {
		for (int i = 0; i < num; i++) { // A
			for (int j = 0; j < num; j++) { // B
				for (int k = 0; k < num; k++) { // C
					if (i * j != k) { // A * B != C
						if (VerificaProva(i, j, k)) {
							System.out.println(String.format("%d %d %d", i, j, k));
						}
					}
				}
			}
		}
	}

	private static int Riduci(int n) {
		if (n < 10)
			return n;

		return Riduci((n % 10) + (n / 10));
	}

	private static boolean VerificaProva(int a, int b, int c) {
		return Riduci(Riduci(a) * Riduci(b)) == Riduci(c);
	}
}
