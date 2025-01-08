package com.tw;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigInitializer {

	@SuppressWarnings("unused")
	private static void processTConfiguration(Object target) throws IOException {
		Class<?> targetClass=target.getClass();
		TConfiguration tConfiguration=targetClass.getAnnotation(TConfiguration.class);
		if (tConfiguration != null) {
			String filename=tConfiguration.filename();
			Properties properties=new Properties();
			try(InputStream input = targetClass.getClassLoader().getResourceAsStream(filename)){
				properties.load(input);
			}
		}
			
	}

}
