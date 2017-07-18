This project implements a service to provide content metadata to client application by filtering the json content retrieved from the provider(external address).

The project is using springboot for implemnetation and mockito and junit for unit testing.

The project consists ContentProvider class which retrieves json data from the external url. 
MediaController class is a controller class and MediaService class consists actual logic to filter the media contents.



How to run:

1) Copy retrievmedia-0.0.1-SNAPSHOT.jar from the target folder.
2) execute jar file in terminal "java -jar retrievmedia-0.0.1-SNAPSHOT.jar"
3) open link "http://localhost:8080/media?filter=censoring&level=<censored or uncensored>"






