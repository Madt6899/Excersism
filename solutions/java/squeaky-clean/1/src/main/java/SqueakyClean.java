class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean isAfterHyphen = false; 
        for (int i = 0; i < identifier.length(); i++) {
            char ch = identifier.charAt(i);
            switch (ch) {
                case '4': ch = 'a'; break;
                case '3': ch = 'e'; break;
                case '0': ch = 'o'; break;
                case '1': ch = 'l'; break;
                case '7': ch = 't'; break;
            }
            if (ch == '-') {
                isAfterHyphen = true;
            }
            else if (isAfterHyphen) {
                if (Character.isLetter(ch)) {
                    result.append(Character.toUpperCase(ch));
                }
                isAfterHyphen = false; 
            }
            else if (ch == ' ') {
                result.append('_');
            }
            else if (Character.isLetter(ch)) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
