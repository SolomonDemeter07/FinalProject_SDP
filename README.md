# Final Project — Unified Fitness Tracker System

## Overview
A cohesive Java application integrating **8 distinct Design Patterns** (2 per team member across 4 students) organized into dedicated packages under `fitnesstracker`. The system models a smart fitness ecosystem capable of building custom powerlifting and cardio recovery plans, launching training sessions, adapting incompatible wearable device SDKs (Apple Watch and Garmin), monitoring heart-rate zones in real time, dynamically switching calorie calculation algorithms, exporting multi-format reports, and auditing weekly training volume.

## Team & Pattern Role Mapping

| Team Member | Pattern | Category | Package | Classes Implemented |
| :--- | :--- | :--- | :--- | :--- |
| **Askhat (Team Lead)** | **Builder** | Creational | `fitnesstracker.builder` | `WorkoutPlan`, `WorkoutBuilder`, `PowerliftingBuilder`, `CardioRecoveryBuilder`, `WorkoutDirector` |
| **Askhat (Team Lead)** | **Facade** | Structural | `fitnesstracker.facade` | `FitnessTrackerFacade` |
| **Alikhan** | **Factory Method** | Creational | `fitnesstracker.factory` | `WorkoutActivity`, `StrengthActivity`, `CardioActivity`, `ActivityCreator`, `StrengthActivityCreator`, `CardioActivityCreator` |
| **Alikhan** | **Adapter** | Structural | `fitnesstracker.adapter` | `WearableSensor`, `AppleWatchSdk`, `GarminLegacyDevice`, `AppleWatchAdapter`, `GarminDeviceAdapter` |
| **Sanzhar** | **Observer** | Behavioral | `fitnesstracker.observer` | `HeartRateSubject`, `HeartRateObserver`, `LiveHeartRateTracker`, `MobileAppObserver`, `CoachAlertObserver` |
| **Sanzhar** | **Strategy** | Behavioral | `fitnesstracker.strategy` | `CalorieStrategy`, `HeavyLiftingCalorieStrategy`, `InclineWalkCalorieStrategy`, `HiitCalorieStrategy`, `CalorieCalculator` |
| **Iskander** | **Bridge** | Structural | `fitnesstracker.bridge` | `TrackerReport`, `DailyWorkoutReport`, `BiometricHealthReport`, `ReportFormatter`, `PlainTextFormatter`, `JsonReportFormatter` |
| **Iskander** | **Visitor** | Behavioral | `fitnesstracker.visitor` | `LogElement`, `LogVisitor`, `WeightliftingLog`, `TreadmillLog`, `TotalVolumeVisitor`, `RecoveryAdvisorVisitor` |
| **Entry Point** | **Client** | Application | `fitnesstracker` | `Main` |

## Package Structure
```text
src/
└── fitnesstracker/
    ├── Main.java
    ├── adapter/
    │   ├── AppleWatchAdapter.java
    │   ├── AppleWatchSdk.java
    │   ├── GarminDeviceAdapter.java
    │   ├── GarminLegacyDevice.java
    │   └── WearableSensor.java
    ├── bridge/
    │   ├── BiometricHealthReport.java
    │   ├── DailyWorkoutReport.java
    │   ├── JsonReportFormatter.java
    │   ├── PlainTextFormatter.java
    │   ├── ReportFormatter.java
    │   └── TrackerReport.java
    ├── builder/
    │   ├── CardioRecoveryBuilder.java
    │   ├── PowerliftingBuilder.java
    │   ├── WorkoutBuilder.java
    │   ├── WorkoutDirector.java
    │   └── WorkoutPlan.java
    ├── facade/
    │   └── FitnessTrackerFacade.java
    ├── factory/
    │   ├── ActivityCreator.java
    │   ├── CardioActivity.java
    │   ├── CardioActivityCreator.java
    │   ├── StrengthActivity.java
    │   ├── StrengthActivityCreator.java
    │   └── WorkoutActivity.java
    ├── observer/
    │   ├── CoachAlertObserver.java
    │   ├── HeartRateObserver.java
    │   ├── HeartRateSubject.java
    │   ├── LiveHeartRateTracker.java
    │   └── MobileAppObserver.java
    ├── strategy/
    │   ├── CalorieCalculator.java
    │   ├── CalorieStrategy.java
    │   ├── HeavyLiftingCalorieStrategy.java
    │   ├── HiitCalorieStrategy.java
    │   └── InclineWalkCalorieStrategy.java
    └── visitor/
        ├── LogElement.java
        ├── LogVisitor.java
        ├── RecoveryAdvisorVisitor.java
        ├── TotalVolumeVisitor.java
        ├── TreadmillLog.java
        └── WeightliftingLog.java
```

