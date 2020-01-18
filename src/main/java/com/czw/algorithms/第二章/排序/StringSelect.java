package com.czw.algorithms.第二章.排序;

import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-10-22 09:34
 * @UpdeteTime: 2019-10-22 09:34
 * @Description:
 */
public class StringSelect {
	private static String FileName="D:\\";
	private static String FileEnd = ".yml";
	private static String SearchStr = "ms_cloud_base";
	private static Boolean CaseSensitive = true;
	private static List<String> pathList=new ArrayList<String>();
	public static int count=0;
	public static void main(String[] args) {
		List<String> resultList=new ArrayList<String>();
		for (int k=0;k<getFileList(FileName).size();k++){
			File file=new File(pathList.get(k));
			if (file.exists()){
				String s=file.toString();
				System.out.println("正在读取"+s+"文件");
				try{
					BufferedReader br=new BufferedReader(
							new InputStreamReader(new FileInputStream(new File(s)))
					);
					String lineTxt=null;
					while ((lineTxt=br.readLine())!=null){
						if (CaseSensitive){
							if (lineTxt.contains(SearchStr)){
								resultList.add("在s文件中找到了"+SearchStr);
								break;
							}
						}
					}
					br.close();
				}catch (Exception e){
					System.out.println("文件读取错误");
				}
			}
		}
		System.out.println("找到"+count+"个文件");
		System.out.println("最终结果");
		for (String s:resultList
		     ) {
			System.out.println(s);
		}
	}

	public static List<String> getFileList(String strPath){
		File dir=new File(strPath);
		File[] files=dir.listFiles();
		if (files!=null){
			for (int i=0;i<files.length;i++){
				String fileName=files[i].getName();
				count++;
				if (files[i].isDirectory()){
					getFileList(files[i].getAbsolutePath());
				}else if (fileName.endsWith(FileEnd)){
					String strFileName=files[i].getAbsolutePath();
					System.out.println("添加以.yml结尾的文件"+strFileName+"到查找数组");
					pathList.add(strFileName);
				}
			}
		}
		return pathList;
	}
}
