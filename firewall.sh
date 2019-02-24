gcloud compute firewall-rules create default-allow-http-8080 --allow tcp:8080 --source-ranges 0.0.0.0/0 --target-tags http-server --description "Allow HTTP access to port 8080"
"
