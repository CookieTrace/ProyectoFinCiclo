## Server :electric_plug:

```
SHELTER
│   LICENSE.md
│   README.md
│
└───Server
    │   README.md  => (YOU ARE HERE)
    │   Server.iml
    │
    ├───.idea
    │       .gitignore
    │       misc.xml
    │       modules.xml
    │       vcs.xml
    │       workspace.xml
    │
    └───src
            core.ServerCore.java
            core.Protocol.java
```

This is the server for the shelter app.
To understand the basics to this we'll need to introduce the concept of rest api
(This is not a REST API)

A rest api is a type of server that works by taking petitions and giving a certain response.
It doesn't keep the connection with the user alive for much time.
We have then to consider that rest api's are not allowed on this project due to the possibility of implementations with interfaces like Spring that takes for granted all the background process that makes it work.

Therefore, this is a bare metal rest api like server with a UDP implementation


## How to run it
To run the server, first you have to compile the project.

then just execute the core.ServerCore.class file using the command
```sh
Java core.ServerCore
```
