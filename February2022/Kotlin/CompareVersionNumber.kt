class Solution {
    fun compareVersion(version1: String, version2: String): Int {
    var v1=version1.split(".").toTypedArray()
    var v2=version2.split(".").toTypedArray()
    var i:Int = 0;
        while(i<v1.size&&i<v2.size){
            var a:Int = v1[i].toInt();
            var b:Int = v2[i].toInt();
            if(a>b){
                return 1;
            }else if(a<b){
                return -1;
            }
            i++;
        }
        
        while(i<v1.size){
            var a:Int =v1[i].toInt();
            if(a>0){
                return 1;
            }
            i++;
        }
        
        while(i<v2.size){
            var a:Int=v2[i].toInt();
            if(a>0){
                return -1;
            }
            i++;
        }

    
    return 0
}

}