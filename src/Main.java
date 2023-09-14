import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        printBonusDatesBetween(2010,2015);
    }

    public static void printBonusDatesBetween(int startYear, int endYear) {
        Date startDate = new Date(startYear - 1900, 0, 0); // A year y is represented by the integer y - 1900.
        Date endDate = new Date(endYear - 1900, 11, 31);

        for (Date date = new Date(startDate.getTime()); date.compareTo(endDate) <= 0; date.setTime(date.getTime() + 24 * 60 * 60 * 1000))
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat dateFormatResult = new SimpleDateFormat("yyyy-MM-dd");

            if (isBonus(dateFormat.format(date))) {
                System.out.println(dateFormatResult.format(date));
            }
        }
    }

    public static boolean isBonus(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
