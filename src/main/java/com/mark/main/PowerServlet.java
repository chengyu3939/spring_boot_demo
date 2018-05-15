package com.mark.main;

//import com.cjgc.utils.Modbus4jUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PowerServlet implements Runnable{

	private Socket client;

	public PowerServlet(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {

		System.out.println("請求modbus");

//		Modbus4jUtils.modbusTCP("127.0.0.1",502,0,8,1);
		//获取Socket的输入流，用来接收从客户端发送过来的数据
		try {
			//获取Socket的输出流，用来向客户端发送数据
			PrintStream out = new PrintStream(client.getOutputStream());
			//获取Socket的输入流，用来接收从客户端发送过来的数据
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));

			boolean flag =true;
			while(flag) {

				//接收从客户端发送过来的数据
String str = buf.readLine();
				if (str == null || "".equals(str)) {
					flag = false;
					System.out.println("空");
				}else {

					out.write("我收到了".getBytes());

//					out.println(233);
					System.out.println("run "+str.length()+str);

				}
			}

			client.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("请求结束");

		}

	}


	public static void main(String[] args) throws IOException {
//*
//服务端在5555端口监听客户端请求的TCP连接
		ServerSocket server = new ServerSocket(5555);
		Socket client = null;
		boolean f = true;
		while(f){
			//等待客户端的连接，如果没有获取连接
			client = server.accept();
			System.out.println("与客户端连接成功！");
			//为每个客户端连接开启一个线程
			new Thread(new PowerServlet(client)).start();
//			f = false;
		}
		server.close();


	}


}

