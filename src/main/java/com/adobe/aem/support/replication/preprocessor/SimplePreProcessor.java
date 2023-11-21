package com.adobe.aem.support.replication.preprocessor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.Preprocessor;
import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.ReplicationOptions;

@Component(service = Preprocessor.class, immediate = true)
public class SimplePreProcessor implements Preprocessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void preprocess(ReplicationAction arg0, ReplicationOptions arg1) throws ReplicationException {
        if (Optional.ofNullable(arg0.getPath()).isPresent()) {
            logger.info("The path set for the preprocessor is {}", arg0.getPath());
        }

        if (Optional.ofNullable(arg0.getPaths()).isPresent()) {
            List<String> paths = Arrays.asList(arg0.getPaths());
            paths.forEach(path -> logger.info("The paths set for the preprocessor is {}", path));
        }
    }

}
