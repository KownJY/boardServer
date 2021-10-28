package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDAO {

   public static DbUtils dbUtils = DbUtils.getInstance();

   public static int insBoard(BoardVO param)
   {
      int result = 0;
      Connection con = null;
      PreparedStatement ps = null;
      String sql ="INSERT INTO t_board (title, ctnt, writer)VALUES (?, ?, ?)";


      try
      {
         con = dbUtils.getCon();
         ps = con.prepareStatement(sql);
         ps.setString(1,param.getTitle());
         ps.setString(2,param.getCtnt());
         ps.setString(3,param.getWriter());
         result = ps.executeUpdate();

      }catch (Exception e)
      {
         e.printStackTrace();
      }
      finally {
         dbUtils.close(con, ps);
      }
      return  result;
   }
}
