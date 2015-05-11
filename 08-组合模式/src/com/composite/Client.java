package com.composite;

public class Client {
	
	public static void main(String[] args) {
		
		Folder folder1 = new Folder("我的文档");
		ImageFile f1 = new ImageFile("001.jpg");
		TextFile f2 = new TextFile("001.txt");
		folder1.add(f1);
		folder1.add(f2);
		
		Folder folder2 = new Folder("我的视频");
		VideoFile f3 = new VideoFile("英雄.rmvb");
		folder2.add(f3);
		
		folder1.add(folder2);
		
		folder1.KillVirus();
	}
	
}
