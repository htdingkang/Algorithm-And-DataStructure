package com.atguigu.tree;

/**
 * 顺序存储二叉树的特点：
 * 1.通常只考虑完全二叉树
 * 2.第n个元素的左子节点为 2*n+1
 * 3.第n个元素的右子节点为 2*n+2
 * 4.第n个元素的父节点  (n-1)/2
 * n 表示二叉树中的第几个元素，按 0 开始编号
 */
public class ArrayBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		//创建一个 ArrBinaryTree
		ArrayBinaryTree arrBinaryTree = new ArrayBinaryTree(arr);
		//arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
		arrBinaryTree.infixOrder(); // 4,2,5,1,6,3,7
	}

}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历

class ArrayBinaryTree {
	private int[] arr;//存储数据结点的数组

	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	//重载preOrder
	public void preOrder() {
		this.preOrder(0);
	}

	public void infixOrder() {
		this.infixOrder(0);
	}


	/**
	 * 编写一个方法，完成顺序存储二叉树的前序遍历
	 * @param index 数组的下标 
	 */
	public void preOrder(int index) {
		//如果数组为空，或者 arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		//输出当前这个元素
		System.out.println(arr[index]); 
		//向左递归遍历
		if((index * 2 + 1) < arr.length) {
			preOrder(2 * index + 1 );
		}
		//向右递归遍历
		if((index * 2 + 2) < arr.length) {
			preOrder(2 * index + 2);
		}
	}


	/**
	 * 中序
	 * @param index 数组的下标
	 */
	public void infixOrder(int index) {
		//如果数组为空，或者 arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的中序遍历");
		}
		//向左递归遍历
		if((index * 2 + 1) < arr.length) {
			infixOrder(2 * index + 1 );
		}
		//输出当前这个元素
		System.out.println(arr[index]);
		//向右递归遍历
		if((index * 2 + 2) < arr.length) {
			infixOrder(2 * index + 2);
		}
	}

	
}
