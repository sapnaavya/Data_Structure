//Ref: https://codereview.stackexchange.com/questions/66392/evaluation-of-a-solution-for-run-length-encoding-algorithm

public String compress(String str) {
    if (str.isEmpty()) {
        return "";
    }

    char[] chars = str.toCharArray();
    StringBuilder builder = new StringBuilder();

    int count = 1;
    char prev = chars[0];
    for (int i = 1; i < chars.length; i++) {
        char current = chars[i];
        if (current == prev) {
            count++;
        } else {
            builder.append(count).append(prev);
            count = 1;
        }
        prev = current;
    }
    return builder.append(count).append(prev).toString();
}