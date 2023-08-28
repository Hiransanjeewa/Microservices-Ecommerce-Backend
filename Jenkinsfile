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

     stage('Build and Testing Loop') {
            steps {
                script {
                    def microservices = ['config-server', 'service-registry', 'login-service', 'register-service', 'api-gateway']  // Add your microservice names here
                    
                    for (def service in microservices) {
                      
                        stage("Build and Test - ${service}") {
                            // Your stage steps go here
                            sh "cd ${service} && mvn clean package"
                        }
                        // stage("Static Code Analysis - - ${service}") {
                        //   environment {
                        //     SONAR_URL = "http://34.133.164.237:9000"
                        //   }
                        //   steps {
                        //     withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
                              
                        //       sh "cd ${service} && mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}"
                        //     }
                        //   }
                        // }
                      

                    }
                }

            }
        }


  //    stage('Build and Test') {
  //      steps {
  //        sh 'ls -ltr'
  //        // build the project and create a JAR file

  //        sh 'cd config-server && mvn clean package'

  //      }
  //    }
    //  stage('Static Code Analysis') {
    //    environment {
    //      SONAR_URL = "http://34.133.164.237:9000"
    //    }
    //    steps {
    //      withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
    //        sh 'ls -ltr'
    //        sh 'cd ConfigServer && mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}'
    //      }
    //    }
    //   }

    stage('Build and Push Docker Images') {
      environment {
        DOCKER_IMAGE = "hiransanjeewa/config-server:${BUILD_NUMBER}"
        // DOCKERFILE_LOCATION = "java-maven-sonar-argocd-helm-k8s/spring-boot-app/Dockerfile"
        REGISTRY_CREDENTIALS = credentials('Dockerhub-Credentials')
      }
      steps {
        script {
           
            def microservices = ['config-server', 'service-registry', 'login-service', 'register-service', 'api-gateway']  // Add your microservice names here

            docker.withRegistry('https://index.docker.io/v1/', "Dockerhub-Credentials") {
                // dockerImage.push()
              for (def serviceName in microservices) {
                   
                sh "cd ${serviceName} && mvn package dockerfile:push"
                sh 'cd ../'
              }
            
            }
        }
      }
     }

  //   stage('Checkout K8S manifest SCM') {
  //       steps {
  //           sh '''
           

  //           '''
  //           git credentialsId: 'Github-Credentials', 
  //               url: 'https://github.com/Hiransanjeewa/Microservices-Backend-Manifests.git',
  //               branch: 'main'

            
  //           }
            
  //   }
    
  //   stage('Update Deployment File') {
  //       environment {
  //           GIT_REPO_NAME = "Microservices-Backend-Manifests"
  //           GIT_USER_NAME = "Hiransanjeewa"
  //       }
  //       steps {
  //           withCredentials([string(credentialsId: 'github', variable: 'GITHUB_TOKEN')]) {
  //               sh '''

  //                   git config --global user.email "hiransanjeewaa@gmail.com"
  //                   git config --global user.name "Hiransanjeewa"

  //                   cd deployments
                    
  //                   chmod +rwx config-server-service.yaml
  //                   sed -i "s/config-server:[0-9]*/config-server:${BUILD_NUMBER}/g" config-server-service.yaml
  //                   cat config-server-service.yaml
  //                   cd ../
  //                   git config --global --add safe.directory /var/lib/jenkins/workspace/Microservices-Backend

  //                   git add deployments
  //                   git commit -m 'config-server-service.yaml | Jenkins Pipeline'
  //                   git remote -v
  //                   git push https://${GITHUB_TOKEN}@github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:main



  //                  '''
  //           }
  //       }
  //   }
    
    }
  post {
    always {
      cleanWs() // Clean the workspace at the end of the pipeline
    }
  }



}
                   
                   //       chmod -R g+w ConfigServer
                    // 
                    //  
                    // cat deploy.yml
                    // cd ../
                    // git status
                    // git add .
                    // git commit -m 'Updated the deploy yml | Jenkins Pipeline'
                    // git remote -v
                    // git push https://${GITHUB_TOKEN}@github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:main
  