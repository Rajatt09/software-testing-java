# Module 04 Exercise Instructions

## Task
Write an `OrderService` test using `mock()`, `when().thenReturn()`, and `verify()`.

## Constraints
Mock collaborators only, not value objects such as `Order` or `OrderItem`.

## Expected Behavior
The test should verify that payment and notification interactions happen after inventory is available.

## Hints
Start by mocking `InventoryService`, `PaymentService`, and `NotificationService`.
