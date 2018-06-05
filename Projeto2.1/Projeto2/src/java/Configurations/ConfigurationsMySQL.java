/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

public class ConfigurationsMySQL extends Configurations{
    public ConfigurationsMySQL(){
    super.TYPE = "mysql";
    super.HOST = "127.0.0.1";
    super.USER = "root";
    super.PASS = "mysql";
    super.PORT = "3306";
    super.BASE = "javabd";
    }
    /*public ConfigurationsMySQL(){
    super.TYPE = "mysql";
    super.HOST = "aa1redqa56q5bdk.cqvp2jcb562b.sa-east-1.rds.amazonaws.com";
    super.USER = "root";
    super.PASS = "rootroot";
    super.PORT = "3306";
    super.BASE = "javabd";
    }*/
}
