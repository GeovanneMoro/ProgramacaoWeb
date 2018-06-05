/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

public class ConfigurationsMySQL extends Configurations{
    public ConfigurationsMySQL(){
    super.TYPE = "mysql";
    super.HOST = "aaw9ag1ubjow00.cqvp2jcb562b.sa-east-1.rds.amazonaws.com";
    super.USER = "root";
    super.PASS = "rootroot";
    super.PORT = "3306";
    super.BASE = "javabd";
    }
}
