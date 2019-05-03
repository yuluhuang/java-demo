package com.yuluhuang.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ylh
 * @create 2018-05-17
 */

public class StaticFactoryMethod {
    public interface Service {

    }

    public interface Provider {
        Service newService();
    }

    public static class Services {
        private Services() {
        }

        private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
        public static final String DEAFULT_PROVIDER_NAME = "default";

        public static void registerDefaultProvider(Provider provider) {
            registerProvider(DEAFULT_PROVIDER_NAME, provider);
        }

        public static void registerProvider(String name, Provider provider) {
            providers.put(name, provider);
        }

        public static Service newInstance() {
            return newInstance(DEAFULT_PROVIDER_NAME);
        }

        public static Service newInstance(String name) {
            Provider provider = providers.get(name);
            if (null == provider) {
                throw new IllegalArgumentException("No Provider registered with name" + name);
            }
            return provider.newService();
        }
    }
}
