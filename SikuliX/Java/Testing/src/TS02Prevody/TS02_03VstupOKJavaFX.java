package TS02Prevody;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_03VstupOKJavaFX extends SupportJavaFX {

	@Test
	public void TC02_03_01CeleCislo() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("5");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupM.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupM.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 5, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5.png") != null);
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
	public void TC02_03_02DesetinneCisloTecka() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("5.1");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupM.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupM.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
	public void TC02_03_03DesetinneCisloCarka() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("5,1");
				Match hledani = s.find(pngs + "vstupLabel.png").right().grow(0, 20).find(pngs +
						"vstupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vstupM.png");
				hledani = s.find(pngs + "vystupLabel.png").right().grow(0, 20).find(pngs + "vystupniVyberovySeznam" +
						".png");
				hledani.click();
				hledani.below().click(pngs + "vystupM.png");
				s.click(pngs + "tlacitkoPreved.png");
				s.wait(pngs + "tlacitkoPreved.png", 5);

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
	public void TC02_03_04DesetinneCisloAZnamenkoPlus() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("+5.1");
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

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
	public void TC02_03_05VedeckyFormatTeckaAVelkeE() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("0.51E1");
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

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
	public void TC02_03_06VedeckyFormatCarkaAMaleE() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("0,51e1");
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

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
	public void TC02_03_07VedeckyFormatExponentKladny() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("0.51E+1");
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

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
	public void TC02_03_08VedeckyFormatExponentZaporny() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("51.0E-1");
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

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
	public void TC02_03_09VedeckyFormatExponentZapornyZnamenkoKladne() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("+51.0e-1");
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

				assertTrue("Očekáváno: 5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystup5_1.png") != null);
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
