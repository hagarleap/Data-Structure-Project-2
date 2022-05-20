import java.util.Random;

public class LPHashTable extends OAHashTable {
	private long p;
	private int m;
	ModHash func;
	
	public LPHashTable(int m, long p) {
		super(m);
		this.m = m;
		this.p = p;
		this.func = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((func.Hash(x)+i), m);
	}
	
}
