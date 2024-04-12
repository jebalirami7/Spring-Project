# Spring-Project

Welcome to Springboot Project.

## Table of Contents

1. [About](#about)
2. [Installation](#installation)
3. [Usage](#usage)
4. [Git WorkFlow](#git-workflow)  

## About

An online tutoring platform.  

This project consists of a `client` directory containing Angular files and a `server` directory containing Springboot files.

## Installation

Include step-by-step instructions on how to install and set up your project locally.

### Prerequisites

Before you begin, ensure you have the following prerequisites installed:

#### For Spring Boot (Backend)

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html): Java is required to run Spring Boot applications. Make sure to have JDK 11 or later installed.

- [Maven](https://maven.apache.org/): Maven is used as a build automation tool for Java projects. Make sure to have Maven installed.

- IDE (Integrated Development Environment) such as [Eclipse](https://www.eclipse.org/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/): Optional, but recommended for development.

#### For Angular (Frontend)

- [Node.js](https://nodejs.org/): Node.js is required to run Angular applications. Make sure to have Node.js installed. 

  You can check if Node.js is installed on your system by running the following commands in your terminal or command prompt:

  ```bash
  node --version

### Installation Steps

Provide instructions for setting up the project locally as follows.

1. Clone the repository.
2. Navigate to the `client` directory.
3. Run `npm install` to install dependencies.

```bash
git clone https://github.com/jebalirami7/Spring-Project.git
cd Spring-Project
cd client
npm install
```

## Usage

### Backend (Spring Boot)

1. Navigate to the `server` directory.
2. Run `mvn spring-boot:run` to start the Spring Boot server.

```bash
cd server
mvn spring-boot:run
```

### Frontend (Angular)

1. Navigate to the `client` directory.
3. Run `ng serve` to start the Angular development server.


```bash
cd client
ng serve
```

## Git Workflow
### Workflow  
* main branch will be used only for deployment.  
* dev branch will be used for working/development.
* When working on a feature create a new branch from dev.  
* Pull changes from remote before you start working and before pushing.  
* Pushing code require pull request.  
* Chech the [Docs](docs/README.md) for every day git command.
