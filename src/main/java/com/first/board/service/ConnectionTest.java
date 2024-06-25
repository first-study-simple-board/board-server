package com.first.board.service;

public class ConnectionTest {
     public static void main(String[] args) {
    //     // java 표준인 java.sql.Connection 클래스를 import해야 한다.
    //     Connection con = null;
    //     try{
    //         // 1. 드라이버 로딩
    //         // 드라이버 인터페이스를 구현한 클래스를 로딩
    //         // mysql, oracle 등 각 벤더사 마다 클래스 이름이 다르다.
    //         // mysql은 "com.mysql.jdbc.Driver"이며, 이는 외우는 것이 아니라 구글링하면 된다.
    //         // 참고로 이전에 연동했던 jar 파일을 보면 com.mysql.jdbc 패키지에 Driver 라는 클래스가 있다.
    //         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
    //         String connectionUrl = "jdbc:sqlserver://localhost;encrypt=false;database=CRUD_DB;integratedSecurity=false;";  

    //         // @param  getConnection(url, userName, password);
    //         // @return Connection
    //         con = DriverManager.getConnection(connectionUrl, "demo1", "12345678");
    //         System.out.println("연결 성공");

    //     }
    //     catch(ClassNotFoundException e){
    //         System.out.println("드라이버 로딩 실패");
    //     }
    //     catch(SQLException e){
    //         System.out.println("에러: " + e);
    //     }
    //     finally{
    //         try{
    //             if( con != null && !con.isClosed()){
    //                 con.close();
    //             }
    //         }
    //         catch( SQLException e){
    //             e.printStackTrace();
    //         }
    //     }
     } 
}
