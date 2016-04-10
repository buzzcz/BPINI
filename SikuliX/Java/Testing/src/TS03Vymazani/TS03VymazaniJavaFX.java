package TS03Vymazani;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS03VymazaniJavaFX {
	private static Logger logger;
	private static Screen s;
	private static App application;
	private static boolean linux, run;
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
		if (linux) pngs = "png/linux/java/";
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
			Runtime.getRuntime().exec("java -jar Prevodnik.jar");
			application = new App("PřeVODNÍK");
			application.focus();
			s.wait(pngs + "tlacitka/tlacitkoPreved.png", 10);
			run = true;
		} catch (IOException | FindFailed e) {
			run = false;
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
		}
	}

	@After
	public void tearDown() throws InterruptedException {
		try {
			s.click(pngs + "tlacitka/closeButton.png");
		} catch (FindFailed e) {
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
			fail(e.getMessage());
			s.wait(3);
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