# Software Testing Workshop for Java

This repository is a complete workshop system for learning software testing with Java 17+, JUnit 5, Mockito, and Gradle. It uses an e-commerce domain to teach unit testing fundamentals, JUnit basics, test doubles, Mockito, TDD, BDD, async testing, the test pyramid, and refactoring for testability.

## Learning Path

1. Module 01: Unit Testing Basics
2. Module 02: JUnit and reusable setup
3. Module 03: Test Doubles
4. Module 04: Mockito
5. Module 05: TDD with intentionally failing tests
6. Module 06: BDD-style tests
7. Module 07: Async testing and determinism
8. Module 08: Refactoring hard-to-test code

## Repository Layout

- `docs/`: concept notes and teaching guides for each topic
- `src/main/java/com/software/testingjava/`: production examples and intentionally bad code
- `src/test/java/com/software/testingjava/`: module-based tests for the workshop
- `exercises/`: learner tasks and expected outcomes
- `solutions/`: partial solution notes for selected modules

## Build and Test

Use the Gradle Wrapper:

```bash
./gradlew test
```

Important: the default test run is expected to fail because Module 05 contains TDD-first tests for behavior that is not implemented yet. That is intentional and part of the workshop.

## Goals

- Learn the Arrange, Act, Assert pattern
- Write readable, well-named unit tests
- Use JUnit 5 annotations and assertions effectively
- Compare stubs, fakes, mocks, and spies
- Apply Mockito only where interaction testing is useful
- Experience red-green-refactor with pre-written failing tests
- Stabilize async tests
- Improve poor design through refactoring for testability
