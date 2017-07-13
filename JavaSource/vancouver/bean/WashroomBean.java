package vancouver.bean;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("Washroom")
@ApplicationScoped
public class WashroomBean implements Serializable {
	public WashroomBean () {}
}
