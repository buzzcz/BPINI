package TS01StatickePrvky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.Screen;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * @author Jaroslav Klaus
 */
public class SupportJavaFX {

	public static Logger logger;
	public static Screen s;
	public static App application;
	public static boolean linux, run;
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

		Settings.MoveMouseDelay = 0;
		Debug.setLogger(logger);
		Debug.setLoggerAll("info");

		linux = System.getProperty("os.name").equals("Linux");

		if (linux) pngs = "png/linux/java/";
		else pngs = "png/windows/java/";
		s = new Screen();
		try {
			Runtime.getRuntime().exec("java -jar Prevodnik.jar");
			application = new App("PřeVODNÍK");
			application.focus();
			run = true;
			s.wait(pngs + "tlacitka/tlacitkoPreved.png", 10);
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
