## 1. ViewModel and State Management

- [x] 1.1 Create `ProductUiState` sealed interface (`Loading` and `Success`) and `ProductViewModel` with `loadJob?.cancel()` coroutine guard logic in `app/src/main/java/com/example/tab_switch_guard/presentation/ProductViewModel.kt`

## 2. Tab Navigation and Content Screen

- [x] 2.1 Implement `ProductTabScreen` in `app/src/main/java/com/example/tab_switch_guard/presentation/ProductPager.kt` using `PrimaryTabRow` and dynamic content switching between `LoadingStateScreen` and `ProductList`
- [x] 2.2 Update `MainActivity.kt` to host `ProductTabScreen` within `TabswitchguardTheme` and `Scaffold`

## 3. Verification

- [x] 3.1 Run `./gradlew compileDebugKotlin` to verify project builds cleanly without errors
