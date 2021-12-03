import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sol {
	public static void main(String[] args) {
		int add = 0;
		int sub = 0;
		IntQueue i = null;

		File file = new File("input-1.txt");
		try (Scanner scanner = new Scanner(file)) {
		//try (Scanner scanner = new Scanner(System.in)) {
			i = new IntQueue(scanner.nextInt());

			while (scanner.hasNextByte()) {
				int in = scanner.nextByte();

				if (in == +1) {
					i.Enqueue(++add);
				} else if (in == -1) {
					System.out.println(i.Dequeue());
					sub++;
				}

				if (sub > add) {
					scanner.close();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {

		}
		System.out.println(i.toString());
		System.out.println("Totale elementi: " + i.size());
	}
}
