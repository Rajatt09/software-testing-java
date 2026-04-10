# Behavior Driven Development

## 1. Concept Explanation
BDD emphasizes behavior and communication. In tests, that usually means naming tests around expected outcomes and often structuring them as Given, When, Then.

## 2. Why It Matters
BDD-style tests are easier for non-specialists and new team members to read. They connect technical checks back to business expectations.

## 3. Key Principles
- Name tests in business language.
- Use Given / When / Then comments or structure.
- Focus on observable behavior.
- Keep behavior statements concrete.

## 4. Code Examples
- Good example

```java
@Test
void givenAvailableStockWhenOrderIsPlacedThenOrderIsConfirmed() {
    // Given
    Order order = TestOrders.singleItemOrder();

    // When
    OrderReceipt receipt = orderService.placeOrder(order);

    // Then
    assertEquals(OrderStatus.CONFIRMED, receipt.getStatus());
}
```

- Bad example (if applicable)

```java
@Test
void serviceTest() {
    // Not behavior-focused and not useful to readers.
}
```

## 5. Common Mistakes
- Confusing BDD naming with a new test framework requirement
- Writing overly long “story” method names
- Mixing technical jargon with business terms
- Hiding the behavior under complex setup helpers

## 6. When to Use / Avoid
Use BDD style when communicating workflows, rules, or user-facing behavior. Avoid forcing Given / When / Then wording into tiny utility tests where it reduces clarity.

## 7. Hands-on Exercise
Take a plain JUnit test and rename it using Given / When / Then language. Then update the comments so the behavior reads like a small specification.

## 8. Interview Insights
BDD interview questions often probe whether you understand that BDD is about shared understanding, not only syntax. Mention communication, examples, and business-readable behavior.
