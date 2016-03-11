package TS02Prevody;

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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_04VseNaMetrJavaFX {

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
	public void TC02_04_01PrevodCmNaM() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupModryCm.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.01, zjištěno něco jiného", s.find("png/java/vystupLabel.png").right(200).grow
						(0, 10).exists("png/java/vystup0_01.png") != null);
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
	public void TC02_04_02PrevodDmNaM() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupDm.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.01, zjištěno něco jiného", s.find("png/java/vystupLabel.png").right(200).grow
						(0, 10).exists("png/java/vystup0_01.png") != null);
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
	public void TC02_04_03PrevodFtNaM() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupFt.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.3048, zjištěno něco jiného", s.find("png/java/vystupLabel.png").right(200)
						.grow(0, 10).exists("png/java/vystup0_3048.png") != null);
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
	public void TC02_04_04PrevodInNaM() {
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
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.0254, zjištěno něco jiného", s.find("png/java/vystupLabel.png").right(200)
						.grow(0, 10).exists("png/java/vystup0_0254.png") != null);
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
	public void TC02_04_05PrevodMNaM() {
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
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/java/vystupLabel.png").right(200).grow(0,
						10).exists("png/java/vystup1.png") != null);
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
	public void TC02_04_06PrevodMmNaM() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupMm.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.001, zjištěno něco jiného", s.find("png/java/vystupLabel.png").right(200)
						.grow(0, 10).exists("png/java/vystup0_001.png") != null);
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
	public void TC02_04_07PrevodYdNaM() {
		if (run) {
			try {
				s.find("png/java/vstupLabel.png").right().grow(0, 20).click("png/java/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/java/vstupLabel.png").right().grow(0, 20).find
						("png/java/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/java/vstupYd.png");
				hledani = s.find("png/java/vystupLabel.png").right().grow(0, 20).find
						("png/java/vystupniVyberovySeznam" + ".png");
				hledani.click();
				hledani.below().click("png/java/vystupM.png");
				s.click("png/java/tlacitkoPreved.png");
				s.wait("png/java/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.9144, zjištěno něco jiného", s.find("png/java/vystupLabel.png").right(200)
						.grow(0, 10).exists("png/java/vystup0_9144.png") != null);
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
