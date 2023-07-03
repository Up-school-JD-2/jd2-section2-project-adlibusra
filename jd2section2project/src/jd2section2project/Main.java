package jd2section2project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc = new Scanner(System.in);
	        int choice = 0;
	        App app;
	       AppManagement  appManagement = new AppManagement();
	        PhoneManagement phoneManagement = new PhoneManagement();
	        ContactManagement contactManagement = new ContactManagement();
	     
	        printMenu();
	        do {
	            System.out.print("Seçiminiz: ");
	            choice = sc.nextInt(); // \n
	            switch (choice) {
	            case 0 -> {
                    System.out.println("--------------------------------");
                    System.out.println("Brand:");
                    String brandName = sc.next();
                    System.out.println("Model :");
                    String model = sc.next();
                    System.out.println("serial number:");
                    UUID uuid = UUID.randomUUID();
                    String serialNumber = sc.next();
                    System.out.println("Storage Space");
                    String storageSpace = sc.next();
                    System.out.println("OS");
                    String os = sc.next();
                    Phone phone = new Phone(brandName, model, serialNumber, storageSpace, os);
                    phoneManagement.add(phone);
                    phoneManagement.list();
                    System.out.println("--------------------------------");
                }
	            case 1 -> {
                    System.out.println("--------------------------------");
                    phoneManagement.list();
                    System.out.println("--------------------------------");
                }
	            case 2 -> {
                    System.out.println("--------------------------------");
                    UUID uuid = UUID.randomUUID();
                    String uuidAsString = uuid.toString();
                    System.out.println("Contact Name : ");
                    String firstName = sc.next();
                    System.out.println("Last Name :");
                    String lastName = sc.next();
                    System.out.println("Phone Number :");
                    String phoneNumber = sc.next();
                    System.out.println("Email :");
                    String eMail = sc.next();
                    Contact contact = new Contact(uuidAsString, firstName, lastName, phoneNumber, eMail);
                    contactManagement.add(contact);
                    contactManagement.list();
                    System.out.println("--------------------------------");
                }
	            case 3 -> {
                    System.out.println("--------------------------------");
                    contactManagement.list();
                    System.out.println("--------------------------------");
                }
	            case 4 -> {
                    System.out.println("--------------------------------");
                    System.out.println("App Name : ");
                    String appName = sc.next();
                    System.out.println("App Serial Number : ");
                    String appSNumber = sc.next();
                    System.out.println("Version :");
                    sc.nextLine();
                    String version = sc.next();
                    System.out.println("Size");
                    String size = sc.next();
                    app = new App(appName, version, size, appSNumber);
                    appManagement.addApp(app, appSNumber); 
                    System.out.println("--------------------------------");

                }
	            case 5 -> {
                    System.out.println("--------------------------------");
                    System.out.println("Enter Phone Number (search person:");
                    String sphoneNumber = sc.next();
                    Optional<Contact> findPerson = contactManagement.findContact(sphoneNumber);
                    System.out.println("Person Name : ");
                    String firstName = sc.next();
                    System.out.println("Last Name :");
                    String lastName = sc.next();
                    System.out.println("Phone Number :");
                    String phoneNumber = sc.next();
                    System.out.println("Email :");
                    String eMail = sc.next();
                    Contact updatecontact = new Contact(findPerson.get().getId(), firstName, lastName, phoneNumber, eMail);
                    List<Optional<Contact>> findContact = new ArrayList<>();
                    findContact.add(findPerson);
                    contactManagement.updateContact(updatecontact, phoneNumber);
                    System.out.println("--------------------------------");
                }
	            case 6 -> {
                    System.out.println("--------------------------------");
                    appManagement.list();
                    System.out.println("--------------------------------");
                }
	            case 7 -> {
                    System.out.println("--------------------------------");
                    System.out.println("Silinecek  telefon numarasını giriniz");
                    System.out.println("Telefon no:  :");
                    String phoneNumber = sc.next();
                    Optional<Contact> person = contactManagement.findContact(phoneNumber);
                    contactManagement.delete(person.get());
                    System.out.println("--------------------------------");
                }
	            case 8 -> {
                    System.out.println("--------------------------------");
                    System.out.println("Enter App Serial Number : ");
                    String appSerialNumber = sc.next();
                    Optional<App> foundApp = appManagement.search(appSerialNumber);
                    phoneManagement.deleteApp(appSerialNumber, foundApp.get());
                    System.out.println("--------------------------------");
                }
	            case 9 -> {
                    System.out.println("--------------------------------");
                    System.out.println("Güncelleyeceğiniz Uygulamanın Seri Numarasını Giriniz:");
                    String appSerialNumber = sc.next();
                    System.out.println("Güncelleyeceğiniz Uygulamanın Versiyon Numarasını Giriniz:");
                    String appVersionNumber = sc.next();
                    appManagement.updateApp(appSerialNumber, appVersionNumber);
                    System.out.println("--------------------------------");
                }
	                
	                }


	            } while (choice != -1) ;
	        }

	 private static void printMenu () {
         System.out.println("##### Menu #####");
         System.out.println("0: Telefon Ekle");
         System.out.println("1: Telefonları Listele");
         System.out.println("2: Kişileri Ekle");  
         System.out.println("3: Kişileri Listele");
         System.out.println("4: App  ekle");
         System.out.println("5: Kişileri Güncelle");
         System.out.println("6: Uygulama Listesi");
         System.out.println("7: Kişi Sil");
         System.out.println("8: Uygulama Sil");
         System.out.println("9: Uygulama Güncelle");
        


         System.out.println("-1: Çıkış \n\n");
     }
	}


