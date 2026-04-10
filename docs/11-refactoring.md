# Refactoring for Testability

## 1. Concept Explanation
Refactoring for testability means improving code structure so behavior is easier to verify without changing the external behavior. In this repository, `badcode/` shows examples of tight coupling, static dependencies, and mixed responsibilities.

## 2. Why It Matters
Hard-to-test code usually points to design problems. When a class talks to static methods, creates its own dependencies, and does many jobs at once, change becomes risky and expensive.

## 3. Key Principles
- Prefer constructor injection over hidden object creation.
- Extract interfaces at meaningful boundaries.
- Separate orchestration from side effects.
- Preserve behavior while improving structure.

## 4. Code Examples
- Good example

```java
public class OrderService {
    public OrderService(
            InventoryService inventoryService,
            PaymentService paymentService,
            NotificationService notificationService
    ) {
        // collaborators are explicit and replaceable in tests
    }
}
```

- Bad example (if applicable)

```java
public class LegacyCheckoutManager {
    private final LegacyInventoryGateway inventoryGateway = new LegacyInventoryGateway();

    public String checkout(...) {
        LegacyAuditLogger.log("START");
        boolean charged = LegacyPaymentGateway.charge(customerId, total);
        // multiple responsibilities and static side effects
    }
}
```

## 5. Common Mistakes
- Refactoring behavior and structure at the same time without tests
- Replacing one giant class with many tiny but unclear classes
- Adding interfaces everywhere instead of at real seams
- Forgetting to capture current behavior with characterization tests

## 6. When to Use / Avoid
Use refactoring for testability when code is painful to change, slow to test, or highly coupled. Avoid unnecessary abstraction when the code is already simple and easy to exercise.

## 7. Hands-on Exercise
Write characterization tests around `LegacyCheckoutManager`, then refactor it to use injected dependencies and smaller responsibilities without changing the existing outcomes.

## 8. Interview Insights
Interviewers often ask how testing and design influence each other. A strong answer is that good tests support refactoring, and code that is easy to test often has clearer boundaries and responsibilities.
