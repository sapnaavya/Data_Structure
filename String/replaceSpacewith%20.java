// Write a method to replace all spaces in a string with '%20'.
	// COMPLEXITY O (N + 2 * #SPACES ) O (N)  AVG
	public static char[] replaceSpaces(char str[]){
		int spaces = 0;
		for(int i = 0; i < str.length; i++){
			if(str[i] == ' '){
				spaces++;
			}
		}
		int length = str.length + (2*spaces);
		char result [] = new char[length];
		int index = 0;
		for(int i = 0; i < str.length; i++){
			if(str[i] == ' '){
				result[index++] = '%';
				result[index++] = '2';
				result[index++] = '0';
			}else{
				result[index++] = str[i];
			}
		}
		return result;
}