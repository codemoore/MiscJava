/**
 * Implementation of HashMap with a default size of 16 and a max avg load of 2
 * 
 * @author Joshua Moroe
 * @version 5/8/14
 *
 * @param <Key>
 * @param <Value>
 */
public class MyHashMap<Key, Value> {
	
	/** Default size of Map array */
	private static final int CAPACITY = 16;
	
	/** the array containing all of the data */
	private Node<Value>[] values;
	
	/** The current amount of items in the Map */
	private int size;
	
	/**
	 * Initializes the Hash Map with a starting size of size
	 * @param size the starting size of the array
	 */
	@SuppressWarnings("unchecked")
	public MyHashMap(final int size) {
		values = (Node<Value>[]) new Node[size];
	}
	
	/**
	 * Create a MyHashMap of the default size
	 */
	public MyHashMap() {
		this(CAPACITY);
	}
	
	/**
	 * Adds a value to the map in an index based on the hashCode of the key
	 * If the load is too high then remake the map 
	 * 
	 * @param key shows what
	 * @param value
	 */
	public void put(final Key key, final Value value) {
		size++;
		if(size > 2 * values.length) {
			rehash();
		}
		final int index = getIndex(key);
		if(values[index] == null) {
			values[index] = new Node<Value>(value, key.hashCode());
		} else {
			Node<Value> node = values[index];
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<Value>(value, key.hashCode());
		}
	}
	
	/**
	 * puts into the map based of hashCode
	 * @param hashCode the hashCode of the key
	 * @param value the value being inserted
	 */
	private void put(final int hashCode, final Value value) {
		size++;
		if(size > 2 * values.length) {
			rehash();
		}
		final int index =  Math.abs(hashCode) % values.length;
		if(values[index] == null) {
			values[index] = new Node<Value>(value, hashCode);
		} else {
			Node<Value> node = values[index];
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<Value>(value, hashCode);
		}
	}
	
	/**
	 * @param key the key for the value being searched for
	 * @return the Value that corresponds to this key
	 */
	public Value get(Key key) {
		Value value = null;
		Node<Value> node = values[getIndex(key)];
		while(node != null) {
			if(node.hashCode == key.hashCode()) {
				value = node.data;
				break;
			}
			node = node.next;
		}
		return value;
	}
	
	/**
	 * @param key the key for a value
	 * @return the index based on the key
	 */
	private int getIndex(final Key key) {
		return Math.abs(key.hashCode()) % values.length;
	}
	
	/**
	 * Remakes the map with a larger array
	 */
	@SuppressWarnings("unchecked")
	private void rehash(){
		Node<Value>[] oldValues = values;
		values = (Node<Value>[]) new Node[values.length * 2];
		for (int i = 0; i < oldValues.length; i++) {
			Node<Value> node = oldValues[i];
			while(node != null) {
				put(node.hashCode, node.data);
				node = node.next;
			}
		}
	}
}
