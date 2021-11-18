package com.revature;

public class Driver {
    public static void main(String[] argv) {
        System.out.println("executing Java in main of Driver class");

        SqlStringGen ssg = new SqlStringGen();
        ssg.printSqlString();
    }
}
