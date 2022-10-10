package com.Incture.oms.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class OrderIdSequence extends SequenceStyleGenerator {

	public static final String VALUE_PREFIX_PARAMETER = "prefix";
	public static final String VALUE_PREFIX_DEFAULT = "";
	
	private String prefix;
	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String numberFormat;

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		prefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT) ;
		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
	}
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int year = date.getYear() + 1900;
		String presentYear = Integer.toString(year);
		presentYear = presentYear.substring(presentYear.length()-2);
		return prefix + presentYear + String.format(numberFormat, super.generate(session, object));
	}
	
	
}
