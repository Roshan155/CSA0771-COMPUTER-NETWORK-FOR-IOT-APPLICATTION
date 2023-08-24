import java.io.*; 
import java.net.*; 
public class tcpechoserver 
{ 
public tcpechoserver(int portNum) 
{ 
try 
{server = new ServerSocket(portNum);} catch(Exception e) 
{System.out.println(e);} 
} 
public void serve() 
{ try 
{ 
while(true) 
{ 
Socket client = server.accept();
BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream())); 
PrintWriter w = new PrintWriter(client.getOutputStream(),true); 
w.println("Welcome jeva Server Echo"); String line; 
do 
{ 
line = r.readLine(); if(line!=null) 
w.println("Got: "+line); 
} 
while(!line.trim().equals("bye")); client.close(); 
} 
}catch(Exception e) 
{ 
System.err.println(e); 
} 
} 
public static void main(String[] args) 
{ 
tcpechoserver s = new tcpechoserver(9999); s.serve(); 
} 
private ServerSocket server; 
} 
