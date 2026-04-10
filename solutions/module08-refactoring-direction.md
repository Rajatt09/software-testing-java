# Partial Solution: Module 08 Refactoring

Recommended refactoring direction:

1. Capture current behavior with characterization tests.
2. Extract interfaces or adapter seams around static and concrete dependencies.
3. Inject collaborators into the checkout coordinator.
4. Separate logging, payment, inventory, and notification responsibilities.

Do not start by changing logic branches. Start by making dependencies explicit.
