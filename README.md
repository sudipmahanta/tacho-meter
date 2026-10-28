## Build and run
Needs Android Studio, JDK 17+ and an emulator/device on Android 8.0+ (API 26).

## Folder structure
```
app/src/main/java/com/simple/energy/
├── MainActivity.kt        # wires data source → repository → ViewModel → UI
├── data/                  # fake telemetry stream, filtering, unit conversion
└── ui/                    # ViewModel, state and all dashboard composables
```

## Approach
`VehicleDataSource` emits fake readings every second. `TelemetryRepository` drops invalid or stale ones. `VehicleViewModel` exposes the result as a `StateFlow`, and `VehicleDashboard` renders it. Colors are all in `AppColor`.

## Assumptions and limitations
- Telemetry is simulated, with no real vehicle connection.
- Battery level is a **random number** (10–80), not real data.
- Indicators are static.
- Layout is meant for landscape or tablet screens.


# tacho-meter
