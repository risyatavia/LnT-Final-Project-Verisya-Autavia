
public class Main {
	
	public void insertMenu(String menuName, double price, int stock) {
		
		System.out.println("PT PUDDING");
		
	    try {
	        
	        int randomNum = (int) (Math.random() * 900) + 100;
	        
	        String menuCode = "PD" + randomNum;
	        
	       
	        String sql = "INSERT INTO menu (menu_code, menu_name, price, stock) VALUES (?, ?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, menuCode);
	        stmt.setString(2, menuName);
	        stmt.setDouble(3, price);
	        stmt.setInt(4, stock);
	        stmt.executeUpdate();
	        
	        System.out.println("Menu added successfully!");
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}

	public void viewMenu() {
	    try {
	      
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
	        
	        String sql = "SELECT * FROM menu";
	        Statement stmt = conn.createStatement();
	      
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            System.out.println("Menu Code: " + rs.getString("menu_code"));
	            System.out.println("Menu Name: " + rs.getString("menu_name"));
	            System.out.println("Price: " + rs.getDouble("price"));
	            System.out.println("Stock: " + rs.getInt("stock"));
	            System.out.println("------------------------");
	        }
	        
	        conn.close();
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}


	public void updateMenu(String menuCode, double price, int stock) {
	    try {
	      
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
	        String sql = "UPDATE menu SET price = ?, stock = ? WHERE menu_code = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setDouble(1, price);
	        stmt.setInt(2, stock);
	        stmt.setString(3, menuCode);
	        int rowsUpdated = stmt.executeUpdate();
	        
	        if (rowsUpdated > 0) {
	            System.out.println("Menu updated successfully!");
	        } else {
	            System.out.println("Menu not found.");
	        }
	        conn.close();
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}

	public void deleteMenu(String menuCode) {
	    try {
	       
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
	        String sql = "DELETE FROM menu WHERE menu_code = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, menuCode);
	        int rowsDeleted = stmt.executeUpdate();
	        
	        if (rowsDeleted > 0) {
	            System.out.println("Menu deleted successfully!");
	        } else {
	            System.out.println("Menu not found.");
	        }
	        conn.close();
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
}