package in.iisc.csa.sujeet.common.yaml;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import in.iisc.csa.sujeet.common.pojo.Config;

public class ReadConfigFile {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		File f = new File("/Users/admin/eclipse-workspace/JavaCommonCode/resources/config.yaml");
		Config config = mapper.readValue(f, Config.class);
		System.out.println(config.getValue1() + " : " + config.getValue2() + " : " + config.getValue3());
	}

}
