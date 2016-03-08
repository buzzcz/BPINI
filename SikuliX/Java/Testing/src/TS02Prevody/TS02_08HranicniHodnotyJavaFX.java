package TS02Prevody;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import javax.swing.*;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @author Jaroslav Klaus
 */
public class TS02_08HranicniHodnotyJavaFX {

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
	public void TC02_08_01Nula() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("0");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupM.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/java/vystupLabel.png").right(200).grow(0, 10);
				double vystup = Double.parseDouble(oblast.text());
				assertEquals("Očekávano: " + 0 + ", zjištěno: " + vystup, 0, vystup, 0);
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
	public void TC02_08_02MaxDouble() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1.7e308");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupM.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				Region oblast = s.find("png/java/vystupLabel.png").right(200).grow(0, 10);
				String vystup = oblast.text();
				assertTrue("Očekávano: \"Infinity\", zjištěno: " + vystup, vystup.equals("Infinity"));
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
