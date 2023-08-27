pipeline {
  agent {
    docker {
      image 'hiransanjeewa/springboot_microservices_base_image'
      args '--user root -v /var/run/docker.sock:/var/run/docker.sock' // mount Docker socket to access the host's Docker daemon
    }
  }

  stages {
    stage('Checkout') {
      steps {
        sh 'echo passed'
        git branch: 'main', url: 'https://github.com/Hiransanjeewa/Microservices-Ecommerce-Backend.git'
      }
    }
    stage('Build and Test') {
      steps {
        sh 'ls -ltr'
        // build the project and create a JAR file

        sh 'cd ConfigServer && mvn clean package'
      }
    }
    stage('Static Code Analysis') {
      environment {
        SONAR_URL = "http://34.133.164.237:9000"
      }
      steps {
        withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
          sh 'ls -ltr'
          sh 'mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}'
        }
      }
    }



    // stage('Build and Push Docker Image') {
    //   environment {
    //     DOCKER_IMAGE = "hiransanjeewa/springboot_ci_cd:${BUILD_NUMBER}"
    //     // DOCKERFILE_LOCATION = "java-maven-sonar-argocd-helm-k8s/spring-boot-app/Dockerfile"
    //     REGISTRY_CREDENTIALS = credentials('Dockerhub-Credentials')
    //   }
    //   steps {
    //     script {
    //         sh 'cd java-maven-sonar-argocd-helm-k8s/spring-boot-app && docker build -t ${DOCKER_IMAGE} .'
    //         def dockerImage = docker.image("${DOCKER_IMAGE}")
    //         docker.withRegistry('https://index.docker.io/v1/', "Dockerhub-Credentials") {
    //             dockerImage.push()
    //         }
    //     }
    //   }
    // }
    
    // stage('Update Deployment File') {
    //     environment {
    //         GIT_REPO_NAME = "Jenkins-Zero-To-Hero"
    //         GIT_USER_NAME = "hiransanjeewa"
    //     }
    //     steps {
    //         withCredentials([string(credentialsId: 'github', variable: 'GITHUB_TOKEN')]) {
    //             sh '''
    //                 git config user.email "abhishek.xyz@gmail.com"
    //                 git config user.name "Abhishek Veeramalla"
    //                 BUILD_NUMBER=${BUILD_NUMBER}
    //                 sed -i "s/replaceImageTag/${BUILD_NUMBER}/g" java-maven-sonar-argocd-helm-k8s/spring-boot-app-manifests/deployment.yml
    //                 git add java-maven-sonar-argocd-helm-k8s/spring-boot-app-manifests/deployment.yml
    //                 git commit -m "Update deployment image to version ${BUILD_NUMBER}"
    //                 git push https://${GITHUB_TOKEN}@github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:main
    //             '''
    //         }
    //     }
    // }
  }



}