# NASA Image app
### SENG 5199(001)
## Overview
This application makes a network API call to NASA's website and pulls down five images from the APOD
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