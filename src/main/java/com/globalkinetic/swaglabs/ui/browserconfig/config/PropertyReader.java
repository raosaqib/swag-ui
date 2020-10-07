package com.globalkinetic.swaglabs.ui.browserconfig.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.globalkinetic.swaglabs.ui.browserconfig.BrowserType;
import com.globalkinetic.swaglabs.ui.test.helper.resource.ResourceHelper;

/**
 * 
 * @author rao saqib
 *
 */
public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		try {
			String filePath = ResourceHelper.getResourcePath("src/main/resources/configfile/config.properties");
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	public String getUrl() {
		if (System.getProperty("url") != null) {
			return System.getProperty("url");
		}
		return OR.getProperty("applicationUrl");
	}

	@Override
	public String cartpagheader() {
		
		return OR.getProperty("cartpagheader");
	}

	@Override
	public String homepageheader() {
		
		return OR.getProperty("homepageheader");
	}


	@Override
	public String getAppTitle() {
		return OR.getProperty("getAppTitle");
	}

	
}
