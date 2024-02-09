package com.studyasync.com.mysqlpool;

import com.mysql.cj.xdevapi.*;

import com.mysql.cj.xdevapi.Client;
import com.mysql.cj.xdevapi.ClientFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Mysqlpool {

    //https://dev.mysql.com/doc/x-devapi-userguide/en/connecting-connection-pool.html
    public static void run() throws ExecutionException, InterruptedException {



        //String connectionUrl = "mysqlx://localhost:33060/test";
        String user="root";
        String password="test";
        String connectionUrl = "mysqlx://"+user+":"+password+"localhost:33060/test";
        String poolConfig = """
                {
                    "pooling": {
                        "enabled":true, 
                        "maxSize":8,
                        "maxIdleTime":30000, 
                        "queueTimeout":10000
                    } 
                }
                """;
        ClientFactory cf = new ClientFactory();
        Client cli = cf.getClient(connectionUrl, poolConfig);
        Session session = cli.getSession();

        Schema myDb = session.getSchema("test");

        Table table = myDb.getTable("Person");
        SelectStatement statement = table.select("firstname","lastname");
        CompletableFuture<RowResult> resultSet = statement.executeAsync();
        RowResult rowResult = resultSet.get();

        while (rowResult.hasNext()){
            Row row= rowResult.next();
            String firstname = row.getString("firstname");
            String lastname = row.getString("lastname");
            System.out.println("name "+firstname+"-"+lastname);
        }
        session.close();
        cli.close();
    }
}
