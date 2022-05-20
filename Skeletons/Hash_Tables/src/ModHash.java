import java.util.SplittableRandom;

public class ModHash {
	private long a;
	private long b;
	private int m;
	private long p;

	private ModHash(long a, long b, int m, long p){
		this.a = a;
		this.b = b;
		this.m = m;
		this.p = p;
	}

	public static ModHash GetFunc(int m, long p){
		SplittableRandom rand = new SplittableRandom();
		long a = rand.nextLong(1,p);
		long b = rand.nextLong(0,p);
		ModHash mod = new ModHash(a,b,m,p);
		return mod;
	}
	
	public int Hash(long key) {
		return (int)(Math.floorMod(Math.floorMod((a*key + b), p ) , m));
	}
}
