// https://leetcode.com/problems/find-duplicate-file-in-system/
class Solution {
private:
    vector<string> split(string& str) {
        vector<string> list;
        string currWord = "";

        for (int i = 0; i < str.length(); i++) {
            if (str[i] == ' ') {
                list.push_back(currWord);
                currWord.clear();
            } else {
                currWord += str[i];
            }
        }
        list.push_back(currWord);
            
        return list;
    }

    void storeInHash(string& dir, string& fileName, unordered_map<string, vector<string>>& map) {
        string sb = dir;
        if (dir[dir.length() - 1] != '/') {
            sb += '/';
        }
		
        string content = "";
        int i = 0;
        while (i < fileName.length()) {
            char c = fileName[i];
            if (c == '(') {
                while (c != ')') {
                    content += c;
                    i++;
                    c = fileName[i];
                }
            } else {
                sb += c;
            }
            i++;
        }
		
        map[content].push_back(sb);
    }

public:
    // TC: O(paths.length * paths[i].length)
    // SC: O(no of duplicate files)	-> hash map
    vector<vector<string>> findDuplicate(vector<string>& paths) {
        unordered_map<string, vector<string>> map;
        
        for (auto path : paths) {
            vector<string> strArr = split(path);
            string dir = strArr[0];
            for (int i = 1; i < strArr.size(); i++) {
                storeInHash(dir, strArr[i], map);
            }
        }

        vector<vector<string>> ans;
        for (auto file : map) {
            if (file.second.size() > 1) {
                ans.push_back(file.second);
            }
        }

        return ans;
    }
};
