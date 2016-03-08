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
import java.time.LocalDateTime;

import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS03_01PrevodOkJavaFX {

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
	public void TC03_01_01PrevodOk() {
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

				s.click("png/java/tlacitkoVymaz.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				s.find("png/java/vstupLabel.png").right().grow(0, 20).find("png/java/vstupniTextovePole.png");
				s.find("png/java/vystupLabel.png").right().grow(0, 20).find("png/java/vystupniTextovePole.png");
				s.find("png/java/vstupLabel.png").right().grow(0, 20).find("png/java/vstupniVyberovySeznam.png");
				s.find("png/java/vystupLabel.png").right().grow(0, 20).find("png/java/vystupniVyberovySeznam.png");
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
