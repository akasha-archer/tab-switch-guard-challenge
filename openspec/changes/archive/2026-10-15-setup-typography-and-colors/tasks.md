## 1. Color Palette Setup

- [x] 1.1 Define brand color tokens (`background`, `onBackground`, `surface`, `onSurface`, `onSurfaceVariant`, `outline`, `primary`) in `Color.kt`
- [x] 1.2 Update `LightColorScheme` in `Theme.kt` with the new color tokens, remove unused dark theme references, and set `dynamicColor = false`

## 2. Typography Scale Setup

- [x] 2.1 Define `DmSans` `FontFamily` in `Type.kt` referencing `R.font.dm_sans_regular` and `R.font.dm_sans_medium`
- [x] 2.2 Configure `Typography` in `Type.kt` with `titleMedium` (16sp, 20.8sp line height, Medium), `bodyMedium` (14sp, 19.6sp line height, Regular), and `labelMedium` (12sp, 15.6sp line height, Regular)

## 3. Verification

- [x] 3.1 Run `./gradlew compileDebugKotlin` to verify the project builds cleanly without errors
