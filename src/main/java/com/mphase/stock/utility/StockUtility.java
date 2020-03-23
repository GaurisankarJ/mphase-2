package com.mphase.stock.utility;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class StockUtility {

    public static Boolean checkDateInRange(String fromDate, String toDate, String date) {
        try {
            DateFormat format = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
            Date testDate = format.parse(date);
            Date dateFrom = format.parse(fromDate);
            Date dateTo = format.parse(toDate);
            return testDate.after(dateFrom) && testDate.before(dateTo) || (testDate.equals(dateFrom) || testDate.equals((dateTo)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
