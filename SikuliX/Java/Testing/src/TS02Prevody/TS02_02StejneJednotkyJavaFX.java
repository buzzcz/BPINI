package TS02Prevody;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_02StejneJednotkyJavaFX extends SupportJavaFX {
	@Test
	public void TC02_02_01PrevodCmNaCm() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupModryCm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupModryCm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup3.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupDm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupDm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup3.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupFt.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupFt.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup3.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupIn.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup3.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("3");
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
				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup3.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupMm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupMm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup3.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("3");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupYd.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupYd.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup3.png") != null);
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