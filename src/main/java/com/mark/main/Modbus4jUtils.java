package com.mark.main;

import com.alibaba.fastjson.JSON;
import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.msg.*;
import com.serotonin.modbus4j.sero.util.queue.ByteQueue;


/**
 * modbus通讯工具类,采用modbus4j实现
 */

public class Modbus4jUtils {

	public static ByteQueue modbusTCP(String ip, int port, int start,int readLenth,int slaveId) {
		ModbusFactory modbusFactory = new ModbusFactory();
		// 设备ModbusTCP的Ip与端口，如果不设定端口则默认为502
		IpParameters params = new IpParameters();
		params.setHost(ip);
		if(502!=port){params.setPort(port);}//设置端口，默认502
		ModbusMaster tcpMaster = null;
		tcpMaster = modbusFactory.createTcpMaster(params, true);
		try {
			tcpMaster.init();
			System.out.println("===============初始化成功================");
		} catch (ModbusInitException e) {
			return null;
		}
		ModbusRequest modbusRequest=null;
		try {
			//功能码03,start 起始地址,readlenth 读取寄存器个数
			modbusRequest = new ReadHoldingRegistersRequest(slaveId, start, readLenth);
			System.out.println("創建請求"+modbusRequest.toString());
		} catch (ModbusTransportException e) {
			e.printStackTrace();
		}
		ModbusResponse modbusResponse=null;
		System.out.println("request"+JSON.toJSONString(modbusRequest));
		try {
			modbusResponse = tcpMaster.send(modbusRequest);
			System.out.println("發送請求獲 取響應"+JSON.toJSONString(modbusResponse));
		} catch (ModbusTransportException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		ByteQueue byteQueue= new ByteQueue(12);
		modbusResponse.write(byteQueue);
		System.out.println("功能码:"+modbusRequest.getFunctionCode());
		System.out.println("从站地址:"+modbusRequest.getSlaveId());
		System.out.println("收到的响应信息大小:"+byteQueue.size());
		System.out.println("收到的响应信息值:"+byteQueue);
		return byteQueue;
	}







	public static void main(String[] args) {

		Modbus4jUtils.modbusTCP("127.0.0.1", 5555, 0x46, 1, 5);


	}
}
