import java.util.Scanner;

public class HW4_4110056015 {

	public static void main(String args[]) {
		SystemManager DB_4110056015 = new SystemManager();
		Scanner scn = new Scanner(System.in);
		String command;
		while (true) {
			System.out.print("Command:");
			command = scn.nextLine();
			/* code here. */
			if (!DB_4110056015.commandCatch(command)) {
				System.out.println("Invaild Command!");
			}
		}
		/* code here. */
		//scn.close();
	}
}

class SystemManager {
	private data[] dataBase;
	private String rootPasswd = "java";

	SystemManager() {
		System.out.println("System is created.");
		dataBase = new data[2];
	}

	boolean commandCatch(String command) {
		/* code here. */
		// commandNameBox CNB = new commandNameBox();

		if (command.contentEquals("quit")) {
			quit();
			return true;
		} else if (command.startsWith("sudo")) {
			sudo(command);
			return true;
		} else if (command.contentEquals("list")) {
			list();
			return true;
		} else if (command.contentEquals("add")) {
			add();
			return true;
		} else if (command.startsWith("passwd")) {
			passwd(command);
			return true;
		} else if (command.startsWith("name")) {
			name(command);
			return true;
		} else {
			return false;
		}
	}
	/*
	 * code here, the name of the function you declare can only be named as the
	 * words in commandNameBox.
	 */

	void sudo(String command) { // is permitted
		Scanner sc = new Scanner(System.in);
		int dBsize = 0;

		if (command.contentEquals("sudo list")) {
			System.out.print("Administrator password:");
			String a = sc.next();
			for (int i = 0; i < dataBase.length; i++) {
				if (dataBase[i] == null)
					break;
				dBsize++;
			}
			if (a.equals("quit")) {
				System.out.println("");
				return;
			} else if (a.equals(rootPasswd)) {
				if (dBsize == 0) {
					System.out.println("NULL\n");
				} else {
					System.out.println("----DataBase-----");
					for (int i = 0; i < dBsize; i++) {
						System.out.print(dataBase[i].showaccount() + " ");
						System.out.print(dataBase[i].showpassword() + " ");
						System.out.println(dataBase[i].showName());
					}
					System.out.println("-----------------");
				}
			} else {
				System.out.println("Input error");
			}

		} else if (command.equals("sudo quit")) {
			while (true) {
				System.out.print("Administrator password:");
				String a = sc.next();
				if (a.equals("quit")) {
					System.out.println("");
					return;
				} else if (a.equals(rootPasswd)) {
					System.out.println("\nBye~");
					System.exit(0);
				}else {
					System.out.println("Input error");
				}
			}
		} else {
			System.out.println("Invalid command!\n");
		}
	}

	void list() {
		System.out.println("Insufficient permissions.\n");
	}

