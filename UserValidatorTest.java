import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {
    UserValidator validator;

    @BeforeEach // Setup Method
    void setUp() { validator = new UserValidator(); }

    @Test // 1-5: İsim Testleri (Equivalence Partitioning)
    void testNames() {
        assertTrue(validator.isValidName("Ahmet"));
        assertFalse(validator.isValidName(""));
        assertFalse(validator.isValidName(null));
        assertFalse(validator.isValidName("Ahmet123"));
        assertFalse(validator.isValidName("Ahmet!"));
    }

    @Test // 6-10: Şifre Testleri (Boundary Value Analysis)
    void testPasswords() {
        assertTrue(validator.isValidPassword("Sifre1234")); // Geçerli
        assertFalse(validator.isValidPassword("kisa1"));      // Çok kısa (BVA)
        assertFalse(validator.isValidPassword("SADECEHARF")); // Rakam yok
        assertFalse(validator.isValidPassword("sadece_kucuk_1")); // Büyük harf yok
        assertTrue(validator.doPasswordsMatch("Sifre1", "Sifre1"));
        assertFalse(validator.doPasswordsMatch("Sifre1", "Sifre2"));
    }

    @Test // 11-15: E-mail Testleri
    void testEmails() {
        assertTrue(validator.isValidEmail("ali@mail.com"));
        assertFalse(validator.isValidEmail("ali.com"));
        assertFalse(validator.isValidEmail("@mail.com"));
        assertFalse(validator.isValidEmail("ali@"));
        assertFalse(validator.isValidEmail(null));
    }
}
