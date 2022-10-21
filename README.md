## Java-client-server-data-exchange

Client Server which uses the protocol Layer 4 UDP to send `ping` message to the server
by using DatagramSocket Client and recieve response `pong`.

### Client-Server Data Exchange
Implement a server and a client. The server shall support responding to a single “ping” message with a “pong” response. The request-response data can be strings, or simple tokens. The protocol used can be either Layer 4 (e.g. TCP, UDP), or Layer 7 (e.g. HTTP). The client, once started, must connect to the server, and start sending “ping” messages, printing the fact that the message is sent, and reporting when a “pong” response is received. Clients shall continue sending “ping” messages each second (whether responses are received or not). The server must support multiple clients simultaneously.
If the server encountered an error, it should display an error and continue working. If the client encounters an error, it should display an error and stop.
The client shall take in a program parameter indicating where to connect, and the server shall take in a program parameter specifying how to listen to incoming client connections.
High level server frameworks shall not be used (i.e. no J2EE, Spring,etc.)
Please ensure that your implementation addresses the following points. Please provide code comments, and also be able to demonstrate and explain these points as well:

## Question
How does the server handle multiple clients simultaneously
Suitability of your choice of protocol for the task
Network error handling on both the client and the server


## Answer

1. How does the server handle multiple clients simultaneously
```
Server handles clients by using a route method on ip addresses, ports and host. each broadcasted packets are assigned to a specific wildcard. 
```

2. Suitability of your choice of protocol for the task
```
Used the method UDP for faster packet request
```
