
public abstract class OAHashTable implements IHashTable {
	
	protected HashTableElement [] table;
	private static HashTableElement deleted = new HashTableElement(-1,0);

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		// TODO add to constructor as needed
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for(int i=0; i< table.length; i++){
			int j = Hash(key, i);
			if(table[j] == null){
				return null;
			}
			else if(this.table[j].GetKey() == key){ //
				return this.table[j];
			}
		}
		return null;
	}

	private int FindIndex(long key){ //so we can find index for delete
		for(int i=0; i< table.length; i++){
			int j = Hash(key, i);
			if(table[j] == null){
				return -1;
			}
			else if(table[j].GetKey() == key){ //
				return j;
			}
		}
		return -1;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if((Find(hte.GetKey()) == null)){
			boolean inserted = false; //indicator if to throw tableisfullexception
			for(int i=0; i< table.length; i++){
				int j = Hash(hte.GetKey(), i);
				if(table[j] == null || table[j].GetKey()==-1){
					table[j] = hte;
					inserted = true;
					break;
				}
			}
			if(!inserted){
				throw new TableIsFullException(hte);
			}
		}
		else{
			throw new KeyAlreadyExistsException(hte);
		}
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int element = FindIndex(key);
		if(element!=-1){
			table[element] = deleted;
		}
		else{
			throw new KeyDoesntExistException(key);
		}

	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
