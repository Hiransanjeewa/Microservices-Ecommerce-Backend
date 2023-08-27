pipeline {
  agent {
    docker {
      image 'hiransanjeewa/springboot_ci_cd'
      args '--user root -v /var/run/docker.sock:/var/run/docker.sock'

      // args '--user root -v /var/run/docker.sock:/var/run/docker.sock' // mount Docker socket to access the host's Docker daemon
    }
  }

  stages {
    stage('Checkout') {
      steps {
        sh 'echo passed'
        git branch: 'main', url: 'https://github.com/Hiransanjeewa/Microservices-Ecommerce-Backend.git'
      }
    }
    // stage('Build and Test') {
    //   steps {
    //     sh 'ls -ltr'
    //     // build the project and create a JAR file

    //     sh 'cd ConfigServer && mvn clean package'
    //   }
    //   }
    // stage('Static Code Analysis') {
    //   environment {
    //     SONAR_URL = "http://34.133.164.237:9000"
    //   }
    //   steps {
    //     withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
    //       sh 'ls -ltr'
    //       sh 'cd ConfigServer && mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}'
    //     }
    //   }
    // // }

    // stage('Build and Push Docker Image') {
    //   environment {
    //     DOCKER_IMAGE = "hiransanjeewa/microservices-backend:config-server"
    //     // DOCKERFILE_LOCATION = "java-maven-sonar-argocd-helm-k8s/spring-boot-app/Dockerfile"
    //     REGISTRY_CREDENTIALS = credentials('Dockerhub-Credentials')
    //   }
    //   steps {
    //     script {
    //         sh 'docker -v'
    //         sh ' cd ConfigServer && docker build -t ${DOCKER_IMAGE} .'
    //         def dockerImage = docker.image("${DOCKER_IMAGE}")
    //         docker.withRegistry('https://index.docker.io/v1/', "Dockerhub-Credentials") {
    //              dockerImage.push()
    //         // sh ' cd ConfigServer && mvn package dockerfile:push'
    //         }
    //     }
    //   }
    // }

    stage('Checkout K8S manifest SCM') {
        steps {
            git credentialsId: 'github', 
                url: 'https://github.com/Hiransanjeewa/Microservices-Backend-Manifests.git',
                branch: 'main'
            }
        }
    
    stage('Update Deployment File') {
        environment {
            GIT_REPO_NAME = "Microservices-Backend-Manifests"
            GIT_USER_NAME = "Hiransanjeewa"
        }
        steps {
            withCredentials([string(credentialsId: 'github', variable: 'GITHUB_TOKEN')]) {
                sh '''

                    ls
                    pwd
                    cd ConfigServer


                   '''
            }
        }
    }
  }



}

                   
                    // chmod +rwx deploy.yml
                    // sed -i "s/django:[0-9]*/django:${BUILD_NUMBER}/g" deploy.yml  
                    // cat deploy.yml
                    // cd ../
                    // git status
                    // git add .
                    // git commit -m 'Updated the deploy yml | Jenkins Pipeline'
                    // git remote -v
                    // git push https://${GITHUB_TOKEN}@github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:main
  
