## Context

See `proposal.md` for motivation. The codebase currently contains initial template theme files (`Color.kt`, `Type.kt`, `Theme.kt`). The font files for DM Sans have already been imported into `app/src/main/res/font/`.

## Goals / Non-Goals

**Goals:**
- Centralize custom colors in `Color.kt` and wire them into `lightColorScheme` in `Theme.kt`.
- Create a `FontFamily` for DM Sans in `Type.kt` utilizing `R.font.dm_sans_regular` and `R.font.dm_sans_medium`.
- Configure `titleMedium` (Subtitle: 16sp / 20.8sp line height / Medium), `bodyMedium` (Body: 14sp / 19.6sp line height / Regular), and `labelMedium` (Label: 12sp / 15.6sp line height / Regular).
- Set `dynamicColor = false` in `TabswitchguardTheme` and restrict color scheme to `LightColorScheme`.

**Non-Goals:**
- Implementing dark mode color palette (explicitly excluded per product decision).
- Updating UI screens (e.g. `ProductRowItem.kt` or `ProductPager.kt`) to consume the theme (will be handled in subsequent tasks).

## Decisions

### Decision 1: Map Subtitle, Body, and Label to Material 3 standard typography roles
- **Rationale**: Material 3 Composables and standard styles expect standard M3 roles (`titleMedium`, `bodyMedium`, `labelMedium`). Mapping the specified scale to these standard slots allows components to naturally adopt typography without requiring custom CompositionLocals.
- **Alternatives considered**: Defining custom `TextStyle` constants or a custom `LocalTypography` provider. Rejected to keep standard Compose M3 compatibility.

### Decision 2: Set dynamicColor default to false
- **Rationale**: On Android 12+ (API 31+), `dynamicLightColorScheme(context)` extracts wallpaper palette and overrides all custom primary/surface colors. Setting `dynamicColor = false` ensures visual consistency across all devices.

## Risks / Trade-offs

- **[Risk]** Unmapped typography roles (e.g., `headlineLarge`, `bodySmall`) will use default system Roboto/platform fonts if referenced.
  - **Mitigation**: Set the default `fontFamily = DmSans` or ensure components in this app use the defined scale (`titleMedium`, `bodyMedium`, `labelMedium`).
