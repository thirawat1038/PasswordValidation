// ดูโจทย์ spec และวิธีทำใน README.md
public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;

    static boolean validate(String pw) {
        // R1: null -> throw
        if (pw == null) {
            throw new IllegalArgumentException("password must not be null");
        }

        // R2: length between MIN_LEN and MAX_LEN (inclusive)
        int len = pw.length();
        if (len < MIN_LEN || len > MAX_LEN) return false;

        // R6: must not contain space character
        if (pw.indexOf(' ') >= 0) return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (int i = 0; i < len; i++) {
            char c = pw.charAt(i);
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
        }

        // R3, R4, R5
        if (!hasUpper) return false;
        if (!hasLower) return false;
        if (!hasDigit) return false;

        return true;
    }
}
