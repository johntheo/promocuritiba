# Install Postgres Ubuntu 18.04

sudo apt update
sudo apt-get install postgresql postgresql-contrib
sudo -i -u postgres
psql
alter user postgres with password 'postgres';
