import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Startup
public class InitBean {

    private static InitBean initBean;

    public static synchronized InitBean getInstance() {
        if(initBean == null) {
            initBean = new InitBean();
        }
        return initBean;
    }

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init() {
        System.err.println("************ hello");
        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("maennlich.csv"), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,Gender.MALE))
                .forEach(em::persist);

        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("weiblich.csv"),Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(a -> new Surname(a,Gender.FEMALE))
                .forEach(em::persist);
    }
}
