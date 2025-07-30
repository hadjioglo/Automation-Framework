package factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class EmailTestData {
    public static Map<String, List<String>> getEmailTestData() {
        Map<String, List<String>> emailTestData = new HashMap<>();

        List<String> validEmails = Arrays.asList(
            "user@example.com",                          // Basic valid email
            "firstname.lastname@domain.com",             // With dots in local part
            "user+alias@example.co.uk",                 // With plus and multi-level TLD
            "disposable.style.email+123@example.com",   // Complex local part
            "other.email-with-hyphen@example.com",      // Hyphen in domain
            "fully-qualified-domain@example.com",        // Hyphen in local part
            "user.name@example.museum",                 // Special TLD
            "example@s.example.com",                    // One letter subdomain
            "user@subdomain.example.xn--clchc0ea0b2g2a9gcd", // Internationalized domain name
            "user123456@long-domain-name-123456789.com" // Long domain name
        );

        List<String> invalidEmails = Arrays.asList(
            "plainaddress",                    // Missing @ symbol
            "@domain.com",                     // Missing local part
            "user@",                           // Missing domain
            "user@.com",                       // Domain starts with dot
            "user@domain..com",                // Consecutive dots in domain
            ".user@domain.com",                // Local part starts with dot
            "user@-domain.com",                // Domain starts with hyphen
            "user@domain-.com",                // Domain ends with hyphen
            "user name@domain.com",            // Space in local part
            "user@domain.com."                 // TLD ends with dot
        );

        emailTestData.put("valid", validEmails);
        emailTestData.put("invalid", invalidEmails);

        return emailTestData;
    }
}
