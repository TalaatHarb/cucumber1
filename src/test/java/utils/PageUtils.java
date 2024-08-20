package utils;

import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import steps.EbayConstants;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageUtils {

	private static final Map<String, String> PAGES = Map.of(
			"Home",EbayConstants.HOME_PAGE_URL,
			"Advanced search", EbayConstants.ADVANCED_SEARCH_PAGE_URL
			);
	
	public static final String mapPageNameToURL(String pageName) {
		return PAGES.get(pageName);
	}
}