	void add() {
		Scanner sc = new Scanner(System.in);
		String addname = " ", addaccount = " ", addpasswd = " ", addpasswd1 = " ";
		int n = 0, dBsize = 0;

		for (int i = 0; i < dataBase.length; i++) {
			if (dataBase[i] == null)
				break;
			dBsize++;
		}
		while (n == 0) {
			System.out.print("Username:");
			addname = sc.next();
			if (addname.equals("quit")) {
				System.out.println("");
				return;
			}
			if (addname.length() == 0) {
				System.out.println("Invalid username!");
				continue;
			}
			for (int i = 0; i < addname.length(); i++) {
				if (addname.charAt(i) == '.' || addname.charAt(i) == ' ') {
					System.out.println("Invalid username!");
					break;
				} else {
					n = 4;
				}
			}
		}
		while (n == 4) {
			System.out.print("Account:");
			addaccount = sc.next();
			if (addaccount.equals("quit")) {
				System.out.println("");
				return;
			} else if (addaccount.length() == 0) {
				System.out.println("Invalid account!\n");
				continue;
			}
			for (int i = 0; i < addaccount.length(); i++) {
				if (addaccount.charAt(i) == '.' || addaccount.charAt(i) == ' ') {
					System.out.println("Invalid account!\n");
					break;
				} else {
					n = 2;
				}
			}
			if (n == 2) {
				if (dBsize == 0) {
					n = 8;
				} else {
					for (int i = 0; i < dBsize; i++) {
						if (addaccount.equals(dataBase[i].showaccount())) {
							n = 4;
							System.out.println("Account already exists.");
							break;
						} else {
							n = 8;
						}
					}
				}
			}
		}
		while (n == 8) {
			System.out.print("Password:");
			addpasswd = sc.next();
			if (addpasswd.equals("quit")) {
				System.out.println("");
				return;
			} else if (addpasswd.length() == 0) {
				System.out.println("Invalid password!\n");
				continue;
			}
			for (int i = 0; i < addpasswd.length(); i++) {
				if (addpasswd.charAt(i) == '.' || addpasswd.charAt(i) == ' ') {
					System.out.println("Invalid password!\n");
					break;
				} else {
					n = 5;
				}
			}

			if (n == 5) {
				if (dBsize == 0 && !addpasswd.equals(addaccount)) {
				} else {
					for (int i = 0; i < dBsize; i++) {
						if (addpasswd.equals(dataBase[i].showaccount()) || addpasswd.equals(addaccount)) {
							n = 8;
							System.out.println("Error! The password cannot be the same as the account ID.");
							break;
						}
					}
				}
			}
			if (n == 5) {
				n = 9;
				if (addpasswd.length() < 8 || (addpasswd.equals(addpasswd.toUpperCase()) || addpasswd.equals(addpasswd.toLowerCase()))) {
				} else {
					for (int i = 48; i < 58; i++) {
						for (int j = 0; j < addpasswd.length(); j++) {
							if (addpasswd.charAt(j) == i) {
								n = 10;
								break;
							}
						}
					}
				}
			}
			if (n == 9) {
				System.out.println("The password is not strong enough.");
				n = 8;
				continue;
			}
		}
		while (n == 10) {
			System.out.print("Password again:");
			addpasswd1 = sc.next();
			if (addpasswd1.equals("quit")) {
				System.out.println("");
				return;
			}
			if (!addpasswd1.equals(addpasswd)) {
				System.out.println("Input error");
			}else
				n=12;
		}
		
		if (dataBase[0] == null) {
			dataBase[0] = new data();
			dataBase[0].account(addaccount);
			dataBase[0].Name(addname);
			dataBase[0].password(addpasswd);
		} else {
			data[] dataBase1 = new data[dBsize + 1];
			System.arraycopy(dataBase, 0, dataBase1, 0, dBsize);
			dataBase1[dBsize] = new data();
			dataBase1[dBsize].account(addaccount);
			dataBase1[dBsize].Name(addname);
			dataBase1[dBsize].password(addpasswd);
			this.dataBase = dataBase1;
		}
	}

