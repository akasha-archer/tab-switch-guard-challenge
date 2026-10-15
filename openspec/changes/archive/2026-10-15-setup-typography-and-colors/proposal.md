## Why

The application currently uses default Material 3 placeholder colors and typography. To match the product specifications and establish a cohesive visual identity before building out the product pager UI, the app theme needs to be configured with the designated DM Sans font family and custom color palette.

## What Changes

- Add custom brand colors (`background`, `onBackground`, `surface`, `onSurface`, `onSurfaceVariant`, `outline`, `primary`) in `Color.kt`.
- Set up DM Sans `FontFamily` in `Type.kt` and configure the typography scale for Subtitle (`titleMedium`), Body (`bodyMedium`), and Label (`labelMedium`).
- Update `TabswitchguardTheme` in `Theme.kt` to bind the new light color scheme and typography.
- Set `dynamicColor = false` by default so custom brand colors are not overridden by Android 12+ dynamic theming.
- Explicitly scope the theme to light theme per design guidelines.

## Capabilities

### New Capabilities
- `app-theme`: Theme definition covering color tokens, typography scale using DM Sans, and light mode theme configuration.

### Modified Capabilities
<!-- None: Initial theme setup -->

## Impact

- `app/src/main/java/com/example/tab_switch_guard/ui/theme/Color.kt`
- `app/src/main/java/com/example/tab_switch_guard/ui/theme/Type.kt`
- `app/src/main/java/com/example/tab_switch_guard/ui/theme/Theme.kt`
- Any composables consuming `MaterialTheme.colorScheme` and `MaterialTheme.typography`
