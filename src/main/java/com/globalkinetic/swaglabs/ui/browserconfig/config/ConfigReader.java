package com.globalkinetic.swaglabs.ui.browserconfig.config;

import com.globalkinetic.swaglabs.ui.browserconfig.BrowserType;

/**
 * 
 * @author rao saqib
 *
 */
public interface ConfigReader {

	public int getImpliciteWait();

	public int getPageLoadTime();

	public int getExplicitWait();

	public BrowserType getBrowserType();

	public String getUrl();
	public String cartpagheader();
	public String homepageheader();
	
	public String getAppTitle();

}
