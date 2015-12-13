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

import static org.junit.Assert.*;


/**
 * @author Jaroslav Klaus
 */
public class Test01 {

	static Logger logger;
	static ErrorCollector collector;
	static Screen s;
	//static Region r;  //Prozatim k nicemu nepotrebne
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
		chrome = new App("Chrome"); //V Linuxu se nejspise aplikace spousti pres skript a pak se jmenuje jinak
		//r = chrome.waitForWindow(10);   //V Linuxu zatim nefunkcni
		chrome.focus();
		run = true;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		JOptionPane.showMessageDialog(null, "Script dokončen");
		//chrome.close(); //V Linuxu zatim nefunkcni, nejspise chyba v LinuxUtils
	}

	@Before
	public void setUp() {
		try {
			s.wait("png/addressBar.png", 10);
			s.click(new Pattern("png/addressBar.png").targetOffset(100, 0));
			s.paste("http://oks.kiv.zcu.cz/Prevodnik");
			s.type(Key.ENTER);
			s.wait("png/zalozkaPrevodnik.png", 5);
		} catch (Exception e) {
			run = false;

			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
		}
	}

	@Test
	public void testPorovnejText() {
		if (run) {
			try {
				s.click("png/zalozkaPrevodnik.png");
				s.wait("png/tlacitkoPreved.png", 5);
				s.paste("png/vstup.png", "1");
				Match m = s.find("png/jednotky.png");
				m.setTargetOffset(-27, -18);
				m.click();
				s.findText("(metr)").click();
				s.click(new Pattern("png/jednotky.png").targetOffset(-27, 18));
				s.find("png/dm.png").click();
				s.click("png/tlacitkoPreved.png");
				String t = s.find("png/vystup.png").right(100).text();
				assertEquals(10, Double.parseDouble(t), 0.01);
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
	public void testPorovnejObraz() {
		if (run) {
			try {
				s.click("png/zalozkaPrevodnik.png");
				s.wait("png/tlacitkoPreved.png", 5);
				s.paste("png/vstup.png", "1");
				s.click(new Pattern("png/jednotky.png").targetOffset(-27, -18));
				s.click("png/inch.png");
				s.click("png/tlacitkoPreved.png");
				assertTrue(s.exists("png/vysledek.png") != null);
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
	public void testZkontrolujOdkazObrazekKiv() {
		if (run) {
			try {
				s.click("png/logoKiv.png");
				assertTrue(s.exists("png/zahlaviKiv.png") != null);
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
	public void testChyba() {
		if (run) {
			try {
				s.wait("png/tlacitkoPreved.png", 5);
				s.paste("png/vstup.png", "1");
				s.click(new Pattern("png/jednotky.png").targetOffset(-27, -18));
				s.findText("(metr)").click();
				s.click("png/tlacitkoPreved.png");
				String t = s.find("png/vystup.png").right(100).text();
				assertEquals(100, Double.parseDouble(t), 0.01);
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
