package customermailapplication;

import java.lang.reflect.InvocationTargetException;

public class CustomerFactory {

    protected enum CustomerType {
        Regular("Regular", RegularCustomer.class),
        Mountain("Mountain", MountainCustomer.class),
        Delinquent("Delinquent", DelinquentCustomer.class);

        private final String type;
        private final Class<?> clazz;

        private CustomerType(String type, Class<? extends Customer> clazz) {
            this.type = type;
            this.clazz = clazz;
        }

        public String getType() {
            return type;
        }

        public Customer getCustomer() {
            try {
                return (Customer) clazz.getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException
                    | InstantiationException
                    | IllegalAccessException
                    | InvocationTargetException e) {
                System.out.println(e);
                return null;
            }
        }
    }

    CustomerFactory() {

    }

    public Customer createCustomer(String type) {
        return getCustomerTypeFromUser(type);
    }

    public Customer createCustomer(int index) {
        CustomerType[] ct = CustomerType.values();
        if (--index >= ct.length) {
            return null;
        }
        return ct[index].getCustomer();
    }

    private Customer getCustomerTypeFromUser(String customerType) {
        Customer customer = null;
        for (CustomerType ct : CustomerType.values()) {
            if (ct.getType() == customerType) {
                customer = ct.getCustomer();
                break;
            }
        }
        return customer;
    }
}