package pl.krawczyk.myhome.database;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import pl.krawczyk.myhome.utils.MyConsts;

/**
 *
 * @author Łukasz
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return MyConsts.DATABASE_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1");
    }
    
}
