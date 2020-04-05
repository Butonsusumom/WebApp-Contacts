package com.tsubulko.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.tsubulko.entity.Address;
import com.tsubulko.entity.Contact;
import com.tsubulko.entity.Phone;
import com.tsubulko.entity.Photo;
import com.tsubulko.services.Manager;
import com.tsubulko.util.Addresses;
import com.tsubulko.util.ConnectorDB;
import com.tsubulko.util.Contacts;
import com.tsubulko.util.Phones;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Controller {
    /*  private final static String SQL_GET_USERINFO_BY_ID = "select * from photo where idContact=1 ";
      private Connection connection;
      private Photo user;
      public Controller() throws SQLException {
          this.connection = ConnectorDB.getConnection();;
      }
      public void closeConnection() throws SQLException {
          connection.close();
      }
      public Contact getUserInfobyId(final long id) {
          PreparedStatement ps = null;
          try {
              ps = connection.prepareStatement(SQL_GET_USERINFO_BY_ID);
             // ps.setString(1, String.valueOf(id));

              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                  Contact resultSetUser = new Contact();
                  resultSetUser.setId(id);
                  resultSetUser.setName(rs.getString(2));
                  //resultSetUser.setCity(rs.getString("city"));
                  resultSetUser.setEmail(rs.getString("email"));
                  //resultSetUser.setPhone(rs.getString("phone"));
                  return resultSetUser;
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return null;
      }
      public static void main(String[] args) {
          try {
              Controller manager = new Controller();
              Contact finduser = manager.getUserInfobyId(1);
              System.out.println(finduser);
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }*/
 }