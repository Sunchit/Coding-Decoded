class RandomizedSet {

    Map<Integer, Integer> map = null;
    List<Integer> arrayList = null;

    Random rand = null;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arrayList = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, arrayList.size());
            arrayList.add(val);
            return true;
        } else{
            return false;
        }

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            // replace from last always


            Integer lastNodeVal = arrayList.get(arrayList.size()-1);

            if(lastNodeVal== val){
                arrayList.remove(arrayList.size()-1);
                map.remove(new Integer(val));
                return true;
            }
            int indexOfVal = map.get(val);
            arrayList.set(indexOfVal, lastNodeVal);
            map.put(lastNodeVal, indexOfVal);
            arrayList.remove(arrayList.size()-1);
            map.remove(new Integer(val));
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {

        int size = arrayList.size();
        int index = rand.nextInt(size);
        return arrayList.get(index);
    }
}