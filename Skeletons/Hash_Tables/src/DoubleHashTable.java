import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private long p;
	private int m;
	ModHash func1;
	ModHash func2;

	public DoubleHashTable(int m, long p) {
		super(m);
		this.m = m;
		this.p = p;
		this.func1 = ModHash.GetFunc(m,p);
		this.func2 = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return  Math.floorMod ((func1.Hash(x) + i*(func2.Hash(x))), m);
	}
	
}
