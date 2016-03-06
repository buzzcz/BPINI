package TS02Prevody;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
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
public class TS02_01HappyDayScenarioJavaFX {

	static Logger logger;
	static Screen s;
	static App application;
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
	}

	@AfterClass
	public static void tearDownAfterClass() {
		JOptionPane.showMessageDialog(null, "Test Suite dokončen");
	}

	@Before
	public void setUp() {
		try {
			new App("java -jar /home/buzzcz/School/5Semestr/BPINI/Prevodnik/out/artifacts/Prevodnik_jar/Prevodnik" +
					"" +
					".jar").open();
			application = new App("PřeVODNÍK");
			application.focus();
			s.wait("png/java/tlacitkoPreved.png", 10);
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
			s.click("png/java/closeButton.png");
		} catch (FindFailed e) {
			s.capture().save("errors", screenshotName());
			logger.error(e.getMessage());
			fail(e.getMessage());
			s.wait(3);
		}
	}

	@Test
	public void TC02_01_01PrevodPalceNaMm() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupIn.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupMm.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/java/vystupLabel.png").right(150).grow(0, 20);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 25.4 + ", zjištěno: " + vystup, 25.4, vystup, 0.001);
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
	public void TC02_01_02PrevodMetruNaYard() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupM.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupYd.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/java/vystupLabel.png").right(200).grow(0, 20);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 1.0936132983377078 + ", zjištěno: " + vystup, 1.0936132983377078, vystup,
						0.00000000000000001);
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
