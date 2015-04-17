# clj-hh-tesla-sample

Example code for the [April 2015 meetup](http://www.meetup.com/ClojureUserGroupHH/events/220246768/) of the clojure user group Hamburg.

Slides are here: [tesla-clj-hh-16-4-2015.pdf](tesla-clj-hh-16-4-2015.pdf)

## Usage

* Download, install and run [zookeeper](http://zookeeper.apache.org/).
* Create node ```/liga1/hsv``` with the current position of the HSV. (0 if not in Liga 1)
* Grant write access to Bruno Labbadia.
* In ```resources/default.properties``` change ```zookeeper.connect``` if necessary.
* ```lein run```
* Open [localhost:8080](localhost:8080) in your browser.
