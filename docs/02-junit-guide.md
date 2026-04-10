# JUnit 5 Guide

## 1. Concept Explanation
JUnit 5 is the test framework used in this workshop. It provides annotations, assertions, lifecycle hooks, and execution support for modern Java testing.

## 2. Why It Matters
Without a framework, tests become repetitive and hard to organize. JUnit standardizes how tests are written and run, which makes the suite easier to understand for every contributor.

## 3. Key Principles
- Use `@Test` for executable test methods.
- Use `@BeforeEach` to build a fresh fixture before every test.
- Use `@AfterEach` for cleanup or counters when teaching lifecycle behavior.
- Keep lifecycle methods small and focused.

## 4. Code Examples
- Good example

```java
class OrderServiceLifecycleTest {
    private InMemoryInventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InMemoryInventoryService();
        inventoryService.addStock("BOOK-1", 10);
    }

    @AfterEach
    void tearDown() {
        inventoryService = null;
    }

    @Test
    void shouldReportAvailableStock() {
        // Arrange

        // Act
        boolean available = inventoryService.isAvailable("BOOK-1", 2);

        // Assert
        assertTrue(available);
    }
}
```

- Bad example (if applicable)

```java
@Test
void shouldReuseStateAcrossTests() {
    // This becomes fragile when earlier tests mutate shared objects.
}
```

## 5. Common Mistakes
- Sharing mutable state between tests
- Doing too much work in `@BeforeEach`
- Forgetting that `@AfterEach` runs even when a test fails
- Hiding important setup in helper methods that readers cannot find quickly

## 6. When to Use / Avoid
Use lifecycle hooks when several tests need the same fixture. Avoid lifecycle overuse when one test needs very custom setup; sometimes local setup in the test reads better.

## 7. Hands-on Exercise
Refactor a test class so common order setup moves into `@BeforeEach`. Add an `@AfterEach` method that resets a simple counter or reference used by the test fixture.

## 8. Interview Insights
Common interview prompts include the difference between JUnit 4 and JUnit 5, how lifecycle annotations work, and when shared test setup helps versus hurts readability.
