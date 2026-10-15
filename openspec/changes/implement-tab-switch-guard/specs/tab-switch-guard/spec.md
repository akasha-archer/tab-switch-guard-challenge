## Purpose

Guarantees that asynchronous tab data loading always matches the user's active tab selection, preventing outdated async results from overriding the UI when tabs are switched rapidly.

## ADDED Requirements

### Requirement: Tab navigation bar
The UI SHALL display tabs for "All", "Popular", "New", and "Sale" at the top of the screen, with the currently active tab visually highlighted with primary color indicator and text.

#### Scenario: User views top tabs
- **WHEN** the screen is displayed
- **THEN** tabs for "All", "Popular", "New", and "Sale" are rendered
- **AND** the currently selected tab is highlighted in the primary theme color

### Requirement: Immediate loading indicator on tab switch
When a tab is selected, the UI SHALL immediately transition to a loading state displaying a progress spinner and 'Loading "<TabName>"...', and previous content SHALL NOT remain visible.

#### Scenario: Switching tab immediately shows loading
- **WHEN** user taps a different tab
- **THEN** the UI immediately replaces previous content with the loading state for the selected tab

### Requirement: Simulated latency per category
Each tab category SHALL simulate asynchronous data retrieval with a specified delay: All (1200ms), Popular (700ms), Sale (500ms), and New (300ms).

#### Scenario: Data loads after category delay
- **WHEN** the All tab is selected and uninterrupted
- **THEN** the UI displays the 7 All products after 1200ms
- **WHEN** the Popular tab is selected and uninterrupted
- **THEN** the UI displays the 4 Popular products after 700ms
- **WHEN** the Sale tab is selected and uninterrupted
- **THEN** the UI displays the 3 Sale products after 500ms
- **WHEN** the New tab is selected and uninterrupted
- **THEN** the UI displays the 3 New products after 300ms

### Requirement: Outdated asynchronous operation cancellation
When the user switches tabs before an active loading operation completes, the prior loading operation SHALL be cancelled and its results SHALL NOT update the UI.

#### Scenario: Rapid switching does not clobber UI with stale data
- **WHEN** user selects the All tab (1200ms delay)
- **AND** user switches to the New tab (300ms delay) after 100ms
- **THEN** the New tab finishes loading at t=400ms and displays its 3 products
- **AND** the prior All tab operation is cancelled and never overwrites the New tab results
