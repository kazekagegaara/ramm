# SER 502 - Project 2 , Team 6

This is the repository for SER 502 Project 2. The team members are

  - Aditya Narasimamurthy
  - Manit Singh Kalsi
  - Mohit Kumar
  - Richa Mittal

The language we made is called **RAMM** , after the first initials of each team member. The link to the youtube video is : https://www.youtube.com/watch?v=TtS71GAofFo

Following is the structure of the repository :

* data - contains various sample programs
* data/Sample_Programs/Programs - contains various examples in the language source code
* data/Sample_Programs/Respective Intermediate Code - contains intermediate code that is generated for the respective source code examples
* doc - contains all the related documents for the project, including the pitch,design and implementation PPTs, and one consolidated PDF containing the three PPTs
* doc/javadocs - contains java docs for the compiler and the runtime. We highly recommend seeing the Java docs as it provides a quick glimpse of the entire implementation.
* src - contains the entire source code
* src/compiler - contains the source code for the compiler
* src/runtime - contains the source code for the runtime
* lib - contains the dependencies used for this project (ANTLR)
* build.xml - This is the ant based build script that can be used to build and install the language
* build - This folder contains the generated class files for our language. 


# Installation

### Build
We assume the system already has ant installed. If not, please skip the build part :

```sh
$ ant init
$ ant compile
```

### Run
You can choose to build the source code again, or you can directly use the build folder. To run, please execute the following commands :

#### OSX/Unix/Linux users

```sh
$ java -cp "lib/*:build" rammCompiler fileToExecute.ramm
$ java -cp build Ramm generatedFile.rammc
```
where fileToExecute.ramm is the source file, and generatedFile.rammc is the generated intermediate code.

#### Windows users

```sh
$ java -cp "lib/*;build" rammCompiler fileToExecute.ramm
$ java -cp build Ramm generatedFile.rammc
```
where fileToExecute.ramm is the source file, and generatedFile.rammc is the generated intermediate code.

License
----

MIT