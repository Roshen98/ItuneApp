# Music Itune App

Developed an application to view Rock, Classic and Pop Artists in three different tabs. 

Materials Provided: 
1 Material Tabs (Base code project)
2 Tested API’s

API to parse

Tab 1:
https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50

Tab 2:
https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50

Tab 3:
https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50


Use Case 1:As a user I must be able to view the list of all Artist in all three tabs.
Classic Tab should load:
https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50

Pop Tab should load:
https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50

Rock Tab should load:
https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50

Data to Load: (Json Object to display)
"artistName": 
"collectionName": 
"artworkUrl60":
"trackPrice": 
Screen Shot:


Use Case 2: As a user  
When I click on one of the items of the recyclerview in Classic tab, I must play the artist music.
Data to Load:
  "previewUrl"
(Use implicit intents)

Use Case 3: As a user  
I must be able to refresh the list using SwipeToRefreshLayout.
