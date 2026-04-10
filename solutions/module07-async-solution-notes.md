# Partial Solution: Module 07 Async

The stable teaching direction is to replace timing guesses with deterministic coordination.

```java
AsyncOrderNotifier notifier = new AsyncOrderNotifier(notificationService, Runnable::run);
boolean result = notifier.sendConfirmation(order).get(1, TimeUnit.SECONDS);
assertTrue(result);
```

Key idea: keep the test responsible for coordination instead of hoping a background thread finishes in time.
