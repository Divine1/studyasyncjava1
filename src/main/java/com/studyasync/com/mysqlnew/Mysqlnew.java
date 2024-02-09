package com.studyasync.com.mysqlnew;

import com.mysql.cj.xdevapi.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Mysqlnew {

    public static void run() throws ExecutionException, InterruptedException {
        //String connectionUrl = "jdbc:mysql://localhost:3306/test";

        String connectionUrl = "mysqlx://localhost:33060/test";
        String user="root";
        String password="test";

        // Connect to server on localhost
        Session mySession = new SessionFactory().getSession(connectionUrl+"?user="+user+"&password="+password);

        Schema myDb = mySession.getSchema("test");

// Use the collection 'my_collection'
        Table table = myDb.getTable("Person");

// Specify which document to find with Collection.find() and
// fetch it from the database with .execute()

        SelectStatement statement = table.select("firstname","lastname");

// Print document
        CompletableFuture<RowResult>  resultSet = statement.executeAsync();

        /*
        rowResult.whenComplete((result,ex)->{

        });

         */
        RowResult rowResult = resultSet.get();

        while (rowResult.hasNext()){
            Row row= rowResult.next();
            String firstname = row.getString("firstname");
            String lastname = row.getString("lastname");
            System.out.println("name "+firstname+"-"+lastname);
        }


        mySession.close();
    }
}
