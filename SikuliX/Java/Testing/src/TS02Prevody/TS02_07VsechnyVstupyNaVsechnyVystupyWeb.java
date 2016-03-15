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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_07VsechnyVstupyNaVsechnyVystupyWeb {

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
	public void TC02_07_01CmNaCm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupModryCm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupModryCm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup1.png") != null);
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
	public void TC02_07_02CmNaDm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupModryCm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupDm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup0_1.png") != null);
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
	public void TC02_07_03CmNaFt() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupModryCm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupFt.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.03280839895013123, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_032808.png") != null);
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
	public void TC02_07_04CmNaIn() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupModryCm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupIn.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.3937007874015748, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_393700.png") != null);
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
	public void TC02_07_05CmNaM() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupModryCm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.01, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup0_01.png") != null);
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
	public void TC02_07_06CmNaMm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupModryCm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupMm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 10, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup10.png") != null);
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
	public void TC02_07_07CmNaYd() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupModryCm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupYd.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.010936132983377079, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_010936.png") != null);
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
	public void TC02_07_08DmNaCm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupDm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupModryCm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 10, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup10.png") != null);
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
	public void TC02_07_09DmNaDm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupDm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupDm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup1.png") != null);
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
	public void TC02_07_10DmNaFt() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupDm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupFt.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.3280839895013123, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_328083.png") != null);
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
	public void TC02_07_11DmNaIn() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupDm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupIn.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3.937007874015748, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup3_937007.png") != null);
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
	public void TC02_07_12DmNaM() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupDm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup0_1.png") != null);
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
	public void TC02_07_13DmNaMm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupDm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupMm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 100, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup100.png") != null);
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
	public void TC02_07_14DmNaYd() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupDm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupYd.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.109361329833771, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_109361.png") != null);
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
	public void TC02_07_15FtNaCm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupFt.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupModryCm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 30.48, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup30_48.png") != null);
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
	public void TC02_07_16FtNaDm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupFt.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupDm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3.048, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup3_048.png") != null);
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
	public void TC02_07_17FtNaFt() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupFt.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupFt.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup1.png") != null);
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
	public void TC02_07_18FtNaIn() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupFt.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupIn.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 12, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup12.png") != null);
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
	public void TC02_07_19FtNaM() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupFt.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.3048, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200)
						.grow(0, 10).exists("png/web/vystup0_3048.png") != null);
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
	public void TC02_07_20FtNaMm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupFt.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupMm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 304.8, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup304_8.png") != null);
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
	public void TC02_07_21FtNaYd() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupFt.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupYd.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.3333333333333333, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_333333.png") != null);
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
	public void TC02_07_22InNaCm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupIn.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupModryCm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 2.54, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup2_54.png") != null);
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
	public void TC02_07_23InNaDm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupIn.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupDm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.254, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup0_254.png") != null);
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
	public void TC02_07_24InNaFt() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupIn.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupFt.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.0833333333333333, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_083333.png") != null);
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
	public void TC02_07_25InNaIn() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupIn.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupIn.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup1.png") != null);
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
	public void TC02_07_26InNaM() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupIn.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.0254, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200)
						.grow(0, 10).exists("png/web/vystup0_0254.png") != null);
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
	public void TC02_07_27InNaMm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupIn.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupMm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 25.4, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup25_4.png") != null);
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
	public void TC02_07_28InNaYd() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupIn.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupYd.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.0277777777777778, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_027777.png") != null);
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
	public void TC02_07_29MNaCm() {
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

				assertTrue("Očekáváno: 100, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup100.png") != null);
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
	public void TC02_07_30MNaDm() {
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

				assertTrue("Očekáváno: 10, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup10.png") != null);
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
	public void TC02_07_31MNaFt() {
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

				assertTrue("Očekáváno: 3.280839895013123, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup3_280839.png") != null);
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
	public void TC02_07_32MNaIn() {
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

				assertTrue("Očekáváno: 39.37007874015748, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup39_370078.png") != null);
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
	public void TC02_07_33MNaM() {
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

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup1.png") != null);
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
	public void TC02_07_34MNaMm() {
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

				assertTrue("Očekáváno: 1000, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup1000.png") != null);
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
	public void TC02_07_35MNaYd() {
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

				assertTrue("Očekáváno: 1.0936132983377078, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup1_093613.png") != null);
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
	public void TC02_07_36MmNaCm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupMm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupModryCm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup0_1.png") != null);
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
	public void TC02_07_37MmNaDm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupMm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupDm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.01, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup0_01.png") != null);
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
	public void TC02_07_38MmNaFt() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupMm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupFt.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.0032808398950131, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_003280.png") != null);
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
	public void TC02_07_39MmNaIn() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupMm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupIn.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.0393700787401575, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_039370.png") != null);
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
	public void TC02_07_40MmNaM() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupMm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.001, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup0_001.png") != null);
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
	public void TC02_07_41MmNaMm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupMm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupMm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup1.png") != null);
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
	public void TC02_07_42MmNaYd() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupMm.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupYd.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.0010936132983377, zjištěno něco jiného", s.find("png/web/vystupLabel.png")
						.right(200).grow(0, 10).exists("png/web/vystup0_001093.png") != null);
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
	public void TC02_07_43YdNaCm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupYd.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupModryCm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 91.44, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup91_44.png") != null);
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
	public void TC02_07_44YdNaDm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupYd.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupDm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 9.144, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup9_144.png") != null);
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
	public void TC02_07_45YdNaFt() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupYd.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupFt.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup3.png") != null);
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
	public void TC02_07_46YdNaIn() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupYd.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupIn.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 36, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup36.png") != null);
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
	public void TC02_07_47YdNaM() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupYd.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupM.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 0.9144, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200)
						.grow(0, 10).exists("png/web/vystup0_9144.png") != null);
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
	public void TC02_07_48YdNaMm() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupYd.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupMm.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 914.4, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow
						(0, 10).exists("png/web/vystup914_4.png") != null);
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
	public void TC02_07_49YdNaYd() {
		if (run) {
			try {
				s.find("png/web/vstupLabel.png").right().grow(0, 20).click("png/web/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find("png/web/vstupLabel.png").right().grow(0, 20).find
						("png/web/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click("png/web/vstupYd.png");
				hledani = s.find("png/web/vystupLabel.png").right().grow(0, 20).find("png/web/vystupniVyberovySeznam"
						+ ".png");
				hledani.click();
				hledani.below().click("png/web/vystupYd.png");
				s.click("png/web/tlacitkoPreved.png");
				s.wait("png/web/tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find("png/web/vystupLabel.png").right(200).grow(0,
						10).exists("png/web/vystup1.png") != null);
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
