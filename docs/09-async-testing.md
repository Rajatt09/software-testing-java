# Async Testing

## 1. Concept Explanation
Async testing deals with behavior that happens on another thread, later in time, or through futures and callbacks. This workshop uses `CompletableFuture` to demonstrate both flaky and deterministic tests.

## 2. Why It Matters
Async code can produce false failures, race conditions, and timing-sensitive bugs. A test that passes sometimes and fails sometimes is worse than a missing test because it erodes trust.

## 3. Key Principles
- Control the executor when possible.
- Prefer awaiting a future over using blind sleeps.
- Keep time-based tests explicit and bounded.
- Demonstrate flaky tests only in a safe way, such as disabling them.

## 4. Code Examples
- Good example

```java
@Test
void shouldSendConfirmationDeterministically() throws Exception {
    // Arrange
    AsyncOrderNotifier notifier = new AsyncOrderNotifier(notificationService, Runnable::run);

    // Act
    Boolean result = notifier.sendConfirmation(order).get(1, TimeUnit.SECONDS);

    // Assert
    assertTrue(result);
}
```

- Bad example (if applicable)

```java
@Test
void shouldEventuallySendConfirmation() throws Exception {
    notifier.sendConfirmation(order);
    Thread.sleep(10);
    assertTrue(flag);
}
```

The bad example depends on timing guesses instead of deterministic coordination.

## 5. Common Mistakes
- Using `Thread.sleep` as the main synchronization strategy
- Leaving futures unobserved
- Forgetting timeouts
- Running flaky demos as part of stable CI suites

## 6. When to Use / Avoid
Use async tests when the production behavior is actually asynchronous. Avoid introducing extra threading into tests unless it is necessary to express the feature.

## 7. Hands-on Exercise
Take the flaky async example and rewrite it so it uses a deterministic executor or waits on the returned future with a timeout.

## 8. Interview Insights
Interviewers often ask how to make async tests stable. Good answers mention deterministic executors, latches, futures with timeouts, and minimizing arbitrary sleeps.
