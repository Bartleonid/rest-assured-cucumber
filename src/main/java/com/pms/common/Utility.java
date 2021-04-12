package com.pms.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

	public static String extractValueByRegex(String html, String pattern, int group) {
		String value = null;
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(html);
		if (m.find()) {
			value = m.group(group);
			return value;
		}
		return null;
	}
}
