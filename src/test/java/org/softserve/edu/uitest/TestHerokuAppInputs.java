package org.softserve.edu.uitest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softserve.edu.uipageobject.pages.HerokuappInputPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestHerokuAppInputs extends TestSetup {

    final static Logger LOG = LoggerFactory.getLogger(TestHerokuAppInputs.class);

    @Test(testName = "Input valid data to input field ")
    public void inputValidDataIntoInputFieldTest() {

        LOG.info("Start: Input valid data to input field ");

        HerokuappInputPage inputPage = new HerokuappInputPage(getDriver());
        inputPage.navigateToInputsPage()
                .setInputText("1234");

       assertThat(inputPage.getTextFromInput()).isEqualTo( "1234");

        LOG.info("Finish: Input valid data to input field ");
    }
}
