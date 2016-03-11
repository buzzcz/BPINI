package TS01StatickePrvky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import javax.swing.*;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS01_02EditovatelnostPoliWeb {

	static Logger logger;
	static Screen s;
	static App browser;
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

		s = new Screen();
		try {
			new App("google-chrome").open();
			browser = new App("Chrome");
			browser.focus();
			run = true;
			s.wait("png/web/addressBar.png", 10);
			s.click(new Pattern("png/web/addressBar.png").targetOffset(100, 0));
			s.paste("http://oks.kiv.zcu.cz/Prevodnik/Prevodnik");
			s.type(Key.ENTER);
			s.wait("png/web/tlacitkoPreved.png", 5);
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

	@Test
	public void TC01_02_01VstupniTextovePole() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).paste("png/web/vstupniTextovePole.png", "vstup");
				s.find("png/web/vstupLabel.png").right().grow(0, 20).find("png/web/editovatelnostVstupnihoPole.png");
				assertTrue("Vstupní textové pole není editovatelné", s.find("png/web/vstupLabel.png").right().grow(0,
						20).exists("png/web/vstupVstup.png") != null);
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				fail(e.getMessage());
			}
		} else {
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}

	@Test
	public void TC01_02_02VystupniTextovePole() {
		if (run) {
			try {
				s.find("png/web/vystupLabel.png").right().grow(0, 20).paste("png/web/vystupniTextovePole.png",
						"vstup");
				assertTrue("Výstupní textové pole je editovatelné", s.find("png/web/vystupLabel.png").right().grow(0,
						20).exists("png/web/vystupniTextovePole.png") != null);
			} catch (FindFailed | AssertionError e) {
				s.capture().save("errors", screenshotName());
				logger.error(e.getMessage());
				fail(e.getMessage());
			}
		} else {
			logger.error("Setup failed");
			fail("Setup failed");
		}
	}
}
