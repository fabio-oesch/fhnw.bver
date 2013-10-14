package test;

import java.util.BitSet;

public class Test {

	public static void main(String[] args) {
		BitSet bs = new BitSet();
		bs.set(8);
		bs.set(1);
		bs.set(2);

		for (int i = 0; i < bs.length(); i++) {
			System.out.println(bs.get(i));
		}
	}

}
