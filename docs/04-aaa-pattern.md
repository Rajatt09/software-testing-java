# AAA Pattern

## 1. Concept Explanation
AAA stands for Arrange, Act, Assert. It is a lightweight structure for writing tests that are easy to read and easy to change.

## 2. Why It Matters
AAA prevents tests from becoming an unreadable block of setup, execution, and expectations. It also helps beginners build tests with consistent flow.

## 3. Key Principles
- Arrange only the data and collaborators needed.
- Act once on the system under test.
- Assert the outcome that proves behavior.
- Keep each section visually obvious with comments.

## 4. Code Examples
- Good example

```java
@Test
void shouldCreateReceiptWhenOrderSucceeds() {
    // Arrange
    Order order = TestOrders.singleItemOrder();
    OrderReceipt receipt = orderService.placeOrder(order);

    // Act
    OrderStatus status = receipt.getStatus();

    // Assert
    assertEquals(OrderStatus.CONFIRMED, status);
}
```

- Bad example (if applicable)

```java
@Test
void shouldCreateReceiptWhenOrderSucceeds() {
    Order order = TestOrders.singleItemOrder();
    assertEquals(OrderStatus.CONFIRMED, orderService.placeOrder(order).getStatus());
}
```

The bad example technically works, but it hides the flow and makes debugging harder.

## 5. Common Mistakes
- Mixing assertions into setup
- Calling several methods in the Act phase
- Performing extra setup after Act
- Omitting comments when teaching beginners

## 6. When to Use / Avoid
Use AAA for almost every unit test in this workshop. Avoid treating it as a rigid law when another format is clearer, but keep the mental model.

## 7. Hands-on Exercise
Take an existing test and rewrite it so the three phases are clearly separated by comments. Remove any unused setup and keep only one Act step.

## 8. Interview Insights
AAA is often discussed as a readability tool rather than a framework rule. In interviews, mention that it helps reduce cognitive load and improves maintainability.
