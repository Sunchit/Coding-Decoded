// Problem Link : https://leetcode.com/problems/encode-and-decode-tinyurl/
class Solution {
public:
    unordered_map<string,string> mp;
    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        string sb = "";
        sb += (char)(10+rand()%246);
        while(mp.count(sb) == 1){
         sb += (char)(10+rand()%246);
        }
        mp[sb] = longUrl;
        return sb;
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        if(mp.count(shortUrl)){
            return mp[shortUrl];
        }
        else{
            return "";
        }
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));
