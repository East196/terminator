package com.github.east196.xcode.common;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

public class Easy {

	public static void sleep(long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	public static <F, T> List<T> map(List<F> fromList, Function<? super F, ? extends T> function) {
		return Lists.transform(fromList, function);
	}

	public static <T> List<T> filter(List<T> unfiltered, Predicate<? super T> predicate) {
		return Lists.newArrayList(Iterables.filter(unfiltered, predicate));
	}

	public static Date praseDate(String dateOrDateTime) {
		String date = dateOrDateTime.replace("+08:00", ".000Z").replace("(null)", ".000Z");
		try {
			return DateUtils.parseDate(date, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
					"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy/MM/dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static final FastDateFormat SHORT_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
	public static final FastDateFormat LONG_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
	public static final FastDateFormat YYYYMMDDHHMMSS_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");
	public static final FastDateFormat YYYYMMDD_FORMAT = FastDateFormat.getInstance("yyyyMMdd");

	public static String shortDate(Date date) {
		return SHORT_DATE_FORMAT.format(date);
	}

	public static String shortDate(long millis) {
		return SHORT_DATE_FORMAT.format(millis);
	}

	public static String longDate(Date date) {
		return LONG_DATE_FORMAT.format(date);
	}

	public static String longDate(long millis) {
		return LONG_DATE_FORMAT.format(millis);
	}

	public static boolean notBlank(CharSequence cs) {
		return !isBlank(cs);
	}

	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if ((cs == null) || ((strLen = cs.length()) == 0)) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean notEmpty(Object obj) {
		return length(obj) != 0;
	}

	public static boolean isEmpty(Object obj) {
		return length(obj) == 0;
	}

	public static int length(Object obj) {
		if (obj == null) {
			return 0;
		} else if (obj instanceof CharSequence) {
			return ((CharSequence) obj).length();
		} else if (obj instanceof Collection) {
			return ((Collection<?>) obj).size();
		} else if (obj instanceof Map) {
			return ((Map<?, ?>) obj).size();
		} else if (obj.getClass().isArray()) {
			return Array.getLength(obj);
		} else {
			return 1;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Collection<T> list, Class<T> type) {
		return list.toArray((T[]) Array.newInstance(type, list.size()));
	}

	public static String md5(String text) {
		HashCode hashCode = Hashing.md5().hashString(text, Charsets.UTF_8);
		return hashCode.toString();
	}

	public static String md5(File file) {
		try {
			HashCode hashCode = Files.hash(file, Hashing.md5());
			return hashCode.toString();
		} catch (Throwable throwable) {
			throw Throwables.propagate(throwable);
		}
	}

	public static void copy(File from, File to) {
		try {
			Files.copy(from, to);
		} catch (Throwable throwable) {
			throw Throwables.propagate(throwable);
		}
	}

	public static void copy(InputStream from, File to) {
		try {
			Files.write(ByteStreams.toByteArray(from), to);
		} catch (Throwable throwable) {
			throw Throwables.propagate(throwable);
		}
	}

	public static String toString(File file) {
		try {
			return Files.toString(file, Charsets.UTF_8);
		} catch (Throwable throwable) {
			throw Throwables.propagate(throwable);
		}
	}

	public static String getFileExtension(String filename) {
		if (filename.endsWith(".tar.gz")) {
			return "tar.gz";
		}
		return Files.getFileExtension(filename);
	}

	public static String getNameWithoutExtension(String filename) {
		String nameWithoutExtension = Files.getNameWithoutExtension(filename);
		if (filename.endsWith(".tar.gz")) {
			nameWithoutExtension += ".tar";
		}
		return nameWithoutExtension;
	}

}