	void passwd(String command) {
		Scanner sc = new Scanner(System.in);
		String newpasswd = " ", newpasswd1 = " ";
		int n = 0, a = -1, dBsize = 0;

		for (int i = 0; i < dataBase.length; i++) {
			if (dataBase[i] == null)
				break;
			dBsize++;
		}
		if (dBsize == 0) {
			n = 0;
		} else {
			for (int i = 0; i < dBsize; i++) {
				if (command.contentEquals("passwd " + dataBase[i].showaccount())) {
					n = 1;
					a = i;
					break;
				}
			}
		}

		if (n == 0) {
			System.out.println("Invalid command!\n");
		} else {
			while (n == 1) {
				System.out.print("Old password:");
				newpasswd = sc.next();
				if (newpasswd.equals("quit")) {
					System.out.println("");
					return;
				}
				if (newpasswd.equals(dataBase[a].showpassword())) {
					n = 8;
				} else {
					System.out.println("Input error");
				}
			}
			while (n == 8) {
				System.out.print("New Password:");
				newpasswd = sc.next();
				if (newpasswd.equals("quit")) {
					System.out.println("");
					return;
				} else if (newpasswd.length() == 0) {
					System.out.println("Invalid password!");
					continue;
				}
				for (int i = 0; i < newpasswd.length(); i++) {
					if (newpasswd.charAt(i) == '.' || newpasswd.charAt(i) == ' ') {
						System.out.println("Invalid password!");
						break;
					} else {
						n = 5;
					}
				}
				if (n == 5) {
					for (int i = 0; i < dBsize; i++) {
						if (newpasswd.equals(dataBase[i].showaccount())) {
							n = 8;
							System.out.println("Error! The password cannot be the same as the account ID.");
							break;
						}
					}
				}
				if (n == 5) {
					n = 9;
					if (newpasswd.length() < 8 || (newpasswd.equals(newpasswd.toUpperCase()) || newpasswd.equals(newpasswd.toLowerCase()))) {
					} else {
						for (int i = 48; i < 58; i++) {
							for (int j = 0; j < newpasswd.length(); j++) {
								if (newpasswd.charAt(j) == i) {
									n = 10;
									break;
								}
							}
						}
					}
				}
				if (n == 9) {
					System.out.println("The password is not strong enough.");
					n = 8;
					continue;
				}
			}
			while (n == 10) {
				System.out.print("New password again:");
				newpasswd1 = sc.next();
				if (newpasswd.equals("quit")) {
					System.out.println("");
					return;
				}
				if (!newpasswd1.equals(newpasswd)) {
					System.out.println("Input error");
				} else {
					dataBase[a].password(newpasswd);
					System.out.println("User " + dataBase[a].showaccount() + "'s password was changed.");
					n = 12;
				}
			}
		}
	}

	void name(String command) {
		Scanner sc = new Scanner(System.in);
		String newname = " ";
		int n = 0, a = -1, dBsize = 0;

		for (int i = 0; i < dataBase.length; i++) {
			if (dataBase[i] == null)
				break;
			dBsize++;
		}
		if (dBsize == 0) {
			n = 0;
		} else {
			for (int i = 0; i < dBsize; i++) {
				if (command.contentEquals("name " + dataBase[i].showaccount())) {
					n = 1;
					a = i;
					break;
				}
			}
		}
		if (n == 0) {
			System.out.println("Invalid command!\n");
		} else {
			while (n == 1) {
				System.out.print("Password:");
				newname = sc.next();
				if (newname.equals("quit")) {
					System.out.println("");
					return;
				}
				if (!newname.equals(dataBase[a].showpassword()))
					System.out.println("Input error");
				else
					n = 4;
			}
			while (n == 4) {
				System.out.print("New Username:");
				newname = sc.next();
				if (newname.equals("quit")) {
					System.out.println("");
					return;
				}
				if (newname.length() == 0) {
					System.out.println("Invalid username!");
					continue;
				}
				for (int i = 0; i < newname.length(); i++) {
					if (newname.charAt(i) == '.' || newname.charAt(i) == ' ') {
						System.out.println("Invalid username!");
						break;
					} else {
						n = 8;
					}
				}
			}
			if (n == 8) {
				dataBase[a].Name(newname);
				System.out.println("User " + dataBase[a].showaccount() + "'s Username was changed.\n");
			}
		}
	}

	void quit() {
		System.out.println("Insufficient permissions.\n");
	}
}

class commandNameBoxPR { // Restricted permissions of commandNameBox
	commandNameBoxPR() {
		System.out.println("permission denied.");
	}
}

class commandNameBox extends commandNameBoxPR {
	/*
	 * code here, only be used to store words which the commands' names used. words:
	 * "sudo","list","add","passwd","name","quit".no other operation.
	 */
	String sudo = "sudo";
	String list = "list";
	String add = "add";
	String passwd = "passwd";
	String name = "name";
	String quit = "quit";
}

class data {
	private String name;
	private String account;
	private String password;

	data() {
		System.out.println("Account is created.");
	}

	/* code here without variable declaration, but Parameter is permitted */
	void Name(String name) {
		this.name = name;
	}

	void account(String account) {
		this.account = account;
	}

	void password(String passwd) {
		this.password = passwd;
	}

	String showName() {
		return name;
	}

	String showaccount() {
		return (account);
	}

	String showpassword() {
		return (password);
	}
}