pipeline {
    agent any

    environment {
        TEST_RESULTS_DIR = 'target'  // Directory inside the container where results will be stored
    }
    stages {
        stage('Checkout') {
            steps {
                // Check out the source code from the repository
                checkout scm
            }
        }

        stage('Build the test image') {
            steps {
                script {
                    // Install Python (optional: this can be handled by Docker)
                    docker build -t qubika-java-test:${buildId} .
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run the tests using the docker image
                    sh """
                    docker run --rm -v ${WORKSPACE}/${env.TEST_RESULTS_DIR}:${env.TEST_RESULTS_DIR} qubika-java-test:${buildId}
                    """
                }
            }
        }

        stage('Archive Test Results') {
            steps {
                script {
                    // Archive the test results in Jenkins (Jenkins expects an XML format)
                    junit "${WORKSPACE}/${env.TEST_RESULTS_DIR}/surefire-reports/testng-results.xml"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }

        success {
            echo "Tests passed successfully!"
        }

        failure {
            echo "Tests failed. Check the logs for more information."
        }
    }
}
