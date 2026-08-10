# learnCmp

Compose Multiplatform application targeting Android and iOS.

## Structure

- `composeApp/src/commonMain`: shared Compose UI, Clean Architecture layers, Koin and Ktor.
- `composeApp/src/androidMain`: Android entry point and Ktor OkHttp engine.
- `composeApp/src/iosMain`: iOS entry point and Ktor Darwin engine.
- `iosApp`: native Swift/Xcode application that hosts the shared Compose UI.

The Splash and Login screens, UI components, ViewModel, domain use case and data repository are shared by Android and iOS.

## Android

```powershell
.\gradlew.bat :composeApp:assembleDebug
```

## iOS

Open `iosApp/iosApp.xcodeproj` with Xcode on macOS and run the `iosApp` scheme.
