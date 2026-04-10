# Test Doubles

## 1. Concept Explanation
Test doubles are stand-ins for real collaborators. Common types are stubs, fakes, mocks, and spies. In this workshop, `InventoryService`, `PaymentService`, and `NotificationService` are ideal places to demonstrate them.

## 2. Why It Matters
Real dependencies are often slow, flaky, or hard to control. Test doubles help isolate behavior and make tests deterministic.

## 3. Key Principles
- A stub returns pre-defined answers.
- A fake is a lightweight working implementation, often in memory.
- A mock is usually used to verify interactions.
- A spy wraps a real object while tracking calls.
- Choose the simplest double that supports the test.

## 4. Code Examples
- Good example

```java
class FakeInventoryService implements InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    void put(String sku, int quantity) {
        stock.put(sku, quantity);
    }

    @Override
    public boolean isAvailable(String sku, int quantity) {
        return stock.getOrDefault(sku, 0) >= quantity;
    }

    @Override
    public void reserve(String sku, int quantity) {
        stock.put(sku, stock.get(sku) - quantity);
    }
}
```

```java
class StubPaymentService implements PaymentService {
    @Override
    public PaymentResult processPayment(PaymentRequest request) {
        return PaymentResult.success("stubbed");
    }
}
```

- Bad example (if applicable)

```java
// Using a mock for every dependency, even when a tiny fake would explain behavior better.
```

Mock vs Fake comparison:
- A mock mainly answers “was this collaborator called correctly?”
- A fake mainly answers “can I use a simple working replacement to drive behavior?”
- Fakes are often better for state-based tests.
- Mocks are often better for interaction-focused tests.

## 5. Common Mistakes
- Calling every double a mock
- Overusing mocks for simple state behavior
- Building a fake so large that it becomes a second production system
- Forgetting that spies can make tests too coupled to implementation details

## 6. When to Use / Avoid
Use stubs when you only need a canned response, fakes when a small working implementation improves readability, and mocks when interaction verification is the real goal. Avoid complex doubles that hide more than they reveal.

## 7. Hands-on Exercise
Implement a fake inventory service and compare the test readability with a mock-heavy version. Then explain which one better communicates the business rule.

## 8. Interview Insights
Interviewers often ask for the difference between a mock and a fake. A strong answer is: a fake has working behavior, usually simplified and in memory; a mock is usually assertion-driven and used to verify how collaborators were called.
