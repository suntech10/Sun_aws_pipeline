package com.revature;

import java.lang.reflect.*;
public class SqlStringGen {

    public String createSql(Class<?> clazz) {
        String[] fields = {"ps_d", "username", "password"};
        String table = "com.revature.User";
        String field = "username";
        String value = "Johnny";

        try {
            System.out.println("\tCreating sql for class: " + clazz.getSimpleName());

            // returns the array of Field objects representing the public fields
            System.out.println("Fields =");
            Field flds[] = clazz.getFields();
            String fldString = null;
            if (flds.length == 0) {
                System.out.println("Specify at least one field for sql query");
                return null;
            }
            for (int i = 0; i < flds.length; i++) {
                System.out.printf(fldString, ", %s", flds[i]);
            }
            String sqlString = "select "
                    + field + " from "
                    + table + " where " + fields + "=" + value;

            return sqlString;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }

    public void printSqlString() {
        System.out.println(createSql(getClass()));}

}