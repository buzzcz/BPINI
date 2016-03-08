package TS02Prevody;

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

import static org.junit.Assert.*;

/**
 * @author Jaroslav Klaus
 */
public class TS02_06VariantyVstupChybaWeb {

	static Logger logger;
	static Screen s;
	static App browser;
	static boolean run, runSetup;

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
			runSetup = true;
			s.wait("png/web/addressBar.png", 10);
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
				s.click(new Pattern("png/web/addressBar.png").targetOffset(100, 0));
				s.paste("http://oks.kiv.zcu.cz/Prevodnik/Prevodnik");
				s.type(Key.ENTER);
				s.wait("png/web/tlacitkoPreved.png", 5);
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
	public void TC02_06_01ZaporneCeleCislo() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("-5");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + -5 + ", zjištěno: " + vystup, -5, vystup, 0);
				s.find("png/web/chybaZaporneCislo.png");
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
	public void TC02_06_02ZaporneDesetinneCislo() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("-5.1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + -5.1 + ", zjištěno: " + vystup, -5.1, vystup, 0);
				s.find("png/web/chybaZaporneCislo.png");
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
	public void TC02_06_03ZaporneCisloVedeckyFormatKladnyVelkeE() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("-5.1E+1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + -5.1E+1 + ", zjištěno: " + vystup, -5.1E+1, vystup, 0);
				s.find("png/web/chybaZaporneCislo.png");
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
	public void TC02_06_04ZaporneCisloVedeckyFormatZapornyMaleE() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("-5.1e-1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + -5.1e-1 + ", zjištěno: " + vystup, -5.1e-1, vystup, 0);
				s.find("png/web/chybaZaporneCislo.png");
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
	public void TC02_06_05NevyplnenePole() {
		if (run) {
			try {
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				String vystup = oblast.text();
				assertTrue("Očekáváno: \"\", zjištěno \"" + vystup + "\"", vystup.equals(""));
				s.find("png/web/chybaPrazdnePole.png");
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
	public void TC02_06_06NepovolenyZnakNeboZapis() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("12e");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				String vystup = oblast.text();
				assertTrue("Očekáváno: \"\", zjištěno \"" + vystup + "\"", vystup.equals(""));
				s.find("png/web/chybaNeplatneCislo.png");
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
