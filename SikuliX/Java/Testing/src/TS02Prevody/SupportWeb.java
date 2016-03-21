package TS02Prevody;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import javax.swing.*;
import java.time.LocalDateTime;

import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class SupportWeb {

	public static Logger logger;
	public static Screen s;
	public static App browser;
	public static boolean run, runSetup;
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
			new App("google-chrome").open();
			browser = new App("Chrome");
			browser.focus();
			runSetup = true;
			s.wait(pngs + "addressBar.png", 10);
		} catch (Exception e) {
			runSetup = false;
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
		}
	}

	@AfterClass
	public static void tearDownAfterClass() {
		JOptionPane.showMessageDialog(null, "Test Suite dokončen");
	}

	@Before
	public void setUp() {
		if (runSetup) {
			try {
				s.click(new Pattern(pngs + "addressBar.png").targetOffset(100, 0));
				s.paste("http://oks.kiv.zcu.cz/Prevodnik/Prevodnik");
				s.type(Key.ENTER);
				s.wait(pngs + "tlacitkoPreved.png", 5);
				run = true;
			} catch (FindFailed e) {
				run = false;
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
			}
		} else {
			run = false;
			logger.error("Setup failed");
			fail("Setup before class failed");
		}
	}
}
