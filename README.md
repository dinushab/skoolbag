# Skoolbag application

This is a sample full stack implementation done for skoolbag. Two projects can be found in the repository;

1. skoolbag-frontend 	- Frontend web application written in Angular
2. skoolbag-backend	- Backend services written in Java spring boot

## Skoolbag-backend

Prerequisites to run the backend:
1. Java 8
2. Apache maven
3. Docker

Navigate to `skoolbag-backend` folder from the command line in windows or the terminal in Mac/Linux and run the following command.

	`mvn clean package -Pjib`
	
This will create a new docker image with the name skoolbag-backend and V1 as the tag.

Once this is done, run the following command to run the docker image generated by the preceeding command;

	`docker run -d -p 8080:8080 --restart always --name skoolbag-backend skoolbag-backend:v1`

This will initialize a server and the backend services will listen to the host port 8080

## Skoolbag-frontend

Running the front end.

#### Option 1

Prerequisites to build and run the frontend:
1. NodeJs
2. Angular CLI

Navigate to `skoolbag-frontend` folder from the command line in windows or the terminal in Mac/Linux and navigate to skoolbag-frontend folder. 

1. Run the following command to download the necessary dependencies
	
	`npm install`
	
2. Run the following command to compile the code and open the application in the browser
	
	`ng serve -o`

#### Option 2
Prerequisites to build and run the frontend:
1. Docker

Navigate to `skoolbag-frontend` folder from the command line in windows or the terminal in Mac/Linux and navigate to skoolbag-frontend folder. 

1. Run the following command to generate the docker image.

	`docker build -t skoolbag-frontend:v1 .`
	
2. Run the following command to run the docker image.

	`docker run -d -p 8090:80 --restart always --name skoolbag-frontend skoolbag-frontend:v1`
	
Above command will initialize the frontend application in a docker container. The container port 80 will be mapped to host port 8090 so that poining to `http://localhost:8090` in the host will open the application.
