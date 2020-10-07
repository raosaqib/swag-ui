package com.globalkinetic.swaglabs.ui.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.globalkinetic.swaglabs.ui.test.helper.resource.ResourceHelper;

/**
 * 
 * @author saqib
 *
 */
public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class cls) {
		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator
				.configure(ResourceHelper.getResourcePath("src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
	}

}
