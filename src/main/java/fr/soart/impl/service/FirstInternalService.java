package fr.soart.impl.service;

import com.test.test.test_api.PortType;
import com.test.test.test_api.Requete;
import com.test.test.test_api.Response;
import fr.soart.engine.db.BusinessCollection;
import fr.soart.impl.business.order.OrderBusiness1;
import fr.soart.impl.converter.FirstServiceToOrderBusiness1Converter;
import fr.soart.impl.model.OrderBusiness1Model;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 *
 */
@Service
@WebService(endpointInterface = "com.test.test.test_api.PortType")
public class FirstInternalService implements PortType {

    @Resource
    OrderBusiness1 business1;
    @Resource
    FirstServiceToOrderBusiness1Converter converter;

    @Resource(name = "mongoTemplate")
    private MongoOperations mongoOperation;

    @Override
    public Response testOperation(@WebParam(partName = "parameters", name = "Requete", targetNamespace = "http://test.test.com/test_api/") Requete parameters) {


        OrderBusiness1Model l = (OrderBusiness1Model) business1.call(converter.convert(parameters));

        BusinessCollection rb = new BusinessCollection();
        rb.setSpringName("rb");
        mongoOperation.save(rb);

        BusinessCollection rb2 = new BusinessCollection();
        rb2.setSpringName("rb2");
        mongoOperation.save(rb2);

        Response r = new Response();
        r.setType2ResponseField1(l.getTata());
        r.setType2ResponseField2(l.getToto());
        return r;
    }
}
