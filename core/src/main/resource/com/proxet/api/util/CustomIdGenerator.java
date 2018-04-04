package com.proxet.api.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

	private String defaultPrefix = "PRX";
	private int defaultNumber = 1;

	@Override
	public Serializable generate(SessionImplementor session, Object arg1) throws HibernateException {
		String companyId = "";
		String digits = "";
		Connection con = session.connection();
		String idLength="%03d";
		try {
			java.sql.PreparedStatement pst = con
					.prepareStatement("select COMPANY_ID from company_enroll order by created_at desc limit 1");
			ResultSet rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				companyId = rs.getString("COMPANY_ID");
				System.out.println(companyId);
				String prefix = companyId.substring(0, 3);
				String str[] = companyId.split(prefix);
				digits = String.format(idLength, Integer.parseInt(str[1]) + 1);
				System.out.println("1 :"+ digits);
				companyId = prefix.concat(digits);
			} else {
				digits = String.format(idLength, defaultNumber);
				System.out.println("2: "+digits);
				companyId = defaultPrefix.concat(digits);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companyId;
	}

}
