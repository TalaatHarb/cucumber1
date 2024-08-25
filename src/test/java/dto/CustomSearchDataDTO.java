package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomSearchDataDTO {

	private String keyword;
	private String exclude;
	private String minPrice;
	private String maxPrice;
}
