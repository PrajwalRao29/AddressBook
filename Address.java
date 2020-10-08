import java.util.ArrayList;
import java.util.Scanner;

class AddressBook {
	String BookName;
	ArrayList<Contact> ar = new ArrayList<Contact>();

}

class Contact {
	Scanner sc = new Scanner(System.in);
	String first, last, address, String, city, state, zip, phno, email;

	public boolean equals(Contact o) {
		if (o.first.equalsIgnoreCase(this.first) && o.last.equalsIgnoreCase(this.last)) {
			return true;
		} else {
			return false;
		}
	}

	public void addContact() {

		System.out.println("Enter First Name");
		this.first = sc.next();
		System.out.println("Enter Last Name");
		this.last = sc.next();
		System.out.println("Enter Address");
		this.address = sc.next();
		System.out.println("Enter city");
		this.city = sc.next();
		System.out.println("Enter state");
		this.state = sc.next();
		System.out.println("Enter zip code");
		this.zip = sc.next();
		System.out.println("Enter phone number");
		this.phno = sc.next();
		System.out.println("Enter email");
		this.email = sc.next();
	}

	public void editContact() {
		System.out.println("Enter Address");
		this.address = sc.next();
		System.out.println("Enter city");
		this.city = sc.next();
		System.out.println("Enter state");
		this.state = sc.next();
		System.out.println("Enter zip code");
		this.zip = sc.next();
		System.out.println("Enter phone number");
		this.phno = sc.next();
		System.out.println("Enter email");
		this.email = sc.next();
	}

	public void viewContact() {
		System.out.println("ADDRESS = " + this.address);
		System.out.println("CITY = " + this.city);
		System.out.println("STATE = " + this.state);
		System.out.println("ZIP = " + this.zip);
		System.out.println("PHONE NUMBER =" + this.phno);
		System.out.println("EMAIL =" + this.email);
	}
}

public class Address {

	static boolean checkDuplicate(AddressBook adbook, Contact contact) {
		return (adbook.ar.stream().anyMatch(c -> c.equals(contact)));
	}

	public static void main(String args[]) {
		System.out.println("Welcome to Address Book program");
		Scanner sc = new Scanner(System.in);
		ArrayList<AddressBook> adbook = new ArrayList<AddressBook>();
		int r = 0;
		while (r != 3) {
			System.out.println("1.CREATE ADDRESSBOOK");
			System.out.println("2.ACCESS ADDRESSBOOK");
			System.out.println("3.EXIT APPLICATION");
			r = sc.nextInt();
			AddressBook book;
			switch (r) {
			case 1: {
				System.out.println("Enter the address book name to be created");
				String n = sc.next();
				int key = 0;
				for (int i = 0; i < adbook.size(); i++) {
					if (adbook.get(i).BookName.equalsIgnoreCase(n)) {
						key = 1;
						break;
					}
				}
				if (key == 0) {
					AddressBook b = new AddressBook();
					b.BookName = n;
					b.ar = new ArrayList<Contact>();
					adbook.add(b);
					break;
				} else {
					System.out.println("Address Book Already Exists.");
				}
				break;
			}
			case 2: {
				int key = 0;
				System.out.println("Enter the address book name to be accessed");
				String b = sc.next();
				for (int j = 0; j < adbook.size(); j++) {
					if (adbook.get(j).BookName.equalsIgnoreCase(b)) {
						key = 1;
						int x = 0;
						while (x != 5) {
							System.out.println("1.ADD A CONTACT");
							System.out.println("2.EDIT A CONTACT BASED ON NAME");
							System.out.println("3.VIEW CONTACT DETAILS BASED ON NAME");
							System.out.println("4.DELETE A CONTACT");
							System.out.println("5.EXIT CURRENT ADDRESS BOOK");
							x = sc.nextInt();
							Contact a;
							if (x == 1) {
								a = new Contact();
								a.addContact();
								if (checkDuplicate(adbook.get(j), a)) {
									System.out.println("Contact Details Already Exists");
								} else {
									adbook.get(j).ar.add(a);
								}
							} else if (x == 2) {
								System.out.println("Enter First Name");
								String f = sc.next();
								System.out.println("Enter Last Name");
								String l = sc.next();
								int k = 0, i = 0;
								for (i = 0; i < adbook.get(j).ar.size(); i++) {
									if (adbook.get(j).ar.get(i).first.equalsIgnoreCase(f)
											&& adbook.get(j).ar.get(i).last.equalsIgnoreCase(l)) {
										k = 1;
										break;
									}
								}
								if (k == 0) {
									System.out.println("******No Contact found******");
								} else {
									adbook.get(j).ar.get(i).editContact();
								}
							} else if (x == 3) {
								System.out.println("Enter First Name");
								String f = sc.next();
								System.out.println("Enter Last Name");
								String l = sc.next();
								int k = 0, i = 0;
								for (i = 0; i < adbook.get(j).ar.size(); i++) {
									if (adbook.get(j).ar.get(i).first.equalsIgnoreCase(f)
											&& adbook.get(j).ar.get(i).last.equalsIgnoreCase(l)) {
										k = 1;
										break;
									}
								}
								if (k == 0) {
									System.out.println("******No Contact found******");
								} else {
									adbook.get(j).ar.get(i).viewContact();
								}
							} else if (x == 4) {
								System.out.println("Enter First Name");
								String f = sc.next();
								System.out.println("Enter Last Name");
								String l = sc.next();
								int k = 0;
								for (int i = 0; i < adbook.get(j).ar.size(); i++) {
									if (adbook.get(j).ar.get(i).first.equalsIgnoreCase(f)
											&& adbook.get(j).ar.get(i).last.equalsIgnoreCase(l)) {
										k = 1;
										adbook.get(j).ar.remove(i);
										System.out.println("Contact Deleted");
										break;
									}
								}
								if (k == 0) {
									System.out.println("******No Contact found******");

								}
							} else if (x == 5) {
								break;
							}
						}
						break;
					}
				}
				if (key == 0) {
					System.out.println("******Address Book does not exist*******");
				}
			}
			default:
				break;
			}
		}
	}
}