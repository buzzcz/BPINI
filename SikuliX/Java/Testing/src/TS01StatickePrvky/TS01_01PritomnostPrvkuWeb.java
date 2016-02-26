package TS01StatickePrvky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import javax.swing.*;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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


	private static String screenshotName() {
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

		collector = new ErrorCollector();
		s = new Screen();

		try {
			new App("google-chrome").open();
			chrome = new App("Chrome");
			chrome.focus();
			run = true;
			s.wait("png/web/addressBar.png", 10);
			s.click(new Pattern("png/web/addressBar.png").targetOffset(100, 0));
			s.paste("http://oks.kiv.zcu.cz/Prevodnik");
			s.type(Key.ENTER);
			s.wait("png/web/zalozkaPrevodnik.png", 5);
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

	@Before
	public void setUp() {
		try {
			s.click("png/web/zalozkaPrevodnik.png");
			s.wait("png/web/tlacitkoPreved.png", 5);
		} catch (Exception e) {
			run = false;
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
		}
	}

	@Test
	public void TC01_01_01LabelVstup() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png");
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				fail(e.getMessage());
			}
		} else {
			run = true;
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}

	@Test
	public void TC01_01_02VstupniTextovePole() {
		if (run) {
			try {
				s.find("png/web/vystupLabel.png");
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				fail(e.getMessage());
			}
		} else {
			run = true;
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}
}