## How to Build and Run

### Using IntelliJ IDEA
1. Open the project folder in IntelliJ IDEA.
2. Open `src/fitnesstracker/Main.java`.
3. Click the green **Run** icon next to `public static void main(String[] args)`.

### Using Terminal (Command Line)
1. Compile all source files from the project root directory:
   ```bash
   javac -d out src/fitnesstracker/**/*.java src/fitnesstracker/*.java
   ```
2. Run the application:
   ```bash
   java -cp out fitnesstracker.Main
   ```

## Sample Console Output
```text
=== SCENARIO 1: HEAVY POWERLIFTING SESSION WITH APPLE WATCH ===
[Builder] Constructed: WorkoutPlan [WarmUp=Rotator cuff warm-up and dynamic mobility | Main=Squat 5x5, Bench Press 5x5, Deadlift 3x3 | Accessories=Weighted dips 3x10, Barbell rows 4x8 | Cardio=None]
[FactoryMethod] Executing heavy barbell compound session for 75 minutes.
[Observer - MobileApp] Athlete Dias live pulse from Apple Watch Ultra (via Adapter): 147 BPM
[Observer - CoachAlert] Heart rate (147 BPM) is within optimal training zone.
=== Daily Workout Summary ===
Plan: WorkoutPlan [WarmUp=Rotator cuff warm-up and dynamic mobility | Main=Squat 5x5, Bench Press 5x5, Deadlift 3x3 | Accessories=Weighted dips 3x10, Barbell rows 4x8 | Cardio=None]
Total Burn: 704.0 kcal
==============================
[Bridge - Runtime Format Switch] { "reportTitle": "Daily Workout Summary", "payload": "Plan: WorkoutPlan [WarmUp=Rotator cuff warm-up and dynamic mobility | Main=Squat 5x5, Bench Press 5x5, Deadlift 3x3 | Accessories=Weighted dips 3x10, Barbell rows 4x8 | Cardio=None] | Total Burn: 704.0 kcal" }

=== SCENARIO 2: ACTIVE RECOVERY SESSION WITH GARMIN LEGACY DEVICE ===
[Builder] Constructed: WorkoutPlan [WarmUp=Full body foam rolling 10 min | Main=Light core stability drills | Accessories=Stretching | Cardio=Incline treadmill walk: 50 min, 12% incline, 4 km/h]
[FactoryMethod] Executing endurance heart-rate zone session for 50 minutes.
[Observer - MobileApp] Athlete Dias live pulse from Garmin Fenix Pro (via Adapter): 172 BPM
[Observer - CoachAlert] WARNING! High heart rate detected (172 BPM). Recommend extending rest interval.
[Strategy] Active recovery calories burned: 558.0 kcal
=== Biometric Health Report ===
Source: Garmin Fenix Pro (via Adapter)
Peak Heart Rate: 172 BPM
Daily Steps: 12300
==============================

=== SCENARIO 3: POST-WORKOUT LOG ANALYTICS VIA VISITOR ===
[Visitor - VolumeAudit] Total Iron Tonnage: 6125.0 kg | Cardio Distance: 3.33 km
[Visitor - RecoveryAdvisor] Recommended nervous system recovery time: 56 hours
```