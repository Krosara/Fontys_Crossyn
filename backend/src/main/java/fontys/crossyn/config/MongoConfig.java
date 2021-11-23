package fontys.crossyn.config;

import java.util.ArrayList;
import java.util.List;

import fontys.crossyn.converter.ZonedDateTimeReadConverter;
import fontys.crossyn.converter.ZonedDateTimeWriteConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "fontys.crossyn.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {
    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?,?>>();


    @Override
    protected String getDatabaseName() {
        return "crossyn";
    }

    @Override
    public MongoCustomConversions customConversions() {
        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());
        return new MongoCustomConversions(converters);
    }
}
