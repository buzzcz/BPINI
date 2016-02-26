package TS01StatickePrvky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.rules.ErrorCollector;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.Screen;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * @author Jaroslav Klaus
 */
public class TS01_01PritomnostPrvkuWeb {

	static Logger logger;
	static ErrorCollector collector;
	static Screen s;
	static App chrome;
	static boolean run;

	static {
		System.setProperty("log4j.configurationFile", "log-konfigurace.xml");
	}


	private String screenshotName() {
		LocalDateTime l = LocalDateTime.now();
		return l.getYear() + "" + l.getMonthValue() + "" + l.getDayOfMonth() + "" + l.getHour() + "" + (l.getMinute()
				< 10 ? "0" + l.getMinute() : l.getMinute()) + "" + l.getSecond() + "";
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		logger = LogManager.getLogger();

		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		Debug.setLogger(logger);
		Debug.setLoggerAll("info");

		collector = new ErrorCollector();
		s = new Screen();
		new App("google-chrome").open();
		chrome = new App("Chrome");
		chrome.focus();
		run = true;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		JOptionPane.showMessageDialog(null, "Script dokončen");
	}
}
