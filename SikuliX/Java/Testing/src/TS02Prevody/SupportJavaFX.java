package TS02Prevody;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import javax.swing.*;
import java.time.LocalDateTime;

import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class SupportJavaFX {
	public static Logger logger;
	public static Screen s;
	public static App application;
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

		if (System.getProperty("os.name").equals("Linux")) pngs = "png/linux/java/";
		else pngs = "png/windows/java/";
		s = new Screen();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		JOptionPane.showMessageDialog(null, "Test Suite dokončen");
	}

	@Before
	public void setUp() {
		try {
			new App("java -jar Prevodnik.jar").open();
			application = new App("PřeVODNÍK");
			application.focus();
			s.wait(pngs + "tlacitkoPreved.png", 10);
			run = true;
		} catch (FindFailed e) {
			run = false;
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
		}
	}

	@After
	public void tearDown() throws InterruptedException {
		try {
			s.click(pngs + "closeButton.png");
		} catch (FindFailed e) {
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
			fail(e.getMessage());
			s.wait(3);
		}
	}
}
