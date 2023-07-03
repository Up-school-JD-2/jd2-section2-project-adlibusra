package jd2section2project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PhoneManagement {
	 public Map<String, Phone> phones;
	   Map<String, List<App>> appList ;
	   
	   
	public PhoneManagement() {
		 phones = new HashMap<>();
	       appList=new HashMap<>();
	}
	
	
    public void add(Phone phone) {
        phones.put(phone.getSerialNoName(), phone);
        System.out.println("Telefon eklendi.");
    }
	
	   public boolean find(String serialNumberName) {
		   phones.forEach((s, phone)-> System.out.println(phone.getSerialNoName())); 
		   Optional<Phone> foundPhone = phones.values().stream().
	                filter(phone -> phone.getSerialNoName().equalsIgnoreCase(serialNumberName)).findFirst();
	        if (foundPhone.isPresent()) {
	            System.out.println("Telefon bulundu: " + foundPhone.get());
	            foundPhone.get().getApps();
	        } else {
	            System.out.println("Telefon bulunamadı.");
	        }
	        return foundPhone.isPresent();
		   
	   }
	    public Map<String,Phone> list() {
	        var listString="";


	        for (Phone s : phones.values()){
	            System.out.println("Telefon Modeli: "+ s.getModel());
	            for(List<App> s1:appList.values()){
	                for( App s2:s1){
	                    System.out.println(s2.getAppName());
	                }
	            }
	        }
	        System.out.println("-----------------------------");
	        return  phones;

	    }

	        
	    public void geriYuklemeList(Map<String, Phone> phonesV2) {
	        phones =phonesV2;
	    }
	    public void addApp(String serialNumber, Map<String, App> apps) {


	        Optional<Phone> foundPhone = phones.values().stream().filter(phone -> phone.getSerialNoName().equalsIgnoreCase(serialNumber)).findFirst();

	       

	        appList.put(serialNumber,apps.values().stream().toList());

	            String serialNumber1 = foundPhone.get().getSerialNoName();
	            if (appList.containsKey(serialNumber1)) {
	                List<App> uygulamalar = appList.get(serialNumber);
	                for (App app : uygulamalar) {
	                    foundPhone.get().addApp(serialNumber1,app);
	                    foundPhone.get().getApps().values().forEach( app1 -> System.out.println("ADD APP : "+app1.getAppName()));
	                }

	                System.out.println("LİSTE");

	                for(App app:foundPhone.get().getApps().values()){
	                    System.out.println("Uygulama:" + app.getAppName());
	                }
	        }


	        System.out.println(" App Phone eklendi.");

	    }

	    public void deleteApp(String serialNumber, App app) {
	        Optional<Phone> foundPhone = phones.values().stream().
	                filter(phone -> phone.getSerialNoName().equalsIgnoreCase(serialNumber)).findFirst();

	        foundPhone.get().getApps().remove(app);
	        System.out.println(" App Phone silindi.");

	    }
	    public void calculateStorage() {
	        System.out.println(" Telefonlara Uygulamalar Eklendi.");
	        double sum = appList.values().stream()
	                .mapToDouble(w -> Double.parseDouble(((App) w).getAppSize())).sum();

	        System.out.println("Uygulamaların Toplam Alanı: " + sum);
	        double phoneStorage;
	        for (Phone phone : phones.values()) {
	            phoneStorage = Double.parseDouble(phone.getStorage()) - sum;
	            System.out.println("Telefon Seri Numarası: " + phone.getSerialNoName() + " " + "Kalan Depolama Alanı: " + phoneStorage);
	        }


	    }

	    public void restoreList(Map<String, Phone> phonesV2) {
	        phones = phonesV2;
	    }

	   
}
