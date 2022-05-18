
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	
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
			else if((table[j].GetKey() == key) && (!table[j].getDeleted())){ //
				return table[j];
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if((Find(hte.GetKey()) == null)){
			boolean inserted = false; //indicator if to throw tableisfullexception
			for(int i=0; i< table.length; i++){
				int j = Hash(hte.GetKey(), i);
				if(table[j] == null || table[i].getDeleted()){ //check back in forum if this is ok!!!!!!!
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
		HashTableElement element = Find(key);
		if(!(element == null)){
			element.Delete();
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
