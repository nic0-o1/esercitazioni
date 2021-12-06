import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sol {
	public static void main(String[] args) {
		SimpleMap simpleMap = new SimpleMap();

		File file = new File("input-7.txt");
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String in = scanner.nextLine();

				String[] parts = in.split(" ");
				if (parts[0].equals("+")) {
					try {
						simpleMap.Put(new Item(parts[1], Integer.parseInt(parts[2])));
					} catch (RuntimeException e) {
						// System.out.println(e.toString());
					}
				} else {
					try {

						System.out.println(simpleMap.Remove(parts[1]));
					} catch (RuntimeException e) {
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Totale elementi: " + simpleMap.Size());
	}
}
