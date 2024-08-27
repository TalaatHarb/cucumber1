package steps;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EbayConstants {

	public static final String DEFAULT_URL = "https://www.ebay.com";
	public static final String URL_PROPERTY = "site.url";
	public static final String MAIN_URL = System.getProperty(URL_PROPERTY, DEFAULT_URL);
	public static final String ADVANCED_SEARCH_PAGE_URL = MAIN_URL + "/sch/ebayadvsearch";
	public static final String HOME_PAGE_URL = MAIN_URL + "/";
	public static final String AUTO_PAGE = MAIN_URL + "/b/Auto-Parts";
	public static final String ELECTRONICS_PAGE = MAIN_URL + "/b/Electronics";

}
