# Multipart-Geometry
Demonstrate creation of Multipart Polygon, Polyline and Multipoint geometry using ArcGIS Maps SDK for Kotlin.

## Overview
This repository contains the code which is mentioned in the blog post `Mapping complex data with Multipart Geometries using the ArcGIS Maps SDKs for Native Apps.`

It creates collection of trees on Esri campus representing the multipoint geometry, adding a couple islands and a lake within an island representing a single multipart polygon geometry and creating four river streams constituting a single river which ultimately connects to the ocean representing multipart polyline geometry.

There are three example apps in this repo namely multipart-polygon-geometry, multipart-polyline-geometry and multipoint-geometry. Each of them can be run as an individual app.

Multipoint Geometry:  
  
![Multipoint-Geometry.png](img_3.png)

Multipart-Polygon-Geometry:  
  
![Multipart-Polygon-Geometry.png](img_4.png)

Multipart-Polyline-Geometry:  
  
![Multipart-Polyline-Geometry.png](img_5.png)


## Prerequisites

* The example apps in this project are building with `compileSdkVersion 33`
* [Android Studio](http://developer.android.com/sdk/index.html)
* [An ArcGIS Developers API key](https://developers.arcgis.com/kotlin/get-started/#3-get-an-api-key)


## Developer Instructions

Please read our [developer instructions wiki page](https://github.com/Esri/arcgis-maps-sdk-kotlin-samples/wiki/Developer-Instructions) to set up your developer environment with Android Studio.  Instructions include forking and cloning the repository for those new to Git.

Once the project is cloned to disk you can import into Android Studio:

* From the Welcome to Android Studio screen, click the **Open** button. (If you're already inside a project, click **File > Open** in the menu bar instead.)
* Navigate to the **Multipart_Geometry/** folder and click **OK**.


### API key

A permanent key that gives your application access to Esri location services. Visit your [ArcGIS Developers Dashboard](https://developers.arcgis.com/dashboard) to create a new API key or access an existing API key.
The Android samples in this repository have been structured to use an API key, set once, which will run in all samples.
Set your API key in the `gradle.properties` file located in the `/.gradle` folder within your home directory.
The API_KEY property should contain quotes around the key itself:
```gradle
API_KEY = "YOUR_API_KEY" // path: /Users/<user_name>/.gradle/gradle.properties
```

## Run an example app

Once you have set up your developer environment you can run any example app from within Android Studio by selecting the app module from the **Edit Configurations** drop down and clicking the **Run** button from the toolbar.


## Issues

Have a question about functionality in the ArcGIS Maps SDK for Kotlin? Want to ask other users for development advice, discuss a workflow, ask Esri staff and other users about bugs in the API? Use [GeoNet](https://community.esri.com/t5/kotlin-maps-sdk-questions/bd-p/kotlin-maps-sdk-questions) for any general questions like this, so others can learn from and contribute to the discussion.

Do you have something to [contribute](.github/CONTRIBUTING.md)? Send a pull request! New Samples, bug fixes and documentation fixes are welcome.

Have a problem running one of the samples in this repo? Does the sample not work on a specific device? Have questions about how the code in this repo is working? Want to request a specific sample? In that case, [submit a new issue](https://github.com/Esri/arcgis-maps-sdk-kotlin-samples/issues).

## Contributing

Anyone and everyone is welcome to [contribute](.github/CONTRIBUTING.md). We do accept pull requests.

1. Get Involved
2. Report Issues
3. Contribute Code
4. Improve Documentation

Please see our [guidelines for contributing doc](https://github.com/Esri/contributing/blob/master/README.md)

## Licensing

Copyright 2022 Esri

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

A copy of the license is available in the repository's [LICENSE](LICENSE?raw=1) file


