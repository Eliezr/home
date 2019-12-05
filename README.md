# home
my home repository
apt-get install docker.io
systemctl status docker
systemctl enable docker
systemctl start docker
docker run hellow-world
docker images
docker ps -a
docker pull ubuntu:16.04
docker run -ti ubuntu:16.04
apt-get update ------updating the ubuntu os 
apt-get install -y apche2 ---
-----copy container id: 3656498208f0
 
docker commit <container-id> ubuntu-apache2
docker run -ti ubuntu-apache2
docker run -ti -p 9090:80 --name myweb <image-id>
service apche2 restart

----on container: <ip address>
172.17.0.2/16

going back to container apache2
docker run -ti <image-id>

apt-get install -y git
apt-get install -y openjdk-8-jdk
-----------------------
Download Jenkins.
Open up a terminal in the download directory.
Run java -jar jenkins.war --httpPort=8080.
Browse to http://localhost:8080.

git clone git-repo-url
ls
----create a program file and save to repository
git add -A
git config --global user.name "Eliezr"
git config --global user.email "eliazerlee@gmail.com"
git commit -m "a new file"
