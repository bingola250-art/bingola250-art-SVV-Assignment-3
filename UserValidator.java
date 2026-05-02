import java.util.regex.Pattern;

public class UserValidator {
    // İsim/Soyisim kontrolü: Boş olmamalı ve sadece harf olmalı
    public boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z]+$");
    }

    // E-mail kontrolü
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && Pattern.compile(emailRegex).matcher(email).matches();
    }

    // Şifre kontrolü: En az 8 karakter, bir büyük harf ve bir rakam
    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8 && 
               password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
    }

    // Şifre eşleşme kontrolü
    public boolean doPasswordsMatch(String p1, String p2) {
        return p1 != null && p1.equals(p2);
    }
}
