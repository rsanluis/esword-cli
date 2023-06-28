### Windows Installation Instructions

#### Download and Install Java from the following link:

-  https://corretto.aws/downloads/latest/amazon-corretto-17-x64-windows-jdk.msi
-  Just keep clicking Next until you see the Install button. Click Install.

#### Download and Install Git from the following link:

-  https://gitforwindows.org/
-  Just keep clicking Next until you see the Install button. Click Install.

#### Download and Install SqliteStudio from the following link:
-  https://sqlitestudio.pl/
-  Just keep clicking Next until the application is installed.

#### Download and Install VSCode from the following link:
-  https://code.visualstudio.com/download
-  Select System Installer x64
-  Select Create a desktop icon
-  Click Next. Click Install. 

####  Launch VSCode
-  Switch to the Extensions view
-  Install the following extensions:
   - Extension Pack for Java
   - Gradle for Java
   - Gitlens

#### Using File Explorer, create a folder VSCodeProjects from your C:\Users\\[USERNAME] folder.

- This is where we will download all source projects from GitHub.

#### Close VSCode and relaunch VSCode

- From the Welcome screen, click on Clone Git Repository...
- When you see: Provide repository URL or pick a repository source, paste the following URL:
  - https://github.com/rsanluis/esword-cli.git
  - Click [Enter]
  - Then select the VSCodeProjects folder that you created in the previous step.
  - Click on Select As Repository Destination
  - Click Open to open in current window
  - Click on Yes, I trust the Authors
  - The project will take awhile to open and initialize.
- Select Terminal->New Terminal from the File menu
  - Run the following script to build the app:
  - build.bat

### Mac Instructions
- Download Visual Code from https://code.visualstudio.com/
- Download and Install Java from the following link:
  - https://corretto.aws/downloads/latest/amazon-corretto-17-x64-macos-jdk.pkg
- Edit your .zprofile and add the following variable exports:
  - export JAVA_HOME=/Library/Java/JavaVirtualMachines/amazon-corretto-17.jdk/Contents/Home
  - export PATH=$JAVA_HOME/bin:$PATH

#### Launch Visual Studio Code

- Switch to the Extensions View and install the following extensions:
  - Extension Pack for Java
  - Gradle for Java
  - Gitlens

#### Using Finder, create a folder VSCodeProjects from your /Users/[USERNAME] folder.
  - This is where we will download all source projects from GitHub.

#### Close VSCode and relaunch VSCode

- From the Welcome screen, click on Clone Git Repository...
- When you see: Provide repository URL or pick a repository source, paste the following URL:
  - https://github.com/rsanluis/esword-cli.git
  - Click [Enter]
  - Then select the VSCodeProjects folder that you created in the previous step.
  - Click on Select As Repository Destination
  - Click Open to open in current window
  - Click on Yes, I trust the Authors
  - The project will take awhile to open and initialize.
- Select Terminal->New Terminal from the File menu
  - Run the following script to build the app:
  - ./build.sh