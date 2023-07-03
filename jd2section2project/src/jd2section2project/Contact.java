package jd2section2project;

public class Contact  {
	private String id;
	private String contactName;
	private String contactSurName;
	private String  telephoneNumber;
	private String eMail;
	
	
	public Contact(String id,String contactName, String contactSurName, String telephoneNumber, String eMail) {
		this.id=id;
		this.contactName = contactName;
		this.contactSurName = contactSurName;
		this.telephoneNumber = telephoneNumber;
		this.eMail = eMail;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", contactName=" + contactName + ", contactSurName=" + contactSurName
				+ ", telephoneNumber=" + telephoneNumber + ", eMail=" + eMail + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getContactSurName() {
		return contactSurName;
	}


	public void setContactSurName(String contactSurName) {
		this.contactSurName = contactSurName;
	}


	public String getTelephoneNumber() {
		return telephoneNumber;
	}


	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
}
