package com.kkbox.sqa.myapplication.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;


import static org.junit.Assert.assertTrue;

public class KKSearchPage extends KKPage {
    public static final BySelector SEARCH_FIELD = By.res(APP_PACKAGE, "search_src_text");
    public static final BySelector SEARCH_BUTTON = By.res(APP_PACKAGE, "menu_global_search");
    protected BySelector Song_BUTTON = By.text("歌曲");
    protected BySelector Artist_BUTTON = By.text("歌手");
    protected BySelector lyrics_BUTTON = By.text("歌詞");
    public KKSearchPage(UiDevice device) {
        super(device);
    }

    public KKSearchPage search(String keyword) {
        this.device.wait(Until.findObject(SEARCH_FIELD), TIMEOUT).setText(keyword);
        this.device.pressEnter();

        return this;
    }

    public KKSearchPage checkTopResult(String expectedText) {
        BySelector selector = By.text(expectedText);

        assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));

        return this;
    }
    public KKSearchPage checkSongResult(String except_result){
        this.device.wait(Until.findObject(Song_BUTTON), TIMEOUT).click();
        BySelector selector = By.text(except_result);
        assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));
        return this;
    }
    public KKSearchPage checkArtistResult(String except_result){
        this.device.wait(Until.findObject(Artist_BUTTON), TIMEOUT).click();
        BySelector selector = By.text(except_result);
        assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));
        return this;
    }
    public KKSearchPage checklyricsResult(String except_result){
        this.device.wait(Until.findObject(lyrics_BUTTON), TIMEOUT).click();
        //BySelector selector = By.res(except_result);
        BySelector text_id = By.res(APP_PACKAGE,"label_lyrics");
        String text = this.device.wait(Until.findObject(text_id), TIMEOUT).getText();
        System.out.println(text);
        assertTrue(text.matches("(.*)"+except_result+"(.*)"));
        //assertTrue(this.device.wait(Until.hasObject(selector), TIMEOUT));

        return this;
    }

}