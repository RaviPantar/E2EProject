package frameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadProperty {

	private ReadProperty()
	{

	}
	private static Properties prop=new Properties();
	private static final Map<String,String> configmap=new HashMap<String,String>();

	static {
		try(FileInputStream file =new FileInputStream(Path.getConfigpath()))
		{
			
			prop.load(file);
			for(Object key:prop.keySet())
			{
				configmap.put(String.valueOf(key), String.valueOf(prop.get(key)));
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static String get(String key) throws Exception
	{
		if(Objects.isNull(key)||Objects.isNull(configmap.get(key))) 
		{
			throw new Exception("Property name"+key+"is not found"+"Please check config properties");
		}
		return configmap.get(key);
	}
	public static String getValue(String key) throws Exception
	{
		//String value, value=prop.getProperty(key);
		if(Objects.isNull(prop.getProperty(key))||Objects.isNull(key))                                             //if(value==null)
		{
			throw new Exception("Property name"+key+"is not found"+"Please check config properties");
		}
		return prop.getProperty(key);

	}
}
