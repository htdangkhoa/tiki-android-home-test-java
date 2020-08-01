package com.github.htdangkhoa.tikitestjava.util;

import java.text.NumberFormat;
import java.util.Currency;

public class NumberUtil {
    public static String formatPrice(Number number) {
        NumberFormat format = NumberFormat.getCurrencyInstance();

        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("VND"));

        return format.format(number);
    }
}
