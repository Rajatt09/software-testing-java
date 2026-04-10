# Module 07 Exercise Instructions

## Task
Study the disabled flaky test and rewrite the async scenario so it is deterministic.

## Constraints
Do not rely on arbitrary sleep values as the main synchronization technique.

## Expected Behavior
The async behavior is still tested, but the result is stable across repeated runs.

## Hints
Control the executor or wait on the returned `CompletableFuture`.
