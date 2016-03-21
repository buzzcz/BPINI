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
	private static boolean run, runSetup;
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

	@Test
	public void TC03_01_01PrevodOk() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupIn.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupMm.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				s.click(pngs + "tlacitkoVymaz.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Vstupní pole není prázdné", s.find(pngs + "vstupLabel.png").right().grow(0, 20).exists
						(pngs + "vstupniTextovePole.png") != null);
				assertTrue("Výstupní pole není prázdné", s.find(pngs + "vystupLabel.png").right().grow(0, 20).exists
						(pngs + "vystupniTextovePole.png") != null);
				assertTrue("Vstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "vstupLabel.png").right()
						.grow(0, 20).exists(pngs + "vstupniVyberovySeznam.png") != null);
				assertTrue("Výstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "vystupLabel.png").right()
						.grow(0, 20).exists(pngs + "vystupniVyberovySeznam.png") != null);
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
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("abc");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupM.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupM.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chybaNeplatneCislo") != null);

				s.click(pngs + "tlacitkoVymaz.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Vstupní pole není prázdné", s.find(pngs + "vstupLabel.png").right().grow(0, 20).exists
						(pngs + "vstupniTextovePole.png") != null);
				assertTrue("Výstupní pole není prázdné", s.find(pngs + "vystupLabel.png").right().grow(0, 20).exists
						(pngs + "vystupniTextovePole.png") != null);
				assertTrue("Vstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "vstupLabel.png").right()
						.grow(0, 20).exists(pngs + "vstupniVyberovySeznam.png") != null);
				assertTrue("Výstupní výběrový seznam nemá defaultní hodnotu", s.find(pngs + "vystupLabel.png").right()
						.grow(0, 20).exists(pngs + "vystupniVyberovySeznam.png") != null);
				assertTrue("Nalezeno upozornění o chybě", s.exists(pngs + "chybaNeplatneCislo") == null);
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
