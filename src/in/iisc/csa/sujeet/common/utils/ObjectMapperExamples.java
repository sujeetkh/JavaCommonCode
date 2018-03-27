package in.iisc.csa.sujeet.common.utils;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import in.iisc.csa.sujeet.common.pojo.Column;

public class ObjectMapperExamples {
	public static void readStringJsonIntoMap() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String log = "{\"c\": 0, \"fu\": \"U8EaQwVlgpgtS\", \"cts\": 15174315, \"av\": \"android-5.5.1\", \"ov\": \"6.0.1\", \"os_ver\": 23}";
		Map<?, ?> values = mapper.readValue(log, Map.class);
		for (Map.Entry<?, ?> val : values.entrySet())
			System.out.println(val.getKey() + " : " + val.getValue());
	}

	public static void readSchemaFromString() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String schema = "[{\"name\":\"col1\",\"column_type\":\"TIMESTAMP\"},{\"name\":\"col2\",\"column_type\":\"STRING\"},{\"name\":\"col3\",\"column_type\":\"STRING\"},{\"name\":\"col4\",\"column_type\":\"STRING\"},{\"name\":\"col5\",\"column_type\":\"STRING\"}]";
		Column[] columns = mapper.readValue(schema, Column[].class);
		for (Column col : columns)
			System.out.println(col.getName() + ":" + col.getColumnType());

	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		readSchemaFromString();
	}
}
