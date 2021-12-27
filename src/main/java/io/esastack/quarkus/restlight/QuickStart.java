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

import esa.commons.spi.SpiLoader;
import io.esastack.commons.net.buffer.BufferAllocator;
import io.esastack.commons.net.internal.buffer.BufferProvider;
import io.esastack.commons.net.internal.http.CookieProvider;
import io.esastack.quarkus.restlight.springmvc.HelloController;
import io.esastack.restlight.core.Restlight;
import io.esastack.restlight.core.method.ResolvableParamPredicate;
import io.esastack.restlight.core.resolver.ParamResolverFactory;
import io.esastack.restlight.core.resolver.RequestEntityResolverFactory;
import io.esastack.restlight.core.resolver.ResponseEntityResolverAdviceFactory;
import io.esastack.restlight.core.resolver.ResponseEntityResolverFactory;
import io.esastack.restlight.core.spi.DefaultSerializerFactory;
import io.esastack.restlight.core.spi.ExceptionResolverFactoryProvider;
import io.esastack.restlight.core.spi.ExtensionsHandlerFactory;
import io.esastack.restlight.core.spi.FilterFactory;
import io.esastack.restlight.core.spi.FutureTransferFactory;
import io.esastack.restlight.core.spi.HandlerAdviceFactory;
import io.esastack.restlight.core.spi.HandlerFactoryProvider;
import io.esastack.restlight.core.spi.HandlerValueResolverLocatorFactory;
import io.esastack.restlight.core.spi.MappingLocatorFactory;
import io.esastack.restlight.core.spi.ParamResolverProvider;
import io.esastack.restlight.core.spi.RequestEntityResolverProvider;
import io.esastack.restlight.core.spi.ResponseEntityResolverProvider;
import io.esastack.restlight.core.spi.RouteFilterFactory;
import io.esastack.restlight.core.spi.RouteMethodLocatorFactory;
import io.esastack.restlight.core.util.RestlightVer;
import io.esastack.restlight.server.route.ExceptionHandler;
import io.esastack.restlight.server.spi.ExceptionHandlerFactory;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

@QuarkusMain
public class QuickStart {

    public static void main(String[] args) {

        final Logger LOG = Logger.getLogger(QuickStart.class);

        LOG.error("QuickStart start...");
        System.err.println(RestlightVer.version());

        System.out.println("BufferAllocator:==>" + SpiLoader.cached(BufferAllocator.class).getAll());
        System.out.println("BufferProvider:==>" + SpiLoader.cached(BufferProvider.class).getAll());
        System.out.println("CookieProvider:==>" + SpiLoader.cached(CookieProvider.class).getAll());

        System.out.println("ResolvableParamPredicate:==>" + SpiLoader.cached(ResolvableParamPredicate.class).getAll());
        System.out.println("DefaultSerializerFactory:==>" + SpiLoader.cached(DefaultSerializerFactory.class).getAll());
        System.out.println("FutureTransferFactory:==>" + SpiLoader.cached(FutureTransferFactory.class).getAll());

        System.out.println("HandlerFactoryProvider:==>" + SpiLoader.cached(HandlerFactoryProvider.class).getAll());
        System.out.println("HandlerValueResolverLocatorFactory:==>" + SpiLoader.cached(HandlerValueResolverLocatorFactory.class).getAll());
        System.out.println("MethodAdviceFactory:==>" + SpiLoader.cached(HandlerAdviceFactory.class).getAll());

        System.out.println("ParamResolverFactory:==>" + SpiLoader.cached(ParamResolverFactory.class).getAll());
        System.out.println("ResponseEntityResolverFactory:==>" + SpiLoader.cached(ResponseEntityResolverFactory.class).getAll());
        System.out.println("FilterFactory:==>" + SpiLoader.cached(FilterFactory.class).getAll());

        System.out.println("ParamResolverProvider:==>" + SpiLoader.cached(ParamResolverProvider.class).getAll());
        System.out.println("ExceptionHandler:==>" + SpiLoader.cached(ExceptionHandler.class).getAll());


        System.out.println("ResolvableParamPredicate$:==>" + SpiLoader.cached(ResolvableParamPredicate.class).getAll());
        System.out.println("ExtensionsHandlerFactory:==>" + SpiLoader.cached(ExtensionsHandlerFactory.class).getAll());
        System.out.println("FutureTransferFactory:==>" + SpiLoader.cached(FutureTransferFactory.class).getAll());

        System.out.println("HandlerFactoryProvider:==>" + SpiLoader.cached(HandlerFactoryProvider.class).getAll());
        System.out.println("MappingLocatorFactory:==>" + SpiLoader.cached(MappingLocatorFactory.class).getAll());
        System.out.println("RouteMethodLocatorFactory:==>" + SpiLoader.cached(RouteMethodLocatorFactory.class).getAll());

        System.out.println("ParamResolverFactory:==>" + SpiLoader.cached(ParamResolverFactory.class).getAll());

        System.out.println("RequestEntityResolverFactory:==>" + SpiLoader.cached(RequestEntityResolverFactory.class).getAll());
        System.out.println("ResponseEntityResolverAdviceFactory:==>" + SpiLoader.cached(ResponseEntityResolverAdviceFactory.class).getAll());
        System.out.println("ResponseEntityResolverFactory:==>" + SpiLoader.cached(ResponseEntityResolverFactory.class).getAll());

        System.out.println("ParamResolverProvider:==>" + SpiLoader.cached(ParamResolverProvider.class).getAll());
        System.out.println("RequestEntityResolverProvider:==>" + SpiLoader.cached(RequestEntityResolverProvider.class).getAll());
        System.out.println("ResponseEntityResolverProvider:==>" + SpiLoader.cached(ResponseEntityResolverProvider.class).getAll());

        System.out.println("RouteFilterFactory:==>" + SpiLoader.cached(RouteFilterFactory.class).getAll());
        System.out.println("ExceptionResolverFactoryProvider:==>" + SpiLoader.cached(ExceptionResolverFactoryProvider.class).getAll());
        System.out.println("MappingLocatorFactory:==>" + SpiLoader.cached(MappingLocatorFactory.class).getAll());

        System.out.println("RouteMethodLocatorFactory:==>" + SpiLoader.cached(RouteMethodLocatorFactory.class).getAll());

        System.out.println("ParamResolverFactory:==>" + SpiLoader.cached(ParamResolverFactory.class).getAll());
        System.out.println("RequestEntityResolverFactory:==>" + SpiLoader.cached(RequestEntityResolverFactory.class).getAll());
        System.out.println("ResponseEntityResolverFactory:==>" + SpiLoader.cached(ResponseEntityResolverFactory.class).getAll());

        System.out.println("ExceptionHandlerFactory:==>" + SpiLoader.cached(ExceptionHandlerFactory.class).getAll());
        System.out.println("RequestEntityResolverProvider:==>" + SpiLoader.cached(RequestEntityResolverProvider.class).getAll());
        System.out.println("ResponseEntityResolverProvider:==>" + SpiLoader.cached(ResponseEntityResolverProvider.class).getAll());

        Restlight restlight = Restlight.forServer();

        restlight.deployments().addController(HelloController.class, false);
        restlight.address(9999);

        restlight.start();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss.SSS");
        System.out.println(dateFormat.format(date) + ":QuickStart started...");
        LOG.error("QuickStart started...");

        restlight.await();
    }

}

