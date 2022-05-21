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
		if((i&1) == 0){ //checking the first bit of 1!
			return Math.floorMod((func.Hash(x) + (i*i)),  m);
		}
		else{
			return Math.floorMod((func.Hash(x) + (-1)*i*i),  m);
		}

	}
}
