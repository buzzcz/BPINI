package TS01StatickePrvky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * @author Jaroslav Klaus
 */
public class SupportWeb {
	public static Logger logger;
	public static Screen s;
	public static App browser;
	public static boolean run;
	public static String pngs;

	static {
		System.setProperty("log4j.configurationFile", "log-konfigurace.xml");
	}


	public static String screenshotName() {
		LocalDateTime l = LocalDateTime.now();
		return l.getYear() + "" + l.getMonthValue() + "" + l.getDayOfMonth() + "" + l.getHour() + "" + (l.getMinute()
				< 10 ? "0" + l.getMinute() : l.getMinute()) + "" + l.getSecond() + "";
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		logger = LogManager.getLogger();

		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		Settings.MoveMouseDelay = 0;
		Debug.setLogger(logger);
		Debug.setLoggerAll("info");

		if (System.getProperty("os.name").equals("Linux")) pngs = "png/linux/web/";
		else pngs = "png/windows/web/";
		s = new Screen();
		try {
			if (System.getProperty("os.name").equals("Linux")) new App("google-chrome").open();
			else new App("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe").open();
			browser = new App("Chrome");
			browser.focus();
			run = true;
			s.wait(pngs + "addressBar.png", 10);
			s.click(new Pattern(pngs + "addressBar.png").targetOffset(100, 0));
			s.paste("http://oks.kiv.zcu.cz/Prevodnik/Prevodnik");
			s.type(Key.ENTER);
			s.wait(pngs + "tlacitkoPreved.png", 5);
		} catch (Exception e) {
			run = false;
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
		}
	}

	@AfterClass
	public static void tearDownAfterClass() {
		JOptionPane.showMessageDialog(null, "Test Suite dokončen");
	}
}
