package teste.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class GerarSqlBanco {

	public static void main(String[] args) throws IOException {
		execute("hibernatePU", "./teste.sql", Boolean.parseBoolean("true"), Boolean.parseBoolean("true"));
	}

	public static void execute(String persistenceUnitName, String destination, boolean create, boolean format) {
		System.out.println("Starting schema export");
		Ejb3Configuration cfg = new Ejb3Configuration().configure(persistenceUnitName, new Properties());
		Configuration hibernateConfiguration = cfg.getHibernateConfiguration();
		SchemaExport schemaExport = new SchemaExport(hibernateConfiguration);
		schemaExport.setOutputFile(destination);
		schemaExport.setFormat(format);
		schemaExport.setDelimiter(";");
		schemaExport.execute(true, false, false, create);
		System.out.println("Schema exported to " + destination);

	}

}
