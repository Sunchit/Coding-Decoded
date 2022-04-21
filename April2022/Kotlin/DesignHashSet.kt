// Author: Shobhit Behl (LC: shobhitbruh)
class MyHashSet() {
    var hs: HashSet<Int>
    fun add(key: Int) {
        hs.add(key)
    }

    fun remove(key: Int) {
        hs.remove(key)
    }

    fun contains(key: Int): Boolean {
        return hs.contains(key)
    }

    init {
        hs = HashSet()
    }

}