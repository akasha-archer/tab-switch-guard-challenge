## Why

Users switching rapidly between categories that fetch data with varying latencies (All: 1200ms, Popular: 700ms, Sale: 500ms, New: 300ms) can encounter race conditions where slower, outdated operations finish last and overwrite the active tab's content. A tab switch guard is needed to cancel superseded in-flight jobs and guarantee the UI only reflects the currently selected tab.

## What Changes

- Create `ProductViewModel` implementing coroutine cancellation via `loadJob?.cancel()` whenever a tab is switched.
- Define a sealed `ProductUiState` (`Loading` and `Success`) ensuring previous content is immediately hidden while loading.
- Build `ProductTabScreen` featuring a `PrimaryTabRow` (All, Popular, New, Sale) and a dynamic content area rendering `LoadingStateScreen` or `ProductList`.
- Connect `ProductTabScreen` into `MainActivity` within `TabswitchguardTheme`.

## Capabilities

### New Capabilities
- `tab-switch-guard`: Tab-based navigation and content loading with coroutine cancellation guarding against race conditions and stale async results.

### Modified Capabilities
<!-- None -->

## Impact

- `app/src/main/java/com/example/tab_switch_guard/presentation/ProductViewModel.kt` (new file)
- `app/src/main/java/com/example/tab_switch_guard/presentation/ProductPager.kt`
- `app/src/main/java/com/example/tab_switch_guard/MainActivity.kt`
