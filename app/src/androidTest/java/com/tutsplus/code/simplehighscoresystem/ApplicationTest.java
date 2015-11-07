package com.tutsplus.code.simplehighscoresystem;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.tutsplus.code.simplehighscoresystem.HighscoreManager;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
    }

    @Override
    public void testAndroidTestCaseSetupProperly() {
        super.testAndroidTestCaseSetupProperly();
    }

    @LargeTest
    public void testIsUniqueNameandScore() {
        HighscoreManager hm = new HighscoreManager();
        hm.addScore("Bart",240);
        hm.addScore("Marge",300);
        assertTrue(hm.isUniqueNameandScore("Bart12",240));
    }
}