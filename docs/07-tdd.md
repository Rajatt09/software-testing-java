# Test Driven Development

## 1. Concept Explanation
TDD is the practice of writing a failing test first, then writing the minimal production code to make it pass, and finally refactoring. The common loop is red, green, refactor.

## 2. Why It Matters
TDD keeps implementation focused on behavior instead of speculation. It also gives developers a fast way to validate progress and reduce accidental scope growth.

## 3. Key Principles
- Start with a failing test that describes behavior.
- Implement only enough code to pass.
- Refactor after the safety net exists.
- Keep the feedback loop small.

## 4. Code Examples
- Good example

```java
@Test
void shouldApplyPremiumDiscountForPremiumCustomer() {
    // Arrange
    Order premiumOrder = TestOrders.premiumOrder();
    DiscountCalculator calculator = new DiscountCalculator();

    // Act
    BigDecimal total = calculator.calculateDiscountedTotal(premiumOrder);

    // Assert
    assertEquals(new BigDecimal("90.00"), total);
}
```

- Bad example (if applicable)

```java
// Writing a large class first and adding tests later is not TDD.
```

## 5. Common Mistakes
- Writing too many failing tests before implementing anything
- Testing several behaviors in one first step
- Treating TDD as “test after development”
- Skipping refactoring after the tests pass

## 6. When to Use / Avoid
Use TDD when implementing new business rules, pricing logic, or branching-heavy behavior. Avoid cargo-cult TDD on throwaway scripts or trivial pass-through code where the cost outweighs the value.

## 7. Hands-on Exercise
Run Module 05, observe the failing tests, and implement `DiscountCalculator` incrementally until the suite passes. Do not start by writing the whole algorithm at once.

## 8. Interview Insights
Interviewers often ask whether TDD guarantees bug-free code. A good answer is no: TDD improves design and feedback loops, but thoughtful test coverage and broader testing layers are still needed.
