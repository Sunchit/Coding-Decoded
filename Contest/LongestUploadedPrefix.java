// https://leetcode.com/problems/longest-uploaded-prefix/
// @author: anuj0503
class LUPrefix {
    boolean[] video;
    int l;
    public LUPrefix(int n) {
        video = new boolean[n + 1];
        l = 0;
    }

    public void upload(int v) {
        video[v] = true;

        while(l + 1 < video.length && video[l + 1]){
            l++;
        }
    }

    public int longest() {
        return l;
    }
}
