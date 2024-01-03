/*
Test generated by RoostGPT for test aman321 using AI Type Open AI and AI Model gpt-4

1. Scenario: Null Input
   Test that the `setAdminName` function handles null input correctly. The function should throw an exception or error when a null value is passed.

2. Scenario: Empty String Input
   Test that the `setAdminName` function handles an empty string correctly. The function should throw an exception or error when an empty string is passed.

3. Scenario: Valid Input
   Test that the `setAdminName` function accepts a valid string and sets the `adminName` correctly. The function should not throw any exceptions or errors and should correctly assign the passed string to `adminName`.

4. Scenario: Input with Special Characters
   Test that the `setAdminName` function handles a string with special characters correctly. Depending on the business logic, the function might throw an exception, error, or accept the string.

5. Scenario: Input with Numbers
   Test that the `setAdminName` function handles a string with numbers correctly. Depending on the business logic, the function might throw an exception, error, or accept the string.

6. Scenario: Input with Spaces
   Test that the `setAdminName` function handles a string with spaces correctly. Depending on the business logic, the function might throw an exception, error, or accept the string.

7. Scenario: Long String Input
   Test that the `setAdminName` function handles a very long string correctly. Depending on the business logic, the function might throw an exception, error, or accept the string.

8. Scenario: Input with Non-ASCII Characters
   Test that the `setAdminName` function handles a string with non-ASCII characters correctly. Depending on the business logic, the function might throw an exception, error, or accept the string.

9. Scenario: Input with Unicode Characters
   Test that the `setAdminName` function handles a string with Unicode characters correctly. Depending on the business logic, the function might throw an exception, error, or accept the string.

10. Scenario: Multiple Set Calls
    Test that the `setAdminName` function handles multiple calls correctly. The function should correctly assign the latest passed string to `adminName`.
*/
public void setAdminName(String adminName) {
    if(adminName == null) {
        throw new NullPointerException("Admin name cannot be null");
    }
    if(adminName.isEmpty()) {
        throw new IllegalArgumentException("Admin name cannot be empty");
    }
    if(!adminName.matches("[a-zA-Z ]+")) {
        throw new IllegalArgumentException("Admin name can only contain alphabets and spaces");
    }
    if(adminName.length() > 50) {
        throw new IllegalArgumentException("Admin name cannot be more than 50 characters");
    }
    this.adminName = adminName;
}
