# Unit Testing Basics

## 1. Concept Explanation
Unit testing checks a small piece of behavior in isolation. In this workshop, a unit might be a value object like `OrderItem`, a service like `OrderService`, or a simple pricing rule. Good unit tests focus on one behavior at a time and give quick feedback.

## 2. Why It Matters
Unit tests make changes safer. They help teams catch regressions early, document expected behavior, and support refactoring with confidence. In an e-commerce system, small mistakes in totals, inventory checks, or payment flow can quickly become expensive defects.

## 3. Key Principles
- Test one behavior per test.
- Keep tests deterministic and fast.
- Prefer clear names over clever names.
- Use the AAA pattern: Arrange, Act, Assert.
- Assert on outcomes that matter to the reader.

## 4. Code Examples
- Good example

```java
@Test
void shouldCalculateItemTotal() {
    // Arrange
    OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("15.00"));

    // Act
    BigDecimal total = item.totalPrice();

    // Assert
    assertEquals(new BigDecimal("30.00"), total);
}
```

- Bad example (if applicable)

```java
@Test
void test1() {
    OrderItem item = new OrderItem("BOOK-1", 2, new BigDecimal("15.00"));
    assertTrue(item.totalPrice().intValue() == 30);
}
```

The bad example hides intent, skips AAA comments, and uses a weaker assertion style.

## 5. Common Mistakes
- Testing too many branches in one test
- Depending on system time or threads without control
- Using vague names like `testSomething()`
- Asserting on implementation details instead of behavior

## 6. When to Use / Avoid
Use unit tests for business rules, calculations, branching logic, and service orchestration. Avoid treating unit tests as a replacement for integration or end-to-end tests; they are only one layer of the test pyramid.

## 7. Hands-on Exercise
Write tests for `Order.totalAmount()` and `PaymentResult.success(...)`. Include `assertEquals`, `assertNotNull`, and `assertThrows` to cover both correct behavior and invalid input.

## 8. Interview Insights
Interviewers often ask for the definition of a unit test, how it differs from integration testing, and what makes a test maintainable. Strong answers mention isolation, speed, readability, and trustworthy feedback.
