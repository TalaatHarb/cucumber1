package mappers;

import java.util.Map;

import dto.CustomSearchDataDTO;
import io.cucumber.java.DataTableType;

public class DataTableToSearchDataMapper {
	
	@DataTableType
	public CustomSearchDataDTO mapFromDataTable(Map<String, String> row) {
		return CustomSearchDataDTO.builder()
				.keyword(row.get("keyword"))
				.exclude(row.get("exclude"))
				.minPrice(row.get("minPrice"))
				.maxPrice(row.get("maxPrice"))
				.build();
	}

}
