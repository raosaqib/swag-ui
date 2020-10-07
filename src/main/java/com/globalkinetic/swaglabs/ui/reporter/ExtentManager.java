package com.globalkinetic.swaglabs.ui.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.globalkinetic.swaglabs.ui.test.helper.resource.ResourceHelper;

/**
 * 
 * @author rao saqib
 *
 */
public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String location = ResourceHelper.getResourcePath("src/main/resources/reports/extent.html");
			return createInstance(location);
		} else {
			return extent;
		}
	}

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

}
