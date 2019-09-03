package co.com.devco.userinterface.locators;

import co.com.devco.automation.mobile.locator.Locator;

import static co.com.devco.automation.mobile.locator.Locator.locator;

public class YoutubeHomeLocator {
    public static final Locator BUTTON_FIND_VIDEO_LOCATOR = locator().withAndroidXpathStatic("//android.widget.ImageView[@content-desc='Search']").withIosXpathStatic("");
    public static final Locator FIELD_SEARCH_LOCATOR = locator().withAndroidId("com.google.android.youtube:id/search_edit_text").withIosXpathStatic("");
    public static final Locator ITEM_FIRST_VIDEO_LOCATOR = locator().withAndroidXpathStatic("//android.widget.ListView[contains(@resource-id,'com.google.android.youtube:id/results')]/android.widget.LinearLayout[1]/android.widget.TextView").withIosXpathStatic("");

    private YoutubeHomeLocator(){}
}