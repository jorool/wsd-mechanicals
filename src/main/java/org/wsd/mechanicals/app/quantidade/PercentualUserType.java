package org.wsd.mechanicals.app.quantidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.wsd.mechanicals.app.usertype.ImmutableUserType;

public class PercentualUserType extends ImmutableUserType {

	private static final long serialVersionUID = 1L;

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.NUMERIC };
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return Percentual.class;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		if (rs.wasNull()) {
			return null;
		} else {
			return Percentual.newPercentual(rs.getBigDecimal(names[0]));
		}
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.NUMERIC);
		} else {
			Percentual percentual = (Percentual) value;
			st.setBigDecimal(index, percentual.valor);
		}
	}

}
