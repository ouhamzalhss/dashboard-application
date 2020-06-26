node{
	def mvnHome

	stage('Prepare'){
	  git 'git@github.com:ouhamzalhss/dashboard-application.git'
	  mvnHome = tool 'maven'
	}

	stage('Build'){
	  if(isUnix()){
	     sh "'${mvnHom}/bin/mvn' -Dmaven.test.failure.ignore clean package"
	  }else{
	     bat (/"${mvnHom}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
	  }
	}

	stage('Unit test'){
	  junit '**/target/surefire-reports/TEST-*.xml'
	  archive 'target/*.jar'
	}

	stage('Integration test'){
	  if(isUnix()){
	     sh "'${mvnHom}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
	  }else{
	     bat (/"${mvnHom}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)
	  }
	}

	stage('Deploy'){
	   sh 'curl -u jenkins:123456 -T target/**.war "http://localhost:7070/manager/text/deploy?path=/dashboard&update=true"'
	}

	stage('Smoke Test'){
	   sh "curl --retry-delay 10 --retry 5 http://localhost:7070/dashboard"
	}

}





