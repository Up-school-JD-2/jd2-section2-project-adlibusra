package jd2section2project;

public class App  {

	private String appName;
	private String appVersion;
	private String appSize;
    private String appSerialNumber;
    
    
	public App(String appName, String appVersion, String appSize, String appSerialNumber) {
		super();
		this.appName = appName;
		this.appVersion = appVersion;
		this.appSize = appSize;
		this.appSerialNumber = appSerialNumber;
	}


	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}


	public String getAppVersion() {
		return appVersion;
	}


	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}


	public String getAppSize() {
		return appSize;
	}


	public void setAppSize(String appSize) {
		this.appSize = appSize;
	}


	public String getAppSerialNumber() {
		return appSerialNumber;
	}


	public void setAppSerialNumber(String appSerialNumber) {
		this.appSerialNumber = appSerialNumber;
	}
	
	
}
