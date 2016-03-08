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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_05VseZMetruWeb {

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
	public void TC02_05_01PrevodMNaCm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupModryCm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 100 + ", zjištěno: " + vystup, 100, vystup, 0);
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
	public void TC02_05_02PrevodMNaDm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupDm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 10 + ", zjištěno: " + vystup, 10, vystup, 0);
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
	public void TC02_05_03PrevodMNaFt() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupFt.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 3.2808398950131235 + ", zjištěno: " + vystup, 3.2808398950131235, vystup,
						0);
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
	public void TC02_05_04PrevodMNaIn() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupIn.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 39.37007874015748 + ", zjištěno: " + vystup, 39.37007874015748, vystup,
						0);
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
	public void TC02_05_05PrevodMNaM() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
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
				assertEquals("Očekávano: " + 1 + ", zjištěno: " + vystup, 1, vystup, 0);
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
	public void TC02_05_06PrevodMNaMm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupMm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 1000 + ", zjištěno: " + vystup, 1000, vystup, 0);
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
	public void TC02_05_07PrevodMNaYd() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupM.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupYd.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/web/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 1.0936132983377078 + ", zjištěno: " + vystup, 1.0936132983377078, vystup,
						0);
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
