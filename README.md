# 🎬 CocCocApp

A modern Android application built to demonstrate **Clean Architecture**, **Jetpack Compose**, and **Offline-First** principles. 
## 📱 Features

* **Article list:** 
* **Reading article** 
* **Image downloading** 
* **Content summarization**

## 🛠 Tech Stack

* **Language:** [Kotlin](https://kotlinlang.org/)
* **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material3)
* **Architecture:** Clean Architecture (Presentation, Domain, Data layers) + MVVM
* **Dependency Injection:** [Hilt](https://dagger.dev/hilt/)
* **Network:** [Retrofit](https://square.github.io/retrofit/) + [OkHttp](https://square.github.io/okhttp/)
* **Local Database:** [Room](https://developer.android.com/training/data-storage/room)
* **Concurrency:** Coroutines + Flow
* **Image Loading:** [Coil](https://coil-kt.github.io/coil/)
* **Navigation:** Compose Navigation

## 🏗 Architecture

The project follows the principles of **Clean Architecture** to ensure separation of concerns and testability:

1.  **Presentation Layer:** ViewModels and Compose UI.
2.  **Domain Layer:** UseCases and Repository Interfaces (Pure Kotlin, no Android dependencies).
3.  **Data Layer:** Repository Implementations, API (Retrofit), and Database (Room).

## 🚀 Setup & Installation

To run this project, you will need to configure the TMDB API key.

### 1. Get an API Key
1.  (https://api.spaceflightnewsapi.net/v4/articles/)

### 2. Configure the Project
1.  Clone this repository.
2.  Open the project in Android Studio.
3.  Open the `local.properties` file in the root directory (this file is ignored by Git).
4.  Add your API key in the following format:

```properties
sdk.dir=...
tmdb.api.key=YOUR_ACTUAL_API_KEY_HERE
