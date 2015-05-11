package com.composite;

/**
 * 组合模式的基本组成,在树型结构的体系中最为常用
*/

/*
 * 抽象组件
 * @author Gaoyanbin
 *
 */
public interface Compoment {

	void operation();
	
}

//叶子组件
interface Leaf extends Compoment{
	
}

//容器组件
interface Composite extends Compoment{
	void add(Compoment c);
	void remove(Compoment c);
	Compoment getChild(int index);
}