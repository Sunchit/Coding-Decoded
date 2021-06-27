/**
 * @author ssrbazpur
 * 
 */

class Solution
{
public:
    // w- no of words , n - length of word
    //Time: O(w*n*n*26) |  Space: O(n*w)
    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
    {

        unordered_set<string> hm;
        for (string word : wordList)
        {
            hm.insert(word);
        }

        if (hm.find(endWord) == hm.end())
            return 0;

        queue<string> q;
        q.push(beginWord);
        int level = 0;

        while (!q.empty())
        {

            level++;
            int len = q.size();

            while (len-- > 0)
            {
                //get value and pop here
                string value = q.front();
                q.pop();
                for (int i = 0; i < value.size(); i++)
                {

                    string temp = value;
                    for (char j = 'a'; j <= 'z'; j++)
                    {

                        temp[i] = j;
                        if (temp == value)
                        {
                            continue;
                        }

                        if (temp == endWord)
                            return level + 1;

                        if (hm.find(temp) != hm.end())
                        {
                            q.push(temp);
                            hm.erase(temp);
                        }
                    }
                }
            }
        }

        return 0;
    }
};