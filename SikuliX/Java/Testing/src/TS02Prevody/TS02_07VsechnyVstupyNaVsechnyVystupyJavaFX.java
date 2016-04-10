package TS02Prevody;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_07VsechnyVstupyNaVsechnyVystupyJavaFX extends SupportJavaFX {
	@Test
	public void TC02_07_01CmNaCm() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
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
				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupModryCm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupDm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup0_1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupModryCm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupFt.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.03280839895013123, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_032808.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupModryCm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.3937007874015748, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_393700.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupModryCm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.01, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup0_01.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupModryCm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupMm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 10, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup10.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupModryCm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupYd.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.010936132983377079, zjištěno něco jiného", s.find(pngs +
						"labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_010936.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupDm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupModryCm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 10, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup10.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
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
				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupDm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupFt.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.3280839895013123, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_328083.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupDm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3.937007874015748, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup3_937007.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupDm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup0_1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupDm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupMm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 100, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup100.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupDm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupYd.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.109361329833771, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_109361.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupFt.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupModryCm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 30.48, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup30_48.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupFt.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupDm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3.048, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup3_048.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
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
				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupFt.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 12, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup12.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupFt.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.3048, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup0_3048.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupFt.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupMm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 304.8, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup304_8.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupFt.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupYd.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.3333333333333333, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_333333.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupIn.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupModryCm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 2.54, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup2_54.png") != null);
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
				hledani.below().click(pngs + "vyberoveSeznamy/vystupDm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.254, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup0_254.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupIn.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupFt.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.0833333333333333, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_083333.png") != null);
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
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1.png") != null);
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
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.0254, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup0_0254.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
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
				assertTrue("Očekáváno: 25.4, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup25_4.png") != null);
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
				hledani.below().click(pngs + "vyberoveSeznamy/vystupYd.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.0277777777777778, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_027777.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupModryCm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 100, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup100.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupDm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 10, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup10.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupFt.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 3.280839895013123, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup3_280839.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 39.37007874015748, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup39_370078.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
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
				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupMm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 1000, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1000.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupM.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupYd.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 1.0936132983377078, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup1_093613.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupMm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupModryCm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup0_1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupMm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupDm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.01, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup0_01.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupMm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupFt.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.0032808398950131, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_003280.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupMm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.0393700787401575, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_039370.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupMm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.001, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup0_001.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
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
				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupMm.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupYd.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.0010936132983377, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel" +
						".png").right(200).grow(0, 10).exists(pngs + "vystupy/vystup0_001093.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupYd.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupModryCm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 91.44, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup91_44.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupYd.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupDm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 9.144, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup9_144.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupYd.png");
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
	public void TC02_07_46YdNaIn() {
		if (run) {
			try {
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupYd.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupIn.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 36, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup36.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupYd.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupM.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 0.9144, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup0_9144.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs + "textovaPole/vstupniTextovePole.png");
				s.paste("1");
				Match hledani = s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vstupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vstupYd.png");
				hledani = s.find(pngs + "labely/vystupLabel.png").right().grow(0, 20).find(pngs +
						"vyberoveSeznamy/vystupniVyberovySeznam.png");
				hledani.click();
				hledani.below().click(pngs + "vyberoveSeznamy/vystupMm.png");
				s.click(pngs + "tlacitka/tlacitkoPreved.png");
				s.wait(pngs + "tlacitka/tlacitkoPreved.png", 5);
				assertTrue("Očekáváno: 914.4, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right
						(200).grow(0, 10).exists(pngs + "vystupy/vystup914_4.png") != null);
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
				s.find(pngs + "labely/vstupLabel.png").right().grow(0, 20).click(pngs +
						"textovaPole/vstupniTextovePole.png");
				s.paste("1");
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
				assertTrue("Očekáváno: 1, zjištěno něco jiného", s.find(pngs + "labely/vystupLabel.png").right(200)
						.grow(0, 10).exists(pngs + "vystupy/vystup1.png") != null);
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