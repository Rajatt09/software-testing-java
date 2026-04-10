# Mockito Guide

## 1. Concept Explanation
Mockito is a mocking library for Java. It helps create mocks, stub method responses, and verify calls without writing custom implementations for every dependency.

## 2. Why It Matters
Mockito is useful when the important behavior is an interaction between components, such as checking that `NotificationService` is called after a successful payment.

## 3. Key Principles
- Use `mock()` to create a mock object.
- Use `when(...).thenReturn(...)` to stub responses.
- Use `verify(...)` to confirm interactions.
- Keep mocks focused on relevant collaborators only.

## 4. Code Examples
- Good example

```java
InventoryService inventory = mock(InventoryService.class);
when(inventory.isAvailable("BOOK-1", 2)).thenReturn(true);

PaymentService paymentService = mock(PaymentService.class);
when(paymentService.processPayment(any())).thenReturn(PaymentResult.success("txn-123"));

orderService.placeOrder(order);

verify(paymentService).processPayment(any());
verify(notificationService).sendOrderConfirmation(order);
```

- Bad example (if applicable)

```java
// Over-mocking anti-pattern:
// mocking value objects, collections, and simple data holders instead of using real instances.
```

When not to mock:
- Do not mock simple value objects like `OrderItem`.
- Do not mock collections or strings.
- Do not mock a dependency when a tiny fake is clearer.

## 5. Common Mistakes
- Verifying too many calls in one test
- Stubbing behavior that the test never uses
- Mocking internal implementation details
- Using Mockito everywhere, even when a real object is simpler

## 6. When to Use / Avoid
Use Mockito when the collaboration itself matters, especially with gateways, notifiers, or external services. Avoid Mockito when a real object or fake makes the test more readable.

## 7. Hands-on Exercise
Write a test for `OrderService` using `mock()`, `when().thenReturn()`, and `verify()`. Then rewrite the same scenario with a fake inventory service and compare the result.

## 8. Interview Insights
Many interviewers ask how Mockito differs from manual doubles. A balanced answer is that Mockito is powerful for interaction testing, but manual fakes can be better for readability and domain-focused tests.
