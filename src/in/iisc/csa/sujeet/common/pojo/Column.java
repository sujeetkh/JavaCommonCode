package in.iisc.csa.sujeet.common.pojo;

import org.codehaus.jackson.annotate.JsonSetter;

public class Column {
	private String name;
	private String columnType;

	Column() {
		super();
	}

	public Column(String name, String columnType) {
		this.name = name;
		this.columnType = columnType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumnType() {
		return columnType;
	}

	@JsonSetter("column_type")
	public void setColumnType(String column_type) {
		this.columnType = column_type;
	}
}
