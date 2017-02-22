package com;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by weiluo on 2/21/17.
 *
 */
@Component("myDBSetup")
public class SetupDatabase {
    @Resource(name="dataSource")
    private DataSource dataSource;
    @Resource(name="dataResource")
    private ClassPathResource MasterDataResource;
    @Resource(name="structureResource")
    private ClassPathResource MasterStructureResource;

    private Connection connection;

    public void setConnection() {
        try{
            connection=dataSource.getConnection();
            System.out.println("Database connection is built successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void shutDown(){
        try{
            connection.close();
            System.out.println("Database connection is closed");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void ApplyStructure()  {
        setConnection();
        ScriptUtils.executeSqlScript(connection,MasterStructureResource);
        shutDown();
    }
    public void ApplyData(){
        setConnection();
        ScriptUtils.executeSqlScript(connection,MasterDataResource);
        shutDown();
    }
}
