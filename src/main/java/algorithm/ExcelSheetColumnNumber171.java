package algorithm;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/08/18
 */
public class ExcelSheetColumnNumber171 {

    public int titleToNumber(String s) {
        int length = s.length();
        int result = 0;
        for (int currentLength = length; currentLength > 0; currentLength--) {
            int index = currentLength - 1;
            int letterNum = this.getLetterNum(s.charAt(index));
            if (length == currentLength) {
                result += letterNum;
            } else {
                result += letterNum * Math.pow(26, (length - currentLength));
            }
        }
        return result;
    }

    public int getLetterNum(char letter) {
        switch (letter) {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            case 'I':
                return 9;
            case 'J':
                return 10;
            case 'K':
                return 11;
            case 'L':
                return 12;
            case 'M':
                return 13;
            case 'N':
                return 14;
            case 'O':
                return 15;
            case 'P':
                return 16;
            case 'Q':
                return 17;
            case 'R':
                return 18;
            case 'S':
                return 19;
            case 'T':
                return 20;
            case 'U':
                return 21;
            case 'V':
                return 22;
            case 'W':
                return 23;
            case 'X':
                return 24;
            case 'Y':
                return 25;
            case 'Z':
                return 26;
            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber171 excelSheetColumnNumber171 = new ExcelSheetColumnNumber171();
        int a = excelSheetColumnNumber171.titleToNumber("AAA");
        System.out.println(a);
    }
}
