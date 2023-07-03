package jd2section2project;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class AppManagement {

	
    public Map<String, App> apps;


    public AppManagement() {
        apps = new TreeMap<>();
    }

	 
	 
	public void addApp(App app, String appSerialNumber) {
	      apps.put(appSerialNumber, app);
	        System.out.println("Uygulama eklendi.");
	}
   
	
	  public Optional<App> search(String appSerialNumber) {
	        Optional<App> foundApp = apps.values().stream().
	                filter(app -> app.getAppSerialNumber().equalsIgnoreCase(appSerialNumber)).findFirst();
	        if (foundApp.isPresent()) {
	            System.out.println(" Uygulama Bulundu: " + foundApp.get());
	            foundApp.get().getAppName();
	        } else {
	            System.out.println("Uygulama Bulunamadı.");
	        }
	        return foundApp;
	    }
	  public Map<String, App> list() {
	     apps.forEach((s,app ) -> System.out.println("App : " + app.getAppName() + "   App SerialNumber "  + app.getAppSerialNumber() + " App Version " + app.getAppVersion())) ;
	     
	     return apps;

	    }
	  

	    public void restoreList(Map<String, App> appsV2) {
	        apps =appsV2;
	    }
	    public void geriYuklemeList(Map<String, App> appsV2) {
	        apps =appsV2;
	    }
	    public void updateApp(String serialNumber, String newVersion) {
	        apps.computeIfPresent(serialNumber, (key, app) -> {
	            app.setAppVersion(newVersion);
	            return app;
	        });
	        System.out.println("Güncellendi");
	        list();

	    }
}
