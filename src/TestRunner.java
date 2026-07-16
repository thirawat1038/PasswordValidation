// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)
        check("'Abcdef12' valid", PasswordValidator.validate("Abcdef12"));

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try { PasswordValidator.validate(null); }
        catch (IllegalArgumentException e) { threw = true; }
        check("null -> throws IllegalArgumentException", threw);
        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
          check("length 7 (too short) -> false", !PasswordValidator.validate("Abcdef1"));
          check("length 8 (lower bound) -> true", PasswordValidator.validate("Abcdefg1"));
          check("length 20 (upper bound) -> true", PasswordValidator.validate("Abcdefghij1234567890"));
          check("length 21 (too long) -> false", !PasswordValidator.validate("Abcdefghij12345678901"));
          check("length 0 (empty) -> false", !PasswordValidator.validate(""));
        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> false
          check("no uppercase -> false", !PasswordValidator.validate("abcdefg1"));
        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
          check("no lowercase -> false", !PasswordValidator.validate("ABCDEFG1"));
        // TODO: R5 - ไม่มีตัวเลข -> false
          check("no digit -> false", !PasswordValidator.validate("Abcdefgh"));
        // TODO: R6 - มีช่องว่าง -> false
          check("contains space -> false", !PasswordValidator.validate("Abcdef 12"));
        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น
          check("leading space -> false", !PasswordValidator.validate(" Abcdef12"));
        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}
