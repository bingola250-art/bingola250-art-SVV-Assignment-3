import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {
    UserValidator validator;

    @BeforeEach // Setup Method
    void setUp() { 
        validator = new UserValidator(); 
    }

    @AfterEach // Teardown Method (Bunu yeni ekledik!)
    void tearDown() {
        validator = null; // Test bitince hafızayı temizliyoruz
    }

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
        assertFalse(validator.isValidPassword("kisa123"));      // Çok kısa (BVA)
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
    @Test // 17-21: Doğum Tarihi Testleri (BVA & EP)
    void testDateOfBirth() {
        assertTrue(validator.isValidDateOfBirth("15/05/2000")); // Geçerli format
        assertFalse(validator.isValidDateOfBirth("32/05/2000")); // Sınır Değer (BVA) - 32. gün olamaz
        assertFalse(validator.isValidDateOfBirth("15/13/2000")); // Sınır Değer (BVA) - 13. ay olamaz
        assertFalse(validator.isValidDateOfBirth("15-05-2000")); // Yanlış format (EP) - tire kullanılmış
        assertFalse(validator.isValidDateOfBirth(null));
    }
}
