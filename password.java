import java.util.Scanner;
import java.security.SecureRandom;

public class ComplexPasswordGenerator {
  static Scanner sc = new Scanner(System.in);
  static SecureRandom random = new SecureRandom();
  
  static String[] options = {"Lowercase letters", "Uppercase letters", "Numbers", "Special characters"};
  static String specialChars = "!@#$%^&*_+-=[]{}|,.<>?";
  
  public static void main(String[] args) {
  while (true) {
    System.out.println("\nComplex Password Generator");
    System.out.println("1. Generate password");
    System.out.println("2. Show character options");
    System.out.println("3. Change special characters");
    System.out.println("4. Change password length");
    System.out.println("5. Show password history");
    System.out.println("6. Check password strength");
    System.out.println("7. Save password to file");
    System.out.println("8. Load password from file");
    // A implementar en un futuro
    // System.out.println("9. Change password generation algorithm");
    System.out.println("10. Exit");
    System.out.print("\nEnter option number: ");
    int choice = sc.nextInt();
    if (choice == 1) {
      generatePassword();
    } else if (choice == 2) {
      showCharacterOptions();
    } else if (choice == 3) {
      changeSpecialCharacters();
    } else if (choice == 4) {
      changePasswordLength();
    } else if (choice == 5) {
      showPasswordHistory();
    } else if (choice == 6) {
      checkPasswordStrength();
    } else if (choice == 7) {
      savePasswordToFile();
    } else if (choice == 8) {
      loadPasswordFromFile();
    } else if (choice == 9) {
      changePasswordGenerationAlgorithm();
    } else if (choice == 10) {
      break;
    } else {
      System.out.println("Invalid choice. Try again.");
    }
  }
}
  static void generatePassword() {
    System.out.print("Enter password length: ");
    int length = sc.nextInt();
    System.out.println("\nChoose character types to include in the password:");
    boolean[] include = new boolean[options.length];
    for (int i = 0; i < options.length; i++) {
      System.out.println((i + 1) + ". " + options[i]);
    }
    System.out.print("\nEnter choices (e.g. 1234): ");
    String choices = sc.next();
    for (int i = 0; i < choices.length(); i++) {
      int index = Character.getNumericValue(choices.charAt(i)) - 1;
      if (index >= 0 && index < options.length) {
        include[index] = true;
      }
    }
    String password = "";
    for (int i = 0; i < length; i++) {
      int type = random.nextInt(options.length);
      while (!include[type]) {
        type = random.nextInt(options.length);
      }
      char c;
      switch (type) {
        case 0:
          c = (char) (random.nextInt(26) + 'a');
          break;
        case 1:
          c = (char) (random.nextInt(26) + 'A');
          break;
        case 2:
          c = (char) (random.nextInt(10) + '0');
          break;
        default:
          c = specialChars.charAt(random.nextInt(specialChars.length()));
          break;
      }
      password += c;
    }
  static void generatePassword() {
  String password = "";
  for (int i = 0; i < passwordLength; i++) {
    password += options[random.nextInt(options.length)];
  }
  System.out.println("Generated password: " + password);
  passwordHistory.add(password);
    }
  }
}
static void showCharacterOptions() {
  System.out.println("\nCharacter options:");
  for (int i = 0; i < options.length; i++) {
    System.out.println((i + 1) + ". " + options[i]);
  }
}
static void changeSpecialCharacters() {
  System.out.print("\nEnter new special characters: ");
  specialChars = sc.next();
  System.out.println("Special characters changed.");
}
static void changePasswordLength() {
  System.out.print("\nEnter new password length: ");
  passwordLength = sc.nextInt();
  System.out.println("Password length changed.");
}
static void showPasswordHistory() {
  System.out.println("\nPassword history:");
  for (int i = 0; i < passwordHistory.size(); i++) {
    System.out.println((i + 1) + ". " + passwordHistory.get(i));
  }
}
static ArrayList<String> passwordHistory = new ArrayList<>();

static void checkPasswordStrength() {
  System.out.print("\nEnter password to check: ");
  sc.nextLine();
  String password = sc.nextLine();
  int score = 0;
  if (password.length() >= 8) {
    score++;
  }
  if (password.matches(".*[a-z].*")) {
    score++;
  }
  if (password.matches(".*[A-Z].*")) {
    score++;
  }
  if (password.matches(".*[0-9].*")) {
    score++;
  }
  if (password.matches(".*[^a-zA-Z0-9].*")) {
    score++;
  }
  System.out.println("Password strength: " + score + "/5");
}
static void savePasswordToFile() {
  System.out.print("\nEnter password to save: ");
  sc.nextLine();
  String password = sc.nextLine();
  System.out.print("Enter file name: ");
  String fileName = sc.nextLine();
  try (FileWriter fw = new FileWriter(fileName)) {
    fw.write(password);
    System.out.println("Password saved to file " + fileName);
  } catch (IOException e) {
    System.out.println("Error saving password to file");
  }
}
static void loadPasswordFromFile() {
  System.out.print("\nEnter file name: ");
  String fileName = sc.nextLine();
  try (FileReader fr = new FileReader(fileName)) {
    int i;
    String password = "";
    while ((i = fr.read()) != -1) {
      password += (char) i;
    }
    System.out.println("Password loaded from file " + fileName + ": " + password);
  } catch (IOException e) {
    System.out.println("Error loading password from file");
  }
}
/*static String passwordGenerationAlgorithmBasedOnPhrase(String phrase) {
  String password = "";
  for (int i = 0; i < passwordLength; i++) {
    int index = i % phrase.length();
    password += phrase.charAt(index);
  }
  return password;
System.out.println("\nAvailable algorithms:");
System.out.println("1. Algorithm 1");
System.out.println("2. Algorithm 2");
System.out.println("3. Algorithm 3");
System.out.println("4. Algorithm based on phrase");
System.out.print("\nEnter algorithm number: ");
int choice = sc.nextInt();
if (choice == 1) {
  passwordGenerationAlgorithm = 1;
  System.out.println("Password generation algorithm changed to Algorithm 1");
} else if (choice == 2) {
  passwordGenerationAlgorithm = 2;
  System.out.println("Password generation algorithm changed to Algorithm 2");
} else if (choice == 3) {
  passwordGenerationAlgorithm = 3;
  System.out.println("Password generation algorithm changed to Algorithm 3");
} else if (choice == 4) {
  passwordGenerationAlgorithm = 4;
  System.out.println("Password generation algorithm changed to Algorithm based on phrase");
} else {
  System.out.println("Invalid choice. Try again.");
  }
}*/ 
