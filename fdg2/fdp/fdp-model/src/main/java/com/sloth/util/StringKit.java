package com.sloth.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringKit {
	public static boolean isNotEmpty(String str) {
		return str != null && !str.trim().equals("");
	}

	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}

	public static int getAgeByBirth(Date birthDay) {
        int age = 0;
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }
	
	public static boolean isValidDate(String str) {
		boolean result = true;
		// 判断字符串长度是否为10位
		if (str.length() == 10) {
			// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
			// SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				// 设置lenient为false.
				// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
				format.setLenient(false);
				format.parse(str);
			} catch (ParseException e) {
				// e.printStackTrace();
				// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
				result = false;
			}
		} else {
			result = false;
		}

		return result;
	}
}