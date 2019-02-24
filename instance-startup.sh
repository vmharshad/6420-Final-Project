#!/bin/sh

# Set the metadata server to the get projct id
PROJECTID=$(curl -s "http://metadata.google.internal/computeMetadata/v1/project/project-id" -H "Metadata-Flavor: Google")
BUCKET=$(curl -s "http://metadata.google.internal/computeMetadata/v1/instance/attributes/BUCKET" -H "Metadata-Flavor: Google")
JAR='henry-books-services-0.0.1-SNAPSHOT.jar'

echo "Project ID: ${PROJECTID} Bucket: ${BUCKET} Jar: ${JAR}"

# Get the files we need
gsutil cp gs://${BUCKET}/${JAR} /tmp/
gsutil cp gs://${BUCKET}/${JAR} .

# Install dependencies
apt-get update
apt-get -y --force-yes install openjdk-8-jdk

# Make Java 8 default
update-alternatives --set java /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java

# Start server
java -jar ${JAR}
