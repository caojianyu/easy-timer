package com.caojianyu;

import java.lang.reflect.*;

import com.caojianyu.timer.annotation.Timer;

/**
 * @author caojianyu
 * @create 2019-12-26 11:20
 * @mail jieni_cao@foxmail.com
 * 
 */
public class Processor {

	public static void process(Class<?> clazz) {

		Runnable runnable = new Runnable() {
			public void run() {
				boolean isTrue = false;
				isTrue = clazz.isAnnotationPresent(Timer.class);
				if (isTrue) {

					Timer getAnnotation = clazz.getAnnotation(Timer.class);

					Long hour = Long.parseLong(getAnnotation.hour());
					Long minutes = Long.parseLong(getAnnotation.minutes());
					Long seconds = Long.parseLong(getAnnotation.seconds());

					Long timeInterval = Transform.getTimeInterval(hour, minutes, seconds);
					while (true) {
						for (Method method : clazz.getDeclaredMethods()) {
							Constructor<?> con;
							try {
								con = clazz.getConstructor();
								method.invoke(con.newInstance());
							} catch (NoSuchMethodException | SecurityException e) {
								e.printStackTrace();
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
									| InstantiationException e) {
								e.printStackTrace();
							}
						}

						try {
							Thread.sleep(timeInterval);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		new Thread(runnable).start();
	}
}
