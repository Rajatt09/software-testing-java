# Assertions

## 1. Concept Explanation
Assertions are the statements that decide whether a test passes or fails. In JUnit 5, assertions like `assertTrue`, `assertFalse`, `assertNotNull`, `assertEquals`, and `assertThrows` help express expected outcomes clearly.

## 2. Why It Matters
Weak assertions lead to weak tests. A test that only checks “something happened” may pass while the real behavior is still broken. Strong assertions make failures easier to understand and fix.

## 3. Key Principles
- Match the assertion to the intent.
- Assert on behavior, not incidental internal details.
- Prefer one primary assertion target per behavior.
- Use `assertThrows` for error-path expectations.

## 4. Code Examples
- Good example

```java
@Test
void shouldRejectZeroQuantity() {
    // Arrange

    // Act
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new OrderItem("BOOK-1", 0, new BigDecimal("10.00"))
    );

    // Assert
    assertEquals("Quantity must be greater than zero", exception.getMessage());
}
```

- Bad example (if applicable)

```java
@Test
void shouldRejectZeroQuantity() {
    try {
        new OrderItem("BOOK-1", 0, new BigDecimal("10.00"));
        fail("Expected exception");
    } catch (Exception ignored) {
    }
}
```

The bad example catches any exception and ignores the message, making the test less precise.

## 5. Common Mistakes
- Using `assertTrue` where `assertEquals` would be clearer
- Ignoring exception messages or state transitions
- Asserting on too many unrelated values in one test
- Writing tests with no assertion at all

## 6. When to Use / Avoid
Use assertions in every test to describe what success means. Avoid vague or indirect assertions when a more direct one exists.

## 7. Hands-on Exercise
Take a simple inventory test and rewrite it to use `assertFalse` for unavailable stock, `assertNotNull` for a receipt, and `assertThrows` for an unavailable order path.

## 8. Interview Insights
Interviewers like candidates who can explain why assertion choice matters. Saying “I prefer the most specific assertion that matches the business rule” is usually a strong answer.
