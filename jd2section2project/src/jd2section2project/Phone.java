package jd2section2project;

import java.util.Map;

public class Phone {

	private String brand;
	private String model;
    private  String serialNoName;
    private String storage;
    private String os;
    private Map<String,App> apps;
    
    
    
	public Phone(String brand, String model, String serialNoName, String storage, String os) {
		super();
		this.brand = brand;
		this.model = model;
		this.serialNoName = serialNoName;
		this.storage = storage;
		this.os = os;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getSerialNoName() {
		return serialNoName;
	}



	public void setSerialNoName(String serialNoName) {
		this.serialNoName = serialNoName;
	}



	public String getStorage() {
		return storage;
	}



	public void setStorage(String storage) {
		this.storage = storage;
	}



	public String getOs() {
		return os;
	}



	public void setOs(String os) {
		this.os = os;
	}



	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", model=" + model + ", serialNoName=" + serialNoName + ", storage=" + storage
				+ ", os=" + os + ", getBrand()=" + getBrand() + ", getModel()=" + getModel() + ", getSerialNoName()="
				+ getSerialNoName() + ", getStorage()=" + getStorage() + ", getOs()=" + getOs() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



	public Map<String,App> getApps() {
		return apps;
	}



	public void setApps(Map<String,App> apps) {
		this.apps = apps;
	}

	public void addApp(String serial, App app) {
		apps.put(serial, app);
		
	}
    
    
}
