package frameworkConstants;


public final class Path {

	private Path()
	{

	}
	private static final String userdirpath=System.getProperty("user.dir");
	private static final String sourcepath=userdirpath+"\\src\\test\\resources";	
 
	private static final String configpath= sourcepath +"\\Config\\Configration.properties";
	private static final int waitTime=30;

	public static int getWaittime() {
		return waitTime;
	}

	public static String getConfigpath() {
		return configpath;
	}

	



}
