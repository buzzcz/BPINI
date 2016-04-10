package TS03Vymazani;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
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
public class TS03VymazaniWeb {

	private static Logger logger;
	private static Screen s;
	private static App browser;
	private static boolean linux, run, runSetup;
	private static String pngs;

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

		linux = System.getProperty("os.name").equals("Linux");

		if (linux) pngs = "png/linux/web/";
		else pngs = "png/windows/web/";
		s = new Screen();
		try {
			if (linux) new App("google-chrome").open();
			else new App("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe").open();
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
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
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

	@Test
	public void TC03_01_01PrevodOk() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupIn.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupMm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				s.click(pngs + "tlacitka/tlacitkoVymaz.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Vstupní pole není prázdné", s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20)
						.exists(pngs + "textovaPole/vstupniTextovePole.png") != null);
				assertTrue("Výstupní pole není prázdné", s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20)
						.exists(pngs + "textovaPole/vystupniTextovePole.png") != null);
				assertTrue("Vstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "labely/vstupLabel.png")
						.right().grow(0, 20).exists(pngs + "vyberoveSeznamy/vstupniVyberovySeznam.png") != null);
				assertTrue("Výstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "labely/vystupLabel.png")
						.right().grow(0, 20).exists(pngs + "vyberoveSeznamy/vystupniVyberovySeznam.png") != null);
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
	public void TC03_01_02PrevodChyba() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("abc");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chyby/chybaNeplatneCislo") != null);
				s.click(pngs + "tlacitka/tlacitkoVymaz.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Vstupní pole není prázdné", s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20)
						.exists(pngs + "textovaPole/vstupniTextovePole.png") != null);
				assertTrue("Výstupní pole není prázdné", s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20)
						.exists(pngs + "textovaPole/vystupniTextovePole.png") != null);
				assertTrue("Vstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "labely/vstupLabel.png")
						.right().grow(0, 20).exists(pngs + "vyberoveSeznamy/vstupniVyberovySeznam.png") != null);
				assertTrue("Výstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "labely/vystupLabel.png")
						.right().grow(0, 20).exists(pngs + "vyberoveSeznamy/vystupniVyberovySeznam.png") != null);
				assertTrue("Nalezeno upozornění o chybě", s.exists(pngs + "chyby/chybaNeplatneCislo") == null);
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
