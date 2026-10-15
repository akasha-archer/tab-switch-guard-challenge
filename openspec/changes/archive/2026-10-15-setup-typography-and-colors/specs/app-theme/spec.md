## Purpose

Provides a centralized visual theme configuration including custom color tokens, DM Sans typography scale, and light mode styling for the application.

## ADDED Requirements

### Requirement: Application defines custom color tokens
The theme SHALL define brand color values for background (#EDF0F6), onBackground (#526881), surface (#FFFFFF), onSurface (#18181B), onSurfaceVariant (#909090), outline (#D8E4EA), and primary (#118CFF).

#### Scenario: Color scheme exposes brand colors
- **WHEN** the application retrieves colors from `MaterialTheme.colorScheme`
- **THEN** `background` resolves to `#EDF0F6`
- **AND** `onBackground` resolves to `#526881`
- **AND** `surface` resolves to `#FFFFFF`
- **AND** `onSurface` resolves to `#18181B`
- **AND** `onSurfaceVariant` resolves to `#909090`
- **AND** `outline` resolves to `#D8E4EA`
- **AND** `primary` resolves to `#118CFF`

### Requirement: Application defines DM Sans typography scale
The theme SHALL configure Material 3 Typography using the DM Sans font family with specific weights, sizes, and line-heights for Subtitle, Body, and Label styles.

#### Scenario: Typography scale applies defined font weights and sizes
- **WHEN** text composables apply `MaterialTheme.typography`
- **THEN** Subtitle (`titleMedium`) uses DM Sans Medium at 16sp with 130% (20.8sp) line height
- **AND** Body (`bodyMedium`) uses DM Sans Regular at 14sp with 140% (19.6sp) line height
- **AND** Label (`labelMedium`) uses DM Sans Regular at 12sp with 130% (15.6sp) line height

### Requirement: App theme disables dynamic color and enforces light palette
The `TabswitchguardTheme` SHALL use the light color scheme and disable Android dynamic color theming so branded colors are consistently rendered across all device versions.

#### Scenario: Dynamic colors do not override brand palette
- **WHEN** `TabswitchguardTheme` is invoked on an Android 12+ device
- **THEN** dynamic color theming is disabled by default (`dynamicColor = false`)
- **AND** the app renders using the custom light color scheme
