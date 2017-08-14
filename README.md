# AndroidSimpleList
This sample fetches and display a list of data from an endpoint.
The goal of this project is to showcase a basic networking layer that includes background operations and json parsing to ultimately display the list of data to the user.
The problem was solved using a couple different libraries. 

## Libraries
To achieve the goal of this project, the following libraries were used:
* RxJava 2: used to handle API calls.
* Retrofit 2: used to handle this network call off of the main thread.
* Glide: used to fetch images from the web.
* DataBinding: used to bind data directly in XML.
* retrofit2:converter-gson: libarary for gson parsing.

## To Improve
Given that I was trying to do this as fast as possible, I decided to leave some architecture improvements for the future:
1) Use MVVM pattern. I would've preferred to separate the business logic from the views into view models. It's cleaner architecture since you are able to separate logic from views and it helps write cleaner unit tests.
2) Use Architecture Components. For new projects, I would follow the new Architecture Components since they solve a lot of problems faced with Android's lifecycle.
3) Handle rotation better. If you rotate the device you will notice that every is loaded again. That is not a good practice so ideally the data would be saved and redisplayed once the activity is recreated.
4) Use a fragment. Not as big of a deal but fragments are nice since they are easily reusable and amy be a more future proof UI (maybe different tablet layout.)
5) Keep app's configuration in a build file
6) Unit tests. An essential component to every app.

See photos of the app https://photos.google.com/share/AF1QipPzYJWdpJzVOh50qhpp-LNAwyptJXCge0UMFdpANNmh2eTDDWnGVkb94j32UuRBpQ?key=QXFqa1VHUGxDQkFKOEd6cnhiQUJWOEZTRmpVdG5R

### Notes
Add a real url to NetworkManager.BASE_URL for this to work properly.
