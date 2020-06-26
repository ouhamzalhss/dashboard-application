node{
	def mvnHome

	stage('Prepare'){
	  git 'git@github.com:ouhamzalhss/dashboard-application.git'
	  mvnHome = tool 'maven'
	}

	stage('Build'){
	  if(isUnix()){
	     sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
	  }else{
	     bat (/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
	  }
	}

	stage('Unit test'){
	  junit '**/target/surefire-reports/TEST-*.xml'
	  archive 'target/*.jar'
	}

	stage('Integration test'){
	  if(isUnix()){
	     sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
	  }else{
	     bat (/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)
	  }
	}

	stage('Deploy'){
	   sh 'curl -u jenkins:123456 -T target/**.war "http://192.168.80.1:7070/manager/text/deploy?path=/dashboard&update=true"'
	}

	stage('Smoke Test'){
	   sh "curl --retry-delay 10 --retry 5 http://192.168.80.1:7070/dashboard"
	}

}





