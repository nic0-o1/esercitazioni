public class Sol {
	public static void main(String[] args) {
		IntSet i = new IntSet();
		i.insert(5);
		i.insert(22);
		System.out.println(i.toString());
		i.remove(5);
		System.out.println(i.toString());
	}
}
