package org.softserve.edu.uitest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softserve.edu.uipageobject.pages.HerokuappCheckboxesPage;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class TestHerokuAppCheckboxes extends TestSetup {

    final static Logger LOG = LoggerFactory.getLogger(TestHerokuAppInputs.class);

    @Test(testName = "Tick unchecked checkbox")
    public void tickUncheckedCheckbox() throws InterruptedException {

        LOG.info("Start: Tick unchecked checkbox ");

        HerokuappCheckboxesPage checkboxesPage = new HerokuappCheckboxesPage(getDriver());
        checkboxesPage.navigateToCheckboxesPage().tickCheckbox();

        assertThat(checkboxesPage.isCheckboxChecked()).isTrue();

        LOG.info("Finish: Tick unchecked checkbox ");
    }
}
