package utils;

import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageUtils {

	private static final Map<String, String> PAGES = Map.of(
			"Home",EbayConstants.HOME_PAGE_URL,
			"Advanced search", EbayConstants.ADVANCED_SEARCH_PAGE_URL,
			"Auto Parts", EbayConstants.AUTO_PAGE,
			"Electronics", EbayConstants.ELECTRONICS_PAGE
			);
	
	public static final String mapPageNameToURL(String pageName) {
		return PAGES.get(pageName);
	}
}
