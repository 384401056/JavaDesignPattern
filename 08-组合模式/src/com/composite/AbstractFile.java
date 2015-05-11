package com.composite;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;


/**
 * 一个模拟杀毒软件的组合模式。
 */


/**
 * 抽象文件类
 * @author Gaoyanbin
 *
 */
public interface AbstractFile {

	void KillVirus();//杀毒方法
	
}

//图片文件
class ImageFile implements AbstractFile{

	private String name;//文件名。
	
	public ImageFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void KillVirus() {
		System.out.println("图片文件："+name+"杀毒");
	}
	
}

//文本文件
class TextFile implements AbstractFile{

	private String name;//文件名。
	
	public TextFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void KillVirus() {
		System.out.println("文本文件："+name+"杀毒");
	}
	
}

//视频文件
class VideoFile implements AbstractFile{

	private String name;//文件名。
	
	public VideoFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void KillVirus() {
		System.out.println("视频文件："+name+"杀毒");
	}
	
}

/**
 * 文件夹
 * @author Gaoyanbin
 *
 */
class Folder implements AbstractFile{

	private String name;//文件夹名称。
	private List<AbstractFile> list = new ArrayList<AbstractFile>();//存放文件夹里的子文件夹或者文件
	
	
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	//向文件夹中添加文件或者文件夹
	public void add(AbstractFile f){
		list.add(f);
	}

	//文件夹中删除文件或者文件夹
	public void remove(AbstractFile f){
		list.remove(f);
	}

	//获取文件夹中的文件或者文件夹
	public AbstractFile getChild(int index){
		return list.get(index);
	}
	


	@Override
	public void KillVirus() {
		
		System.out.println("进入文件夹："+name);
		
		for(AbstractFile file:list){
			file.KillVirus();
		}
	}

}














































