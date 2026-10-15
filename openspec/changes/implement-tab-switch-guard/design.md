## Context

See `proposal.md` for motivation. The data models and simulated latency constants are already in place (`ProductData.kt`, `ProductPagerTitles.kt`, `TimeConstants.kt`). UI components for loading (`LoadingStateScreen`) and product items (`ProductList`, `ItemCard`) have been styled with the design system.

## Goals / Non-Goals

**Goals:**
- Provide a responsive tab bar with "All", "Popular", "New", "Sale" using Material 3 `PrimaryTabRow`.
- Implement coroutine cancellation in `ProductViewModel` using `loadJob?.cancel()` whenever a tab is switched.
- Transition state immediately to `LoadingStateScreen` upon tab switch.
- Prevent any out-of-order race conditions from displaying stale data.
- Integrate the screen into `MainActivity`.

**Non-Goals:**
- Swiping gestures between pages (user explicitly chose Tab Row with dynamic content).
- Network caching or persistent offline database (in-memory filtering is sufficient per technical requirements).

## Decisions

### Decision 1: Explicit `Job.cancel()` in `ProductViewModel`
- **Rationale**: Clean, direct, and explicit practice of Kotlin coroutine cancellation. When `onTabSelected(tab)` is invoked, `loadJob?.cancel()` sends a `CancellationException` to the active delay/fetch, immediately terminating execution before state emission.
- **Alternatives considered**: `flatMapLatest` (reactive flow approach). Rejected in favor of explicit `Job.cancel()` per user preference for coroutine practice.

### Decision 2: Sealed `ProductUiState` modeling
- **Rationale**: Modeling UI state as a sealed interface with `Loading(tabTitle)` and `Success(tab, products)` ensures that the UI cannot accidentally access or render old products while a new tab is loading.
- **Alternatives considered**: Single data class with `isLoading: Boolean` and `products: List<ProductData>`. Rejected because keeping `products` in the state during loading makes stale data persistence possible.

### Decision 3: `PrimaryTabRow` with dynamic content area
- **Rationale**: Matches the visual design from the Figma/PDF mockup, where the tabs sit persistently at the top and the area below switches between the loading indicator and product list.

## Risks / Trade-offs

- **[Risk]** Rapid clicking could cause repeated object allocation and state transitions.
  - **Mitigation**: Add a guard in `onTabSelected` to ignore re-selecting the currently displayed tab when already in `Success` state.
