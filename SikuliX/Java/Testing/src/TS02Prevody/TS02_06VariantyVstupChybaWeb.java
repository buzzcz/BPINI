package TS02Prevody;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Jaroslav Klaus
 */
public class TS02_06VariantyVstupChybaWeb extends SupportWeb {

	@Test
	public void TC02_06_01ZaporneCeleCislo() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("-5");
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

				assertTrue("Očekáváno: -5, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystupMinus5.png") != null);
				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chybaZaporneCislo.png") != null);
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
	public void TC02_06_02ZaporneDesetinneCislo() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("-5.1");
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

				assertTrue("Očekáváno: -5.1, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow
						(0, 10).exists(pngs + "vystupMinus5_1.png") != null);
				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chybaZaporneCislo.png") != null);
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
	public void TC02_06_03ZaporneCisloVedeckyFormatKladnyVelkeE() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("-5.1E+1");
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

				assertTrue("Očekáváno: -51, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow(0,
						10).exists(pngs + "vystupMinus51.png") != null);
				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chybaZaporneCislo.png") != null);
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
	public void TC02_06_04ZaporneCisloVedeckyFormatZapornyMaleE() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("-5.1e-1");
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

				assertTrue("Očekáváno: -0.51, zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right(200).grow
						(0, 10).exists(pngs + "vystupMinus0_51.png") != null);
				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chybaZaporneCislo.png") != null);
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
	public void TC02_06_05NevyplnenePole() {
		if (run) {
			try {
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

				assertTrue("Očekáváno: \"\", zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right().grow(0,
						10).exists(pngs + "vystupniTextovePole.png") != null);
				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chybaPrazdnePole.png") != null);
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
	public void TC02_06_06NepovolenyZnakNeboZapis() {
		if (run) {
			try {
				s.find(pngs + "vstupLabel.png").right().grow(0, 20).click(pngs + "vstupniTextovePole.png");
				s.paste("12e");
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

				assertTrue("Očekáváno: \"\", zjištěno něco jiného", s.find(pngs + "vystupLabel.png").right().grow(0,
						10).exists(pngs + "vystupniTextovePole.png") != null);
				assertTrue("Nenalezeno upozornění o chybě", s.exists(pngs + "chybaNeplatneCislo.png") != null);
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
