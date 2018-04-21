package in.iisc.csa.sujeet.common.xml;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import in.iisc.csa.sujeet.common.pojo.Config;

public class ReadConfig {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		XmlMapper xmlMapper = new XmlMapper();
		String xmlString="<Config><value1>1</value1><value2>2</value2></Config>";
		Config config=xmlMapper.readValue(xmlString, Config.class);
		System.out.println(config.getValue1());
		System.out.println(config.getValue2());
	}
}
