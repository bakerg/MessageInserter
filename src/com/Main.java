package com;

import java.io.*;

public class Main {
	public static int insert(String message, String inputFile, String outputFile) {
		FileInputStream in = null;
		FileOutputStream out = null;
		FileOutputStream outjpg = null;
		int count = 0;
		int[] bytes;
		@SuppressWarnings("unused")
		int c;

		try {
			in = new FileInputStream(inputFile); //open the input file
			outjpg = new FileOutputStream(outputFile); //open the output file
//			out = new FileOutputStream("/Users/Geoff/Desktop/outagain.txt");

			while ((c = in.read()) != -1) { //determine the length of the file in bytes
				count++;
			}
			
			bytes = new int[count]; //initialise an array for the bytes
			
			in = new FileInputStream(inputFile); //re-open the input file so it reads from the beginning of the file
			
			for(int i = 0; i < count; i++) { //dump the contents of the file into the bytes array
				bytes[i] = in.read();
			}
			for(int i = 2000; i < 2000 + message.length(); i++) { //place message into image
				if(message.charAt(i-2000) == '1') { //avoid null pointer exceptions
					if(bytes[i] % 2 == 0) { //an even value means a 1, odd a 0.
						bytes[i] = bytes[i];
					}else {
						bytes[i] += 1;
					}
				}else if((message.charAt(i-2000) == '0')) {
					if(bytes[i] % 2 != 0) {
						bytes[i] = bytes[i];
					}else {
						bytes[i]+=1;
					}
				}
			}
			for(int i = 0; i < count; i++) {
				outjpg.write(bytes[i]);
			}
		} catch (Exception e) {
			System.out.println("File IO failed!");
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close(); //close the input stream
				} catch (IOException e) {
					System.out.println("Failed to close input stream!");
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					outjpg.close(); //close the jpeg output stream
				} catch (IOException e) {
					System.out.println("Failed to close input stream!");
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close(); //close the output stream
				} catch (IOException e) {
					System.out.println("Failed to close output stream!");
					e.printStackTrace();
				}
			}
		}
		return message.length();
	}	
	public static String extract(String inputFile, int length) {
		FileInputStream in = null;
		@SuppressWarnings("unused")
		int c;
		int count = 0;
		int[] bytes;
		String message = "";
		try {
			in = new FileInputStream(inputFile);
			while((c = in.read()) != -1) {
				count++;
			}
			bytes = new int[count];
			in = new FileInputStream(inputFile);
			if(2000 + length < count) {	
				for(int i = 0; i < 2000 + length; i++) {
					bytes[i] = in.read();
				}
				for(int i = 2000; i < 2000 + length; i++) {
					if(bytes[i] % 2 == 0) {
						message += "1";
					}else {
						message += "0";
					}
				}
			}else {
				System.out.println("Image not large enough to contain message of specified length!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				}catch(Exception e) {
					System.out.println("Failed to close input stream!");
					e.printStackTrace();
				}
			}
		}
		return message;
	}
}
