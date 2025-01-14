import java.util.*;

public class mail {
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	private String password;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "xyzcompany.com";
	
	// constructor to receive the firstName and lastName
	public mail(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;		
	        //	System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		// call a method asking for the department, returning the 
		this.department = setDepartment();
		   // System.out.println("Department selected: "+ this.department);
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: "+ this.password);
		
		// combines elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." +companySuffix;  
		   //System.out.println("Your email is: "+ email);
	}
	
	// ask for the department
	private String setDepartment() {
		System.out.print("New Worker: " + firstName + " " + lastName + "\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code: ");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		
		if(depChoice == 1) { return "Sales"; }
		else if(depChoice == 2) { return "Development"; }
		else if(depChoice == 3) { return "Accounting"; }
		else { return ""; }
		
		
	}
	
	// generate a random password
	private String randomPassword(int length){
		String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] pass = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passSet.length());
			pass[i] = passSet.charAt(rand);
		}
		return new String(pass);
	}
	
	// set the mailboxCapacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;	
	}
	
	// set the alternateEmail
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;	
	}
	
	//change the password
	public void changePass(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
     public String showInfo() {
    	 return "DISPLAY NAME: "+ firstName + " " + lastName +
    			 "\nCOMPANY EMAIL: " + email + 
    			 "\nMAILBOX CAPACITY: "+ mailboxCapacity + " mb";
    	 
     }
     	public static void main(String[] args) {

		mail em1 = new mail("Kit","Harrington");
		System.out.println(em1.showInfo());
	}

}
