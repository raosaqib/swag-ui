package com.globalkinetic.swaglabs.ui.browserconfig.config;

import com.globalkinetic.swaglabs.ui.browserconfig.BrowserType;

public interface ConfigReader {
	public int getImpliciteWait();

	public int getPageLoadTime();

	public int getExplicitWait();

	public BrowserType getBrowserType();

	public String getUrl();

}
