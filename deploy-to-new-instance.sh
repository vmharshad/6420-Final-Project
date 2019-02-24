BUCKET=henry-book-store

gsutil mb gs://${BUCKET}

gsutil cp target/henry-books-services-0.0.1-SNAPSHOT.jar gs://${BUCKET}

gcloud compute instances create demo-instance \
--image-family debian-9 \
--image-project debian-cloud \
--machine-type f1-micro \
--scopes "userinfo-email,cloud-platform" \
--metadata-from-file startup-script=instance-startup.sh \
--metadata BUCKET=henry-book-store \
--zone us-east1-b \
--tags http-server
