package com.caojianyu;

import com.caojianyu.timer.constant.TimeConstant;

/**
 * @author caojianyu
 * @create 2020-01-15 19:01
 * @mail jieni_cao@foxmail.com
 *
 */
public class Transform {

	private static final Long ZERO = 0L;

	public static Long getTimeInterval(Long hour, Long minutes, Long seconds) {
		Long timeInterval = 0L;
		if (ZERO.equals(hour) && ZERO.equals(minutes) && ZERO.equals(seconds)) {
			throw new NullPointerException("定时器时间间隔未设置");
		}

		if (!ZERO.equals(hour) && ZERO.equals(minutes) && ZERO.equals(seconds)) {
			timeInterval = hour * TimeConstant.HOUR_TRANSLATE;
		} else if (ZERO.equals(hour) && !ZERO.equals(minutes) && ZERO.equals(seconds)) {
			timeInterval = minutes * TimeConstant.MINUTES_TRANSLATE;
		} else if (ZERO.equals(hour) && ZERO.equals(minutes) && !ZERO.equals(seconds)) {
			timeInterval = seconds * 1000L;
		} else if (!ZERO.equals(hour) && !ZERO.equals(minutes) && ZERO.equals(seconds)) {
			timeInterval = hour * TimeConstant.HOUR_TRANSLATE + minutes * TimeConstant.MINUTES_TRANSLATE;
		} else if (!ZERO.equals(hour) && ZERO.equals(minutes) && !ZERO.equals(seconds)) {
			timeInterval = hour * TimeConstant.HOUR_TRANSLATE + seconds * TimeConstant.SECONDS_TRANSLATE;
		} else if (ZERO.equals(hour) && !ZERO.equals(minutes) && !ZERO.equals(seconds)) {
			timeInterval = minutes * TimeConstant.MINUTES_TRANSLATE + seconds * TimeConstant.SECONDS_TRANSLATE;
		} else {
			timeInterval = hour * TimeConstant.HOUR_TRANSLATE + minutes * TimeConstant.MINUTES_TRANSLATE
					+ seconds * TimeConstant.SECONDS_TRANSLATE;
		}

		return timeInterval;
	}

}
