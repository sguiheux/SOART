package fr.soart.impl.business.simple;

import fr.soart.engine.business.SimpleSoartService;
import fr.soart.engine.model.AbstractModel;
import fr.soart.impl.model.OrderBusiness1Model;
import fr.soart.impl.model.SimpleBusiness1Model;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Sample Business 1
 */
@Component
@Scope(value = "prototype")
public class SimpleSoartService1 extends SimpleSoartService {

    @Override
    public AbstractModel call(AbstractModel model) {

        logger.info("Call SimpleSoartService1");
        SimpleBusiness1Model sbm = new SimpleBusiness1Model();
        sbm.setText("azerty");
        return sbm;
    }

    @Override
    public boolean isAsynchronous() {
        return false;
    }

    @Override
    public AbstractModel convertToMyModel(AbstractModel model) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AbstractModel toModel(String model) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public SimpleBusiness1Model convert(OrderBusiness1Model m) {
        SimpleBusiness1Model model = new SimpleBusiness1Model();
        model.setText(m.getTata() + m.getToto());
        return model;
    }


}
