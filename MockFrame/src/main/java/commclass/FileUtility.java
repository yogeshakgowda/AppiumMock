package commclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtility {
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/Pro.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(Key);
		return value;
	}
}
