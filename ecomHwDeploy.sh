#!/bin/sh
heroku login -i

heroku create ec18a002

heroku plugins:install java
heroku war:deploy ./ecomhw/testrest/target/testrest.war --app ec18a002
