package org.study.java;

import java.util.Scanner;

/**
 * Created by Stone on 2017/5/5 0005.
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("****************开始游戏****************");
        System.out.println("选择游戏人物： 1.关羽\t2.张飞\t3.赵云");
        System.out.println("***************************************");
        //玩家角色编号
        int playerRoleNo = in.nextInt();
        //玩家角色名称
        String playRoleName = null;


        //系统角色编号
        int sysRoleNo = (int) (Math.random() * 3) + 1;
        //系统角色名称
        String sysRoleName = null;

        switch (playerRoleNo) {
            case 1:
                playRoleName = sysRoleName = "关羽";
                break;
            case 2:
                playRoleName = sysRoleName = "张飞";
                break;
            case 3:
                playRoleName = sysRoleName = "赵云";
                break;
        }
        System.out.println("玩家选择的角色：[" + playRoleName + "],系统选择的角色：[" + sysRoleName + "]");

        System.out.println("****************猜拳开始5局3胜****************");
        System.out.println("选择游戏人物： 1.石头\t2.剪刀\t3.布");
        System.out.println("*********************************************");
        System.out.print("请出拳：");
        int play = in.nextInt();

    }
}
