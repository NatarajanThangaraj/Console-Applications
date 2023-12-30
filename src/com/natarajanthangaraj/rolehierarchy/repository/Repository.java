package com.natarajanthangaraj.rolehierarchy.repository;

import java.util.LinkedList;
import java.util.List;

import com.natarajanthangaraj.rolehierarchy.dto.Role;

public class Repository {
	static TreeNode node;
	private static Repository repo;

	private Repository() {
	}

	public static Repository getInstance() {
		if (repo == null) {
			repo = new Repository();
		}
		return repo;
	}

	public void initRootRole(Role role) {
		if (node == null) {
			node = new TreeNode();
			node.val = role.getRootRole();
			node.left = null;
			node.right=null;
		}
	}

	public LinkedList<String> roleHierarchyList() {
		LinkedList<String> list = new LinkedList<>();
		recursive(node,list);
		return list;
	}
	public void recursive(TreeNode root,List<String> list){
        if(root==null)
        return;
            list.add(root.val);
        if(root.left==null&&root.right==null){
            return ;
        }
        if(root.left!=null){
            recursive(root.left,list);
        }
        if(root.right!=null){
            recursive(root.right,list);
        }
    }
}
