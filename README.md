# NASA Image app
### SENG 5199(001)
## Overview
This application, when launched, makes a network API call to NASA's website and pulls down five images from the APOD
end point.
The images are displayed as thumbnail and are clickable to for a larger view.

## External libraries
* Retrofit - for making Internet calls
* Coil - for displaying images asynchronously.

## Overview of the files:
* network/ApiService.kt - contains Retrofit API configuration for making the network call.
* MainViewModel - contains contains the MainViewModel class (base ViewModel()).
* Image - contains the data class for the json response NASA's APOD endpoint.
* MainActivity.kt - contain all the composable functions for the UI.

## API_KEY: 
This project uses the default api key(DEMO_KEY) provided by NASA's API.
replace the API_KEY constant in the ApiService.kt file with your own API.
## Dependencies (add to build.gradle):
### Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
### Coil
    implementation("io.coil-kt:coil-compose:2.5.0")
## Permissions (add to AndroidManifest)
    <uses-permission android:name="android.permission.INTERNET"/>