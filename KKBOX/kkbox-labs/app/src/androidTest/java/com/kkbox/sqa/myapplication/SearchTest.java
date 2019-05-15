package com.kkbox.sqa.myapplication;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import com.kkbox.sqa.myapplication.page.KKPage;
import com.kkbox.sqa.myapplication.util.TestBuilder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SearchTest {
    private static final String APP_PACKAGE = "com.skysoft.kkbox.android";
    private static final int TIMEOUT = 5000;
    private static KKPage kkbox;

    private static UiDevice mDevice;

    @BeforeClass
    public static void login() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        kkbox = new TestBuilder()
                .loginViaEmail("demo171018@gmail.com", "1234")
                .disableTrialMessage()
                .launch();
    }

    @Before
    public void setup() {
        kkbox = new TestBuilder().launch();
    }

    @Test
    public void testSearch() {
        // TODO: Uncomment below to use page objects
         kkbox.openSearch().search("linkin park").checkTopResult("Linkin Park (聯合公園)");
    }

    @Test
    public void testSearchArtist() {
        // TODO: Uncomment below to use page objects
         kkbox.openSearch().search("linkin park").checkArtistResult("Linkin Park (聯合公園)");

    }

    @Test
    public void testSearchSong() {
        // TODO: Uncomment below to use page objects
         kkbox.openSearch().search("numb encore").checkSongResult("Numb/Encore");
    }
    @Test
    public void testSearchlyrics() {
        // TODO: Uncomment below to use page objects
        kkbox.openSearch().search("fade").checklyricsResult("吻別");
    }
}