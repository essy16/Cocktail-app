 # Cocktail App🍹

## Overview
This project is a cocktail recipe app that provides users with a collection of cocktail recipes. It follows a modern Android architecture using Jetpack Compose for the user interface, ViewModel for managing data, Dagger/Hilt for dependency injection, Coil for image loading, Retrofit for network requests, and MVVM for a clean and maintainable codebase.

## Features
- Browse a list of cocktail recipes.
- View detailed information about each cocktail.
- Search for cocktails by name or ingredient.
- Save favorite cocktails for quick access.
- Share cocktail recipes with friends.

## Technologies Used
- **Jetpack Compose**: Used for building the user interface, providing a modern and declarative approach to UI development.
- **ViewModel**: Manages UI-related data and communicates with the data layer.
- **Dagger/Hilt**: For dependency injection, ensuring a modular and maintainable codebase.
- **Coil**: Efficiently loads and displays images in the app.
- **Retrofit**: Handles network requests and data retrieval from a remote server.
- **MVVM Architecture**: Ensures separation of concerns and maintainability of the codebase.
- **Clean Architecture**: Promotes a clean separation of layers, making the app more testable and scalable.

## Architecture Overview
The project follows the principles of Clean Architecture, consisting of three main layers:

1. **Presentation Layer**: Jetpack Compose components and ViewModels reside here, responsible for rendering UI and handling user interactions.

2. **Domain Layer**: Contains business logic, use cases, and domain models. It's independent of the Android framework.

3. **Data Layer**: Manages data sources, repositories, and network communication. Retrofit is used to fetch data from a remote server.

## Dependencies
- [Dagger/Hilt](https://dagger.dev/hilt/): For dependency injection.
- [Coil](https://coil-kt.github.io/coil/): For image loading.
- [Retrofit](https://square.github.io/retrofit/): For network requests.
- [Jetpack Compose](https://developer.android.com/jetpack/compose): For building the UI.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): For managing UI-related data.
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines): For handling asynchronous operations.
## Firebase Integration
- **Firebase Authentication**: Secure user authentication for enhanced app functionality.

## SplashScreen API
- **SplashScreen API**: Improved app startup experience with a custom animated splash screen.

## SCREENSHOTS
![Introduction Screen](C:\Users\essy\Documents\Screenshot_20240121_135544_Cocktail app.jpg)
![Log in Screen](C:\Users\essy\Documents\Screenshot_20240121_135602_Cocktail app.jpg)
![Sign up Screen](C:\Users\essy\Documents\Screenshot_20240121_135608_Cocktail app.jpg)
![Home Screen](C:\Users\essy\Documents\Screenshot_20240121_135657_Cocktail app.jpg)
![Search Screen](C:\Users\essy\Documents\Screenshot_20240121_135710_Cocktail app.jpg)

## Architecture
The app is built using the Modular MVVM architectural pattern and makes heavy use of a couple of Android Jetpack components. MVVM allows for the separation of concern which also makes testing easier.
![Clean architecture](https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg)


## Getting started
To get a local copy up and running follow these simple example steps.
   ```bash
   git clone  https://github.com/essy16/Cocktail-app.git

 ```
   
 
## 🤝 Contribution
Contributions, issues, and feature requests are welcome!
- Create a new branch for your feature or bug fix:
  
  `git checkout -b feature-name`

- Make your changes and commit them with a descriptive commit message:
  
  `git commit -m "Add feature XYZ"`
- Push your changes
  
  `git push origin feature-name`

- Create a PR to the **master** branch





