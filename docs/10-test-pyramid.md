# Test Pyramid

## 1. Concept Explanation
The test pyramid is a model for balancing test types. The base contains many fast unit tests, the middle contains fewer integration tests, and the top contains even fewer end-to-end tests.

## 2. Why It Matters
Teams that over-invest in slow UI or end-to-end tests often get poor feedback speed. Teams that only write unit tests may miss integration issues. The pyramid encourages a healthy balance.

## 3. Key Principles
- Write many focused unit tests.
- Add enough integration tests to verify boundaries.
- Reserve end-to-end tests for key user journeys.
- Keep slow tests selective and high value.

## 4. Code Examples
- Good example

```text
Unit: OrderItem total, discount rules, order orchestration with doubles
Integration: Payment gateway adapter against a sandbox or contract
End-to-end: Customer completes checkout successfully
```

- Bad example (if applicable)

```text
Hundreds of browser tests for behavior that could be covered by small unit tests
```

## 5. Common Mistakes
- Treating the pyramid as “unit tests only”
- Duplicating the same scenario at every layer
- Ignoring contract or integration risks at system boundaries
- Measuring quality only by test count

## 6. When to Use / Avoid
Use the pyramid as a planning heuristic for balanced coverage. Avoid treating it as a rigid law when architecture or product risk suggests a different mix.

## 7. Hands-on Exercise
Classify the tests in this workshop by layer. Explain why the Mockito tests belong near the unit layer, while real gateway tests would live higher in the pyramid.

## 8. Interview Insights
Strong interview answers connect the pyramid to speed, confidence, and maintenance cost, not just to a diagram.
