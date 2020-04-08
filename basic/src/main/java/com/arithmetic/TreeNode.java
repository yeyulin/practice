package com.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yeyulin
 * @description: 这是一个二叉树，排序转换为list 从小到大
 * @date 2019/11/23 9:33
 * @since 2.0.7
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public List<Integer> convert(TreeNode treeNode) {
        return convert(treeNode, new ArrayList<>());
    }

    private List<Integer> convert(TreeNode treeNode, List<Integer> result) {
        if (Objects.isNull(treeNode)) {
            return result;
        }
        if (Objects.nonNull(treeNode.left)) {
            convert(treeNode.left, result);
        }
        result.add(treeNode.val);
        if (Objects.nonNull(treeNode.right)) {
            convert(treeNode.right, result);
        }
        return result;
    }

}
