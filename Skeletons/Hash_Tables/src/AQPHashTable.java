import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private long p;
	private int m;
	ModHash func;

	public AQPHashTable(int m, long p) {
		super(m);
		this.m = m;
		this.p = p;
		this.func = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((func.Hash(x) + (int)(Math.pow(-1,i))*i*i),  m);
	}
}
