# unitapp
This is an Android Application written in Kotlin to display a collection of properties loaded from a JSON url.

# Installation
Clone the repo and install the dependencies.

      git@github.com:maquadir/unitapp.git

# Architecture and Design
The application follows an MVVM architecture as given below

<img width="449" alt="Screen Shot 2019-12-25 at 8 05 55 AM" src="https://user-images.githubusercontent.com/19331629/71425127-6ca3cc00-26ed-11ea-98b5-a344b54b7050.png">

# Setup
### Manifest File
- Since the app is going to fetch from json url .We have to add the following internet permissions to the manifest file.
    
        <uses-permission android:name="android.permission.INTERNET" />
        <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
        <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

### Material Styling
- A progress bar is displayed during the async JSON read operation.

### Invoke JSON Url using Retrofit.Builder()
We have declared a Properties API interface to invoke the JSON url using Retrofit.Builder()

         return Retrofit.Builder()
                .baseUrl(BASE_URl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build().create(PropertiesApi::class.java)

### Model
A Modelcontains all the data classes, database classes, API and repository.
A Property data class is created using "JSON to Kotlin class" plugin to map the JSON data to Kotlin. A Properties Service class to handle api requests and a repository takes care of how data will be fetched from the api.
              
              data class Property (
                     val ad_id : Int,
                     var data: data
                  )
                  
              val propertiesService = PropertiesService()
              val repository = PropertiesRepository(propertiesService)

### View Model
We set up a view model factory which is responsible for creating view models.It contains the data required in the View and translates the data which is stored in Model which then can be present inside a View. ViewModel and View are connected through Databinding and the observable Livedata.

### Coroutines
Coroutines are a great way to write asynchronous code that is perfectly readable and maintainable. We use it to perform a job of reading data from the JSON url.

### View
It is the UI part that represents the current state of information that is visible to the user.A Recycler View displays the data read from the JSON. We setup a recycler view adapter to take care of displaying the data on the view.
We use Glide to display profile image using view binding

### Dependency Injection
Constructor dependency injection has been used at multiple instances.It allows for less code overall when trying to get reference to services you share across classes, and decouples components nicely in general

### View Binding
The View Binding Library is an Android Jetpack library that allows you to create class files for the XML layouts.All the UIView elements in the layout are binded to the class program through view binding.

# Screenshot

<img width="314" alt="image" src="https://user-images.githubusercontent.com/19331629/165742648-09d4e84d-0bbc-4353-97c3-ad34c8674e97.png">

