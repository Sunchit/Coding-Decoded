class Solution {
public:
    string simplifyPath(string path) {
        
        vector<string> stack;
        string res, temp;
        stringstream p(path);
        
        while (getline(p, temp, '/')) {
            if (temp == "" or temp == ".") continue;
            if (!stack.empty() && temp == "..")
                stack.pop_back();
            else if (temp != "..")
                stack.push_back(temp);
        }
        
        for (auto s : stack)
            res += "/" + s;
        
        return stack.empty() ? "/" : res;
    }
};
