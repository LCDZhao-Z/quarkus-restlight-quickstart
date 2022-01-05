/*
 * Copyright 2021 OPPO ESA Stack Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.esastack.quarkus.restlight;

import esa.commons.StringUtils;
import esa.commons.logging.Logger;
import esa.commons.logging.LoggerFactory;
import esa.commons.spi.SpiLoader;
import io.esastack.quarkus.restlight.springmvc.HelloController;
import io.esastack.restlight.core.Restlight;
import io.esastack.restlight.core.spi.ResponseEntityChannelFactory;
import io.esastack.restlight.core.util.Constants;
import io.esastack.restlight.core.util.RestlightVer;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.util.Collections;

@QuarkusMain
public class QuickStart implements QuarkusApplication {

    public static void main(String[] args) {
        Quarkus.run(QuickStart.class, args);
    }

    @Override
    public int run(String... args) {
        final Logger LOG = LoggerFactory.getLogger(QuickStart.class);

        LOG.info("QuickStart start...");
        System.err.println(RestlightVer.version());

        System.out.println("ResponseEntityChannelFactory:==>" + SpiLoader.cached(ResponseEntityChannelFactory.class).getAll());


        Restlight restlight = Restlight.forServer();
        System.out.println("ResponseEntityChannelFactory:==>" + SpiLoader.cached(ResponseEntityChannelFactory.class)
                .getByFeature(restlight.deployments().server().name(),
                        true,
                        Collections.singletonMap(Constants.INTERNAL, StringUtils.empty()),
                        false));
        restlight.deployments().addController(HelloController.class, false);
        restlight.address(9999);

        restlight.start();
        LOG.info("QuickStart started...");

        restlight.await();
        return 0;
    }
}

