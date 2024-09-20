package pl.domodro.temperature.persistence;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class UppercaseNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {
    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
        return quotedUpperCase(super.toPhysicalTableName(logicalName, context));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment context) {
        return quotedUpperCase(super.toPhysicalColumnName(logicalName, context));
    }

    private Identifier quotedUpperCase(Identifier logicalName) {
        return new Identifier(logicalName.getText().toUpperCase(), true);
    }
}
