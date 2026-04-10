# Module 02 Exercise Instructions

## Task
Refactor a test class so shared setup moves into `@BeforeEach` and cleanup moves into `@AfterEach`.

## Constraints
Do not hide important setup in helpers that make the test harder to read.

## Expected Behavior
Each test should start from a fresh fixture and remain independent from the others.

## Hints
Look for repeated inventory seeding and repeated `OrderService` construction.
