import java.sql.Connection;
import java.sql.DriverManager;


public class Logout {
	//사용자가 정상적이거나 비 정상적으로 로그아웃을 했을 경우 DB에 로그아웃을 알리기 위한 클래스
	/**
	 * @param args
	 */
	public static void client_logout(String client_id) {
		// TODO Auto-generated method stub
		 Connection conn;
		 boolean LogCheck=false;
	        try{
	            conn=DriverManager.getConnection("jdbc:mysql://"+New_Client.DBIP+":3306/TingTalk","root","dnfxmfk8");
	            //Mysql은 기본 포트가 3306
	            System.out.println("---------------------");
	            System.out.println("로그 아웃 DB접속 성공");
	            
	            
	            
	            String sql;
	            sql="update login_check set log='logout' where client_id=?;";
	            java.sql.PreparedStatement pstmt=conn.prepareStatement(sql); //매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
	          
	            
	                //로그아웃시 로그인체크를 업데이트 시킴.
		            pstmt=conn.prepareStatement(sql); //매 검색시 변화하는 값을 검색하기 위한 PreparedStatement 클래스
		            pstmt.setString(1,client_id); //동적으로 변화하는 값을 전달  만약 전달하는 값이 정수이면 setInt(index,정수) 이런 식으로 하면됨.
		            pstmt.executeUpdate();
	               
	                
	            System.out.println("---------------------");
	            conn.close(); //연결 끊기
	        }
	      catch(Exception e )
	      {
	           System.out.println("DB접속 오류 "+e);
	      }
	        
	 
	
	}

}
