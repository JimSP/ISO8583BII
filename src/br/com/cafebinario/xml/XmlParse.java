package br.com.cafebinario.xml;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.cafebinario.iso8583.config.LAYOUT_MASTER;
import br.com.cafebinario.iso8583.config.LAYOUT_XML;

public class XmlParse {
	private Hashtable<String, String> memory = new Hashtable<String, String>(128);
	private List<Integer> bitsPresents = new ArrayList<Integer>(128);
	
	public Hashtable<String, String> getMemory() {
		return memory;
	}

	public byte[] processFile(String fileName) throws ParserConfigurationException, SAXException, IOException {

		File file = new File(fileName);
		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = dBuilder.parse(file);

		if(doc.getDocumentElement().getNodeValue() != null)
			memory.put(doc.getDocumentElement().getNodeName(), doc.getDocumentElement().getNodeValue());

		if (doc.hasChildNodes()) {
			getNote(doc.getChildNodes());
		}
		
		return createIsoMessage();
	}
	
	public byte[] createIsoMessage(){
		Hashtable<Integer, String> buffer = new Hashtable<Integer, String>(128);
		
		Enumeration<String> enumaration = memory.keys();
		
		while(enumaration.hasMoreElements()){
			String key = enumaration.nextElement();
			
			String[] pattern = null;
			String def = LAYOUT_XML.instanceOf().getProperty(key);
			if(key != "MESSAGE" && def != null){
				pattern = def.split("[_]");
				
				int bit = 0;
				
				String[] estrutura = null;
				if("DE".equals(pattern[0].substring(0, 2))){
					bit = Integer.parseInt(pattern[0].substring(2));
					estrutura = LAYOUT_MASTER.instanceOf().getProperty(pattern[0].substring(2)).split("[,]");
				}else if("PDS".equals(pattern[0].substring(0, 3))){
					bit = Integer.parseInt(pattern[0].substring(3));
					estrutura = LAYOUT_MASTER.instanceOf().getProperty(pattern[0].substring(3)).split("[,]");
				}else if("SF".equals(pattern[0].substring(0, 2))){
					if("DE".equals(pattern[1].substring(0, 2))){
						bit = Integer.parseInt(pattern[1].substring(2));
						estrutura = LAYOUT_MASTER.instanceOf().getProperty(pattern[1].substring(2)).split("[,]");
					}else{
						bit = Integer.parseInt(pattern[1].substring(3));
						estrutura = LAYOUT_MASTER.instanceOf().getProperty(pattern[1].substring(3)).split("[,]");
					}
				}
				
				bitsPresents.add(bit);
				
				int lengthFlag = 0;
				
				String name = "";
				String lengthField = "";
				String type = "";
				String mask = "";
				String meta_data_link = "";
				String summary_tag = "";
				String value = memory.get(key);
				
				//System.out.println(key + "=" + value);

				int j = 0;
				while (j < estrutura.length) {
					if (j == 0) {
						name = estrutura[j];
					} else if (j == 1) {
						lengthField = estrutura[j];
					} else if (j == 2) {
						type = estrutura[j];

						int dif = 0;
						char compementChar = ' ';
						if ("LVAR".equals(type)) {
							lengthFlag = 1;
						} else if ("LLVAR".equals(type)) {
							lengthFlag = 2;
						} else if ("LLLVAR".equals(type)) {
							lengthFlag = 3;
						} else if ("N".equals(type)) {
							lengthFlag = 0;
							compementChar = '0';
						} else if ("Date".equals(type)) {
							lengthFlag = 0;
							compementChar = '0';
						} else if ("AN".equals(type)) {
							lengthFlag = 0;
						} else {
							lengthFlag = 0;
						}
						
						
						dif = lengthFlag - value.length();
						if(lengthFlag > 0 || dif > 0){

							String complement = "";
							int k = 0;
							while(k < dif){
								complement += compementChar;
								k++;
							}
							
							value = complement + value.length() + value;
						}
					} else if (j == 3) {
						mask = estrutura[j];
					} else if (j == 4) {
						meta_data_link = estrutura[j];
					} else if (j == 5) {
						summary_tag = estrutura[j];
					}
					j++;
				}
				
				buffer.put(bit, value);
			}
		}

		int lengthInt = 0;
		String mti = memory.get("MTI");
		String bitmap = "1";
		String contentStr = "";

		Integer[] bits = bitsPresents.toArray(new Integer[bitsPresents.size()]);
		Arrays.sort(bits);
		
		for (int bit : bits) {
			String value = buffer.get(bit);
			contentStr += value;
			lengthInt += value.length();
		}
		
		int z = 2;
		while(z <= 128){
			bitmap += Arrays.binarySearch(bits, z) < 0 ? "0" : "1";
			z++;
		}
		
		ByteBuffer byteBufferLength = ByteBuffer.allocate(4);
		byteBufferLength.putInt(lengthInt + 20);

		byte[] content = new byte[contentStr.length() + 24];
		
		System.arraycopy(byteBufferLength.array(), 0, content, 0, 4);
		System.arraycopy(mti.getBytes(), 0, content, 4, 4);
		System.arraycopy(new BigInteger(bitmap, 2).toByteArray(), 0, content, 8, 16);
		System.arraycopy(contentStr.getBytes(), 0, content, 24, lengthInt);
		return content;
	}

	private void getNote(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);

			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				memory.put(tempNode.getNodeName(), tempNode.getTextContent());

				/*
				if (tempNode.hasAttributes()) {
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						memory.put(node.getNodeName(), node.getNodeValue());
					}
				}
				*/

				if (tempNode.hasChildNodes()) {
					getNote(tempNode.getChildNodes());
				}
			}
		}
	}
}
