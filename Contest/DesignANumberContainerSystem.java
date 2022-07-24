// https://leetcode.com/problems/design-a-number-container-system/
// @author: anuj0503
class NumberContainers {
    TreeMap<Integer, Integer> map;
    public NumberContainers() {
        map = new TreeMap<>();
    }

    public void change(int index, int number) {
        map.put(index, number);
    }

    public int find(int number) {
        if(map.values().contains(number)) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() == number)
                    return entry.getKey();
            }
        }
        
        return -1;
    }
}
