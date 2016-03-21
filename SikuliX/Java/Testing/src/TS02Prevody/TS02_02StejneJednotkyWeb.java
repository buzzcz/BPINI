package TS02Prevody;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_02StejneJednotkyWeb extends SupportWeb {

	@Test
	public void TC02_02_01PrevodCmNaCm() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupModryCm.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupModryCm.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup3.png") != null);
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
	public void TC02_02_02PrevodDmNaDm() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupDm.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupDm.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup3.png") != null);
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
	public void TC02_02_03PrevodFtNaFt() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupFt.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupFt.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup3.png") != null);
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
	public void TC02_02_04PrevodInNaIn() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs + "vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupIn.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupIn.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup3.png") != null);
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
	public void TC02_02_05PrevodMNaM() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs + "vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupM.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupM.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup3.png") != null);
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
	public void TC02_02_06PrevodMmNaMm() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs + "vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupMm.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupMm.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup3.png") != null);
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
	public void TC02_02_07PrevodYdNaYd() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs + "vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupYd.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupYd.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup3.png") != null);
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
