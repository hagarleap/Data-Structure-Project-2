
public class HashTableElement{
	private long key;
	private long value;
	private boolean deleted;
	
	public HashTableElement(long key, long value) {
		this.key = key;
		this.value = value;
		this.deleted = false;
	}
	
	public long GetKey() { return this.key;}
	
	public long GetValue() { return this.value;}

	public boolean getDeleted() {return this.deleted;}

	public void Delete() {this.deleted = true;}
}