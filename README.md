# Disney+ Hotstar

This project is a work-in-progress replica of the Disney+ Hotstar app, focusing on displaying
movies. The UI design is heavily inspired
by [Disney But Better](https://www.behance.net/gallery/141700011/Disney-But-Better) on Behance. It
is built using Jetpack Compose, the modern UI toolkit for building native Android apps.

## Screenshots

<p>
<img src="previews/Home_1.png" width="270" alt="Home"/>
<img src="previews/Home_2.png" width="270" alt="Home"/>
<img src="previews/Details_1.png" width="270" alt="Details"/>
<img src="previews/Details_2.png" width="270" alt="Details"/>
</p>

## Installation

- Clone the repository: git clone https://github.com/MansuriYamin/DisneyHotstar.git
- Open the project in Android Studio.
- Build and run the project on an Android emulator or physical device.

## Usage

- Upon launching the app, you'll be presented with a list of movies.
- Scroll through the list to browse available titles.
- Tap on a movie to view its details.
- On the movie details screen, you can see additional information such as genre, trailers, and
  ratings.
- Enjoy a sneak peek of what's to come as we continue development!

## Features and Technologies Used

- **[Jetpack Compose](https://developer.android.com/develop/ui/compose):** Modern UI toolkit for building native Android interfaces.
- **[Type-safe Navigation](https://medium.com/androiddevelopers/navigation-compose-meet-type-safety-e081fb3cf2f8):** Ensures compile-time safety for navigation between screens.
- **[Uni-directional Data Flow with UIState](https://developer.android.com/topic/architecture/ui-layer):** Used Uni-directional data flow pattern with UIState for managing and updating UI state in a predictable manner.
- **[Hilt](https://developer.android.com/training/dependency-injection/hilt-android):** Dependency injection library for Android that reduces the boilerplate code for managing dependencies.
- **[Shared Element Transition](https://developer.android.com/develop/ui/compose/animation/shared-elements):** Smooth transitions between screens, enhancing user experience.
- **[Predictive Back Gesture](https://developer.android.com/guide/navigation/custom-back/predictive-back-gesture):** Improved back navigation experience.
- **[Coil](https://coil-kt.github.io/coil/):** Image loading library for Android backed by Kotlin Coroutines.
- **[Custom Design System](https://developer.android.com/develop/ui/compose/designsystems/custom):** Developed a custom design system to maintain consistency and efficiency in UI development.
- **[Benchmarking](https://developer.android.com/topic/performance/benchmarking/benchmarking-overview):** Conducted performance benchmarks to evaluate app performance.
- **[Baseline Profile](https://developer.android.com/topic/performance/baselineprofiles/overview):** Established baseline profiles to monitor and optimize app resource usage.

## Contributions

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

- Fork the repository.
- Create a new branch (`git checkout -b feature/new-feature`).
- Make your changes and commit them (`git commit -am 'Add new feature'`).
- Push to the branch (`git push origin feature/new-feature`).
- Create a new pull request.

## Acknowledgements

- Thanks to Disney for the inspiration from their Hotstar app.
- Special thanks to the Jetpack Compose team for creating such a powerful UI toolkit.
- UI design heavily inspired by [Disney But Better](https://www.behance.net/gallery/141700011/Disney-But-Better) on Behance.
