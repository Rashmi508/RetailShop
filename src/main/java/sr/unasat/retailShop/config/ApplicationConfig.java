package sr.unasat.retailShop.config;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "sr.unasat.retailShop.controller");
        JpaConfig.getEntityManager();
        return properties;
    }
}