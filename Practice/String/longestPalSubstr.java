
// Reference: https://github.com/sapnaavya/Data_Structure/blob/master/String/longestPalSubString.java

string longestPalindrome(string s) {
    int n = s.length();
    int maxBegin = 0;
    int maxLen = 1;
    bool table[1000][1000] = {false};

    for (int i = 0; i < n; i++) {
        table[i][i] = true;
    }

    for (int i = 0; i < n-1; i++) {
            if (s[i] == s[i+1]) {
            table[i][i+1] = true;
            maxBegin = i;
            maxLen = 2;
        }
    }
    for (int len = 3; len <= n; len++) {
        for (int i = 0; i < n-len+1; i++) {
            int j = i+len-1;
            if (s[i] == s[j] && table[i+1][j-1]) {
                table[i][j] = true;
                maxBegin = i;
                maxLen = len;
            }
        }
    }
    return s.substr(maxBegin, maxLen);
}