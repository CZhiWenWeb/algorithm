package com.czw.algorithms.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 15:14
 * @UpdeteTime: 2020-02-24 15:14
 * @Description:文件读取工具类
 * 通过file构建bufferedInputStream,然后使用流构建scanner，用于读取文件内容
 */
public final class In {
	//Unicode UTF-8
	private static final String CHARSET_NAME="UTF-8";
	//language=English country=US for consistency with System out
	private static final Locale LOCALE=Locale.US;
	//
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
	private static final Pattern EMPTY_PATTERN = Pattern.compile("");
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

	private Scanner scanner;
	//Initializes an input stream from standard input
	public In(){
		scanner=new Scanner(new BufferedInputStream(System.in),CHARSET_NAME);
		scanner.useLocale(LOCALE);
	}
	//Initializes an input stream from a file
	public In(File file) throws Exception {
		if (file==null)
			throw new NoSuchElementException("file argument is null");
		try{
			FileInputStream fis=new FileInputStream(file);
			scanner=new Scanner(new BufferedInputStream(fis),CHARSET_NAME);
			scanner.useLocale(LOCALE);
		}catch (IOException ioe){
			throw new IOException("could not open"+file,ioe);
		}
	}

	public boolean exists(){
		return scanner!=null;
	}

	public boolean isEmpty(){
		return !scanner.hasNext();
	}

	public boolean hasNestLine(){
		return scanner.hasNextLine();
	}

	//read and returns the next line in this input stream
	public String readLine(){
		String line;
		try{
			line=scanner.nextLine();
		}catch (NoSuchElementException e){
			line=null;
		}
		return line;
	}
	//read and returns the next character in this input stream
	public char readChar(){
		scanner.useDelimiter(EMPTY_PATTERN);
		try {
			String ch=scanner.next();
			assert ch.length()==1:"In.readChar() error";
			scanner.useDelimiter(WHITESPACE_PATTERN);
			return ch.charAt(0);
		}catch (NoSuchElementException e){
			throw new NoSuchElementException("noSuchElement");
		}
	}

	public String readAll(){
		if (!scanner.hasNextLine())
			return "";
		String result=scanner.useDelimiter(EVERYTHING_PATTERN).next();
	//	let us reset delimeter anyway,since now scanner is empty
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}
	//reads the next token from this input stream and returns it
	public String readString(){
		try{
			return scanner.next();
		}catch (NoSuchElementException e){
			throw new NoSuchElementException("NoSuchEle");
		}
	}
	//reads the next token from this input stream
	public int readInt(){
		try{
			return scanner.nextInt();
		}catch (InputMismatchException e){
			String token=scanner.next();
			throw new InputMismatchException("the next token is\""+token+"\"");
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException("no more tokens are available");
		}
	}

	public double readDouble(){
		try{
			return scanner.nextDouble();
		}catch (InputMismatchException e){
			String token=scanner.next();
			throw new InputMismatchException("the next token is\""+token+"\"");
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException("no more tokens are available");
		}
	}

	public float readFloat(){
		try{
			return scanner.nextFloat();
		}catch (InputMismatchException e){
			String token=scanner.next();
			throw new InputMismatchException("the next token is\""+token+"\"");
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException("no more tokens are available");
		}
	}

	public long readLong(){
		try{
			return scanner.nextLong();
		}catch (InputMismatchException e){
			String token=scanner.next();
			throw new InputMismatchException("the next token is\""+token+"\"");
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException("no more tokens are available");
		}
	}

	public short readShort(){
		try{
			return scanner.nextShort();
		}catch (InputMismatchException e){
			String token=scanner.next();
			throw new InputMismatchException("the next token is\""+token+"\"");
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException("no more tokens are available");
		}
	}

	public byte readByte(){
		try{
			return scanner.nextByte();
		}catch (InputMismatchException e){
			String token=scanner.next();
			throw new InputMismatchException("the next token is\""+token+"\"");
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException("no more tokens are available");
		}
	}

	public boolean readBoolbean(){
		try{
			String token=readString();
			if ("true".equalsIgnoreCase(token))
				return true;
			if ("false".equalsIgnoreCase(token))
				return false;
			if ("1".equalsIgnoreCase(token))
				return true;
			if ("0".equalsIgnoreCase(token))
				return false;
			throw new InputMismatchException("the next token is\""+token+"\"");
		}catch (NoSuchElementException e){
			throw new NoSuchElementException("no more tokens are available");
		}
	}
	//Reads all remaining token from this input stream and returns them
	//as array of strings
	public String[] readAllStrings(){
		String[] tokens=WHITESPACE_PATTERN.split(readAll());
		if (tokens.length==0||tokens[0].length()>0)
			return tokens;
		String[] decapitokens=new String[tokens.length-1];
		for (int i=0;i<tokens.length-1;i++){
			decapitokens[i]=tokens[i+1];
		}
		return decapitokens;
	}
	//reads all remaining lines from this input stream and returns them
	// as array of strings
	public String[] readAllLines(){
		ArrayList<String> lines=new ArrayList<>();
		while (hasNestLine())
			lines.add(readLine());
		return lines.toArray(new String[lines.size()]);
	}
	//reads all remaining tokens from this input stream,parses them
	//as integers;and returns them as an array of integers
	public int[] readAllInts(){
		String[] fields=readAllStrings();
		int[] vals=new int[fields.length];
		for (int i=0;i<fields.length;i++){
			vals[i]=Integer.parseInt(fields[i]);
		}
		return vals;
	}

	public long[] readAllLongs(){
		String[] fields=readAllStrings();
		long[] vals=new long[fields.length];
		for (int i=0;i<fields.length;i++)
			vals[i]=Long.parseLong(fields[i]);
		return vals;
	}

	public double[] readAllDoubles(){
		String[] fields=readAllStrings();
		double[] vals=new double[fields.length];
		for (int i=0;i<fields.length;i++)
			vals[i]=Double.parseDouble(fields[i]);
		return vals;
	}
	//closes this input stream
	public void close(){
		scanner.close();
	}

	public static void main(String[] args) throws Exception {
		File file=new File("F:\\book\\tinyEWG.txt");
		if (file.exists()){
			In in=new In(file);
			//String ss=in.readString();
			//String[] s=in.readAllStrings();
			System.out.println(in.readAll());
		}
	}
}
