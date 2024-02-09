package com.studyasync;

import com.studyasync.com.mysqlnew.Mysqlnew;
import com.studyasync.com.mysqlpool.Mysqlpool;
import com.studyasync.com.oldApproach.MysqlOld;

import java.sql.*;
import java.util.concurrent.ExecutionException;

// https://dev.mysql.com/doc/x-devapi-userguide/en/devapi-users-introduction.html
public class Main {
    public static void main(String[] args) throws SQLException {

        //MysqlOld.run();

        try {
            //Mysqlnew.run();
            Mysqlpool.run();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}