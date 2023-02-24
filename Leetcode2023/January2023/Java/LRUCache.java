class LFUCache {

	private int cap;
	// Key , Value 


	private int min = 1;

	Map<Integer,Integer> keyValueMap = new HashMap<>();
	// Key , keyFrequencyMap
	Map<Integer,Integer> keyFrequencyMap = new HashMap<>();
	// keyFrequencyMap, Set of keys in ordered format 
	// Why ordered so that in case of collision least recently used is keyToBeEvicteded
	Map<Integer,LinkedHashSet<Integer>> freqKeysMap = new HashMap<>();

	public LFUCache(int capacity) {
		cap = capacity;
		freqKeysMap.put(1,new LinkedHashSet<>());
	}
    // O(1)
	public int get(int key) {

		if(!keyValueMap.containsKey(key)) {
			return -1;
		}

		int frequency = keyFrequencyMap.get(key);
		// remove the key from the previous frequency 
		freqKeysMap.get(frequency).remove(key);

		if(frequency==min && freqKeysMap.get(frequency).size()==0) {
            	min++;
		} 
		if(!freqKeysMap.containsKey(frequency+1)) {
			freqKeysMap.put(frequency + 1, new LinkedHashSet<>());
		}
		// add the key corresponding to freq+1
		freqKeysMap.get(frequency+1).add(key);
		// increment the frequency by one for the current key
		keyFrequencyMap.put(key,frequency+1);

		return keyValueMap.get(key);
	}

    // O(1)
	public void put(int key, int value) {
		if(cap<=0)
			return;
		if(keyValueMap.containsKey(key))
		{
			keyValueMap.put(key,value);
			get(key);
			return;
		}
		if(keyValueMap.size()>=cap)
		{
			int keyToBeEvicted = freqKeysMap.get(min).iterator().next();
			freqKeysMap.get(min).remove(keyToBeEvicted);
			keyValueMap.remove(keyToBeEvicted);
			keyFrequencyMap.remove(keyToBeEvicted);
		}
		// key is not present in the KeyValueMap
		keyValueMap.put(key,value);
		keyFrequencyMap.put(key,1);
		min = 1;
		freqKeysMap.get(1).add(key);

	}
}
