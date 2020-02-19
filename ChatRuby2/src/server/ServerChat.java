/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author vutrunganh
 */
public class ServerChat {

    private int port;
    private static ArrayList<String> userName = new ArrayList<>();
    private Set<UserThread> userThread = new HashSet<>();
    private HashMap<String, UserThread> mapUserThread = new HashMap<>();
    ServerSocket server;

    public ServerChat(int port) {
        this.port = port;
    }

    public void whenRunning() throws IOException {
        System.out.println("Server is running... load ...");
        server = new ServerSocket(port, 0, InetAddress.getByName(null));
        while (true) {
            Socket socket = server.accept();
            UserThread user = new UserThread(socket, this);
            userThread.add(user);
            user.start();
        }
    }

    public void SendMessageToAll(String mess, UserThread excludeUser) throws IOException {
        for (UserThread user : userThread) {
            if (user != excludeUser) {
                user.sendMessage(mess);
            }
        }
    }

    public void sendAllListUseronline() throws IOException {
        for (UserThread user : userThread) {
            user.sendListUser(userName);
            System.out.println(user.toString());
        }
    }

    public void sendToUser(UserThread user, String message) throws IOException {
        // user.sendMessage(message);
        user.sendMessageToUser(message);
    }

    public void addUser(String username) {
        this.userName.add(username);
    }

    public void addUserThread(String name, UserThread user) {
        this.mapUserThread.put(name, user);

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static ArrayList<String> getUserName() {
        return userName;
    }

    public static void setUserName(ArrayList<String> userName) {
        ServerChat.userName = userName;
    }

    public Set<UserThread> getUserThread() {
        return userThread;
    }

    public void setUserThread(Set<UserThread> userThread) {
        this.userThread = userThread;
    }

    public HashMap<String, UserThread> getMapUserThread() {
        return mapUserThread;
    }

    public void setMapUserThread(HashMap<String, UserThread> mapUserThread) {
        this.mapUserThread = mapUserThread;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public static void main(String[] args) throws IOException {
        ServerChat server = new ServerChat(8000);
        server.whenRunning();
    }
}
