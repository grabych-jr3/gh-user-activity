# :star: GitHub User Activity


**Github User Activity** - is a CLI application that fetches and displays GitHub user activity.

# :hammer_and_wrench: Installation:
### Quick Setup
```bash
    # Clone repository
    git clone https://github.com/grabych-jr3/gh-user-activity.git
    cd gh-user-activity
    
    # Build the project with Maven
    mvn clean package
```

# :mag: Usage
After installation you can use:
```bash
    java -jar target/github-activity.jar <github-username>
    
    # Example
    # java -jar target/github-activity.jar grabych-jr3
```

# :zap: Output
The tool will:
1. Fetch the user's recent activity from GitHub Api
2. Filter activity by event type and repository name
3. Display a readable message

# :gear: Technologies
+ Java 25
+ Jackson 3.1.0



