package jd2section2project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContactManagement {
	

	private Map<String, Contact> contacts;

	public ContactManagement() {

		this.contacts = new HashMap<>();
	}
	public Map<String, Contact> list(){
		
		contacts.forEach((s, contact) -> System.out.println(
	                "  Adı  " + contact.getContactName() + 
	                "   Soyadı "+ contact.getContactSurName() +
	                        "  Telefon Numarası " + contact.getTelephoneNumber() +
	                        " e mail " + contact.geteMail() + 
	                        "   Kimliği " + contact.getId()));
				
		return contacts;
	}
	
	  public void geriYuklemeList(Map<String, Contact> contactV2) {
		  contacts =contactV2;
	    }
	
	  public void delete(Contact contact) {
		  contacts.remove(contact.getId());
		  System.out.println(" Kişi-Numara Silindi ");
	  }
	  
	  public Optional<Contact> findContact(String telephoneNumber){
		  Optional<Contact> personFound= contacts.values().stream().filter(contact -> contact.getTelephoneNumber().equals(telephoneNumber)).findFirst();
		  
		  if(personFound.isPresent()) {
			  System.out.println("Kontak bulundu: " + personFound.get());
		  }else {
			   System.out.println("Kontak bulunamadı.");
		  }
		  return personFound;
	  }
	
	  
	  public void updateContact(Contact updateContact, String phoneNumber) {
	        try {
	            List<Contact> updateContacts = contacts.values().stream().filter(contact -> contact.equals(phoneNumber) )
	                    .peek(contact -> {
	                    	contact.setContactName(updateContact.getContactName());
	                    	contact.setContactSurName(updateContact.getContactSurName());
	                    	contact.setTelephoneNumber(updateContact.getTelephoneNumber());
	                    	contact.seteMail(updateContact.geteMail());
	                    
	                    }).toList();
	            System.out.println("İlgili Kayıt güncellendi.");
	            updateContacts.forEach(contact -> contact.toString());
	        } catch (Exception e) {
	            System.out.println("Kayıti bulunmamaktadır.");
	        }

	    }
	  public void restoreList(Map<String, Contact> pcontactsV2) {
	        contacts = pcontactsV2;
	    }
	
	  public void add(Contact contact) {
		  contacts.put(contact.getId(), contact);
	        System.out.println("Contact eklendi.");
	    }
	  
	  
	
	
}
