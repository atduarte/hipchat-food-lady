Registering the Webhook
=====================

1. Create a HipChat token with lots of permissions

1. Call the webhook endpoint

	curl -X POST "https://feedzai.hipchat.com//v2/room/Software%20Engineering/webhook" -H "Content-Type: application/json" -H "Authorization: Bearer <your token>" -d "{\"url\":\"http://hipchat-kudos-hipchat-kudos.7e14.starter-us-west-2.openshiftapps.com/hipchat-kudos/rest/kudos\",\"pattern\":\"^/kudos.*\",\"event\":\"room_message\",\"authentication\":\"jwt\",\"name\":\"Kudos\"}"

Testing the REST Endpoint locally
=================================

1. Download [wildfly](http://wildfly.org/downloads/)

1. Run wildfly with `sh bin/standalone.sh`

1. Build and deploy with `mvn clean install wildfly:deploy`

The REST endpoint is available on `http://localhost:8080/hipchat-kudos`.

