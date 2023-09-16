package liveProject;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import org.junit.jupiter.api.BeforeEach;

@Provider("UserProvider")
@PactFolder("target/pacts")
public class ProviderTest {

    @BeforeEach
    public void setUp()
    {
        HttpTestTarget target=new HttpTestTarget("localhost",8585);

    }
}
