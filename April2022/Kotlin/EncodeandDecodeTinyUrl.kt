// Author: Shobhit Behl (LC: shobhitbruh)

class Codec {
    // Encodes a URL to a shortened URL.
    /*
    
    Here i have decoded the string by taking the int value of its each character 
    and by adding '.' in front of it.

    For e.g in string = "add" the encoded string would be "97.100.100."
    
    
    */
    fun encode(longUrl: String): String {
        val l = longUrl.toCharArray()
        val sb = StringBuilder()
        for (i in l.indices) {
            val k = l[i].toInt()
            sb.append(k)
            sb.append('.')
        }
        return sb.toString()
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        val y = shortUrl.split("\\.".toRegex()).toTypedArray()
        val sb = StringBuilder()
        for (i in y.indices) {
            if(y[i].length==0){
                break;
            }
            val k:Int = y[i].toInt()
            val p = k.toChar()
            sb.append(p)
        }
        return sb.toString()
    }
}